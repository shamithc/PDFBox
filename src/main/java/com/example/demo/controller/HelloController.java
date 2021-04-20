package com.example.demo.controller;

import com.example.demo.pdfbox.PDFGenerator;
import com.example.demo.pdfbox.Paragraph;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/helloWorld")
    public String hellWorld(){
        new PDFGenerator().generate();
//        new Paragraph().generate();
        return "Hello World!";
    }



}
