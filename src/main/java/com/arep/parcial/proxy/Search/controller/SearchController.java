package com.arep.parcial.proxy.Search.controller;

import com.arep.parcial.proxy.Search.Response;
import com.arep.parcial.proxy.Search.service.port.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/linearsearch")
    public ResponseEntity<?> getLinear(@RequestParam String list, @RequestParam int value){
        try{
            Response response = searchService.getLinear(list, value);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getCause());
        }
    }


    @GetMapping("/binarysearch")
    public ResponseEntity<?> getBynary(@RequestParam String list, @RequestParam int value){
        try{
            Response response = searchService.getBYnary(list,value);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getCause());
        }
    }

}
