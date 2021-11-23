package edu.utfpr.cp.dacom.sa.soilcorrectionapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.utfpr.cp.dacom.sa.soilcorrectionapi.models.DadosCorrecaoFosforo;

@RestController
public class CorrecaoFosforoController {
    
    @CrossOrigin
    @GetMapping("/correcaofosforo")
    public String equilibrioCorrecao(@RequestBody DadosCorrecaoFosforo dadosCorrecaoFosforo){
        return "Funciona a API";
    }
    
    @CrossOrigin
    @GetMapping("/")
    public String Hello() {
    	return "Funcionando";
    }
}
