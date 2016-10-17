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
    @RequestMapping(value = "/getWord", method = RequestMethod.GET, produces = {"text/xml"})
    public @ResponseBody String getWord(@RequestParam String word,@RequestParam String source,@RequestParam String target) throws Exception {
      return word+"//"+source+"//"+target;
    }
    
}