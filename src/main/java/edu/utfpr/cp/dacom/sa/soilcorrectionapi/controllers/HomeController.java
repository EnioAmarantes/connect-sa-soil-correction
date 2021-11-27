package edu.utfpr.cp.dacom.sa.soilcorrectionapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @CrossOrigin
    @GetMapping("/")
    public String Home() {
    	return "A API SoilCorrectionAPI está funcionando e pronta para comunicar os dados.";
    }
}
