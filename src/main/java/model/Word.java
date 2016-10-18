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
    private String english;
    private String russian;

    public String getEnglish() {
        return english;
    }
    
    @XmlElement(name = "english")
    public void setEnglish(String english) {
        this.english = english;
    }

    public String getRussian() {
        return russian;
    }
    
    @XmlElement(name = "russian")
    public void setRussian(String russian) {
        this.russian = russian;
    }

    public int getId() {
        return id;
    }
    
    @XmlElement(name = "id")
    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    
}
