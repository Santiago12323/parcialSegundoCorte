package com.arep.parcial.proxy.proxy.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class proxyController {

    int iterador = 0;

    String[] urls = {"http://localhost:8080" , "http://localhost:8080"};

    @Autowired
    HttpConnectionExample httpConnectionExample;

    @RequestMapping(value = "/**")
    public ResponseEntity<?> getProxy(HttpServletRequest httpServletRequest){
        try{

            iterador = (iterador + 1) % urls.length;

            String server = urls[iterador];

            String path = httpServletRequest.getContextPath();

            String query = httpServletRequest.getQueryString() != null ? "?" + httpServletRequest.getQueryString() : "";

            String url = server + path + query;

            String response = httpConnectionExample.get(url);

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getCause());
        }
    }
}
