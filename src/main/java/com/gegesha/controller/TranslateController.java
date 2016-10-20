/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gegesha.controller;

/**
 *
 * @author tornike
 */
import com.gegesha.dao.TranslateServiceDao;
import com.gegesha.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author java
 */
@RestController
@RequestMapping("/api")
public class TranslateController {

    @Autowired
    TranslateServiceDao dao;

    
    @RequestMapping(value = "/translate", method = RequestMethod.GET, produces = {"text/xml"})
    public @ResponseBody
    String getWord(@RequestParam String word, @RequestParam String source, @RequestParam String target) throws Exception {
        Word result = dao.getWord(word, source, target);
        if(result != null){
            return dao.convertWordToXml(result);
        }
        return dao.getWordErrorNotFound();
    }
    
    /*@RequestMapping(value = "/{req}", method = RequestMethod.GET, produces = {"text/xml"})
    public @ResponseBody
    String getWord(@PathVariable("req") String req) throws Exception {

        //translate( "butterfly", "english", "russian");
        String[] split = parseRequest(req);
        Word result = dao.getWord(split[0].trim(), split[1].trim(), split[2].trim());
        if (result != null) {
            return dao.convertWordToXml(result);
        }
        return dao.getWordErrorNotFound();
    }*/

    /*private String[] parseRequest(String req) {
        try {
            CharSequence cs = "translate";
            String rep1 = req.replace("translate", "").trim();
            String rep2 = rep1.replaceAll("[()]", "").trim();
            String rep3 = rep2.replaceAll("\"", "").trim();
            String[] split = rep3.split(",");
            return split;
        } catch (Exception e) {
          e.printStackTrace();
        }
        return null;
    }*/

}
