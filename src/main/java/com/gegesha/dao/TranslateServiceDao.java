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
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import model.WordStore;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author java
 */
@Service
public class TranslateServiceDao {

    public void getWord(String word, String source, String target) {
        try{
        JAXBContext context = JAXBContext.newInstance(WordStore.class);
        Unmarshaller um = context.createUnmarshaller();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("WordStore.xml").getPath());  
        WordStore bookstore2 = (WordStore) um.unmarshal(new FileReader(file));
        System.out.println(bookstore2.getWords().get(0).toString());
        }catch(Exception e){
    e.printStackTrace();
}

}
}
