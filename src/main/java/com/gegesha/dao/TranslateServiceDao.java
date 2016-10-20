/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gegesha.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import com.gegesha.model.Word;
import com.gegesha.model.WordError;
import com.gegesha.model.WordStore;
import java.io.IOException;
import java.net.URL;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

/**
 *
 * @author java
 */
@Service
public class TranslateServiceDao {

    public Word getWord(String word, String source, String target) {
        /*try {
            JAXBContext context = JAXBContext.newInstance(WordStore.class);
            Unmarshaller um = context.createUnmarshaller();
            WordStore words = (WordStore) um.unmarshal(this.getClass().getClassLoader().getResource("WordStore.xml"));
            List<Word> wordList = words.getWords();
            for (Word w : wordList) {
                if (w.getSourceLenguage().equals(source) && w.getSourceWord().equals(word) && w.getTargetLenguage().equals(target)) {
                    return w;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
          SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    try {
        SAXParser saxParser = saxParserFactory.newSAXParser();
        MyHandler handler = new MyHandler();
        
        ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource("WordStore.xml").getFile());
        saxParser.parse(file, handler);
        List<Word> wordList = handler.getWordList();
        for (Word w : wordList) {
                if (w.getSourceLenguage().equals(source) && w.getSourceWord().equals(word) && w.getTargetLenguage().equals(target)) {
                    return w;
                }
            } 
    } catch (Exception e) {
        e.printStackTrace();
    }
        
        return null;

    }

    public String convertWordToXml(Word word) {
        String xmlString="";
        try {
            JAXBContext context = JAXBContext.newInstance(Word.class);
            Marshaller m = context.createMarshaller();
            //for pretty-print XML in JAXB
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // Write to File
            StringWriter sw = new StringWriter();
            m.marshal(word, sw);
            xmlString = sw.toString();
            return xmlString;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getWordErrorNotFound() {
        String xmlString="";
        try {
            WordError wordError = new WordError();
            wordError.setDescription("translate not found");
            JAXBContext context = JAXBContext.newInstance(WordError.class);
            Marshaller m = context.createMarshaller();
            //for pretty-print XML in JAXB
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // Write to File
            StringWriter sw = new StringWriter();
            m.marshal(wordError, sw);
            xmlString = sw.toString();
            return xmlString;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
