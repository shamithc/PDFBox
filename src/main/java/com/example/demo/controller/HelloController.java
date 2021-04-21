package com.example.demo.controller;

import com.example.demo.pdfbox.FRSGenerator;
import com.example.demo.pdfbox.PDFGenerator;
import com.example.demo.pdfbox.Paragraph;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HelloController {

    @GetMapping("/helloWorld")
    public String hellWorld() throws IOException {
//        new PDFGenerator().generate();
//        new PDFGenerator().generateV1();
//        new Paragraph().generate();
        new FRSGenerator().generate();
        return "Hello World!";
    }



}
