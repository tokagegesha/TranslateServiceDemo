/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tornike
 */

@XmlRootElement(name="words")
public class WordStore {
    
    
    private List words;

    public List<Word> getWords() {
        return words;
    } 
    @XmlElement(name = "word")
    public void setWords(List<Word> words) {
        this.words = words;
    }
    
    
    
}
