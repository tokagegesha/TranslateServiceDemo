/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gegesha.dao;

import com.gegesha.model.Word;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {

    //List to hold Employees object
    private List<Word> wordList = null;
    private Word word = null;

    //getter method for employee list
    public List<Word> getWordList() {
        return wordList;
    }

    // private int id;    
    // private String targetLenguage;
    //private String sourceLenguage;
    // private String targetWord;
    // private String sourceWord;
    boolean bId = false;
    boolean bTargetLenguage = false;
    boolean bSourceLenguage = false;
    boolean bTargetWord = false;
    boolean bSourceWord = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("word")) {
            //create a new Employee and put it in Map
            //initialize Employee object and set id attribute
            word = new Word();
            //initialize list
            if (wordList == null) {
                wordList = new ArrayList<>();
            }
        } else if (qName.equalsIgnoreCase("id")) {
            bId = true;
        } else if (qName.equalsIgnoreCase("targetWord")) {
            bTargetWord = true;
        } else if (qName.equalsIgnoreCase("targetLenguage")) {
            bTargetLenguage = true;
        } else if (qName.equalsIgnoreCase("sourceWord")) {
            bSourceWord = true;
        } else if (qName.equalsIgnoreCase("sourceLenguage")) {
            bSourceLenguage = true;
        }
    }

    /*<targetWord>djava</targetWord>
        <targetLenguage>russian</targetLenguage>
        <sourceWord>java</sourceWord>
        <sourceLenguage>english</sourceLenguage>*/
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("word")) {
            //add Employee object to list
            wordList.add(word);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bId) {
            //age element, set Employee age
            word.setId(new String(ch, start, length));
            bId = false;
        } 
        else if (bTargetWord) {
            word.setTargetWord(new String(ch, start, length));
            bTargetWord = false;
        }
        else if (bTargetLenguage) {
            word.setTargetLenguage(new String(ch, start, length));
            bTargetLenguage = false;
        } else if (bSourceWord) {
            word.setSourceWord(new String(ch, start, length));
            bSourceWord = false;
        } else if (bSourceLenguage) {
            word.setSourceLenguage(new String(ch, start, length));
            bSourceLenguage = false;
        }
    }
}
