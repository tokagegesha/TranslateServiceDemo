/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tornike
 */
@XmlRootElement(name = "word")
public class Word {
    
    private int id;    
    private String targetLenguage;
    private String sourceLenguage;
    private String targetWord;
    private String sourceWord;

    public int getId() {
        return id;
    }

    public String getTargetLenguage() {
        return targetLenguage;
    }

    @XmlElement(name = "targetLenguage")
    public void setTargetLenguage(String targetLenguage) {
        this.targetLenguage = targetLenguage;
    }

    public String getSourceLenguage() {
        return sourceLenguage;
    }
    @XmlElement(name = "sourceLenguage")
    public void setSourceLenguage(String sourceLenguage) {
        this.sourceLenguage = sourceLenguage;
    }

    public String getTargetWord() {
        return targetWord;
    }

    @XmlElement(name = "targetWord")
    public void setTargetWord(String targetWord) {
        this.targetWord = targetWord;
    }

    public String getSourceWord() {
        return sourceWord;
    }

    @XmlElement(name = "sourceWord")
    public void setSourceWord(String sourceWord) {
        this.sourceWord = sourceWord;
    }
    
    @XmlElement(name = "id")
    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    
}
