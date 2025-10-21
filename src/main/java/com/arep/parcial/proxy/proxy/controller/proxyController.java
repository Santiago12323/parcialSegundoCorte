package com.arep.parcial.proxy.proxy.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class proxyController {

    int iterador = 0;

    String[] urls = {"http://54.197.111.246:8080" , "http://44.223.6.251:8080"};

    @Autowired
    HttpConnectionExample httpConnectionExample;

    @RequestMapping(value = "/**")
    public ResponseEntity<?> getProxy(HttpServletRequest httpServletRequest){
        try{

            iterador = (iterador + 1) % urls.length;

            String server = urls[iterador];

            String path = httpServletRequest.getRequestURI();

            String query = httpServletRequest.getQueryString() != null ? "?" + httpServletRequest.getQueryString() : "";

            String url = server + path + query;

            System.out.println(url);

            String response = httpConnectionExample.get(url);

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getCause());
        }
    }

    @GetMapping("/client")
    public ResponseEntity<?> getClient(){
        String client = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>microservice</title>
                </head>
                <body>
                                
                    <h2> metodo </h2>
                    <input id="intput1"></input>
                                
                    <h2> lista </h2>
                    <input id="intput2"></input>
                                
                    <h2> valor </h2>
                    <input id="intput3"></input>
                                
                    <button onclick="handle()"> enviar </button>
                                
                    <br>\s
                    <div id="out"></div>
                                
                    <script>
                        function handle(){
                            const metodo = document.getElementById("intput1").value;
                            const lista = document.getElementById("intput2").value;
                            const valor = document.getElementById("intput3").value;
                                
                            const url = "/" + metodo + "?list=" + lista + "&value=" + valor;\s
                                
                            fetch(url)
                                .then(data => data.text())
                                .then(data => document.getElementById("out").textContent = data)
                        }
                    </script>
                                
                   \s
                </body>
                </html>
                """;

        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(client);
    }
}
