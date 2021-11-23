package edu.utfpr.cp.dacom.sa.soilcorrectionapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.utfpr.cp.dacom.sa.soilcorrectionapi.models.DadosCorrecaoFosforo;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.models.ResultadoCorrecaoFosforo;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.conversao.ConverteKgHaEmP2O5;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.conversao.ConverteMgDm3EmKgHa;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.correcoes.fosforo.CorrecaoFosforo;

@RestController
public class CorrecaoFosforoController {
    
    @CrossOrigin
    @PostMapping("/correcaofosforo")
    public ResultadoCorrecaoFosforo equilibrioCorrecao(@RequestBody DadosCorrecaoFosforo dadosCorrecaoFosforo){
    	
    	CorrecaoFosforo correcaoFosforo = new CorrecaoFosforo();
    	System.out.println(dadosCorrecaoFosforo.getTeor());
    	
    	var teorFosforoAdicionarKgHa = new ConverteMgDm3EmKgHa().converte(dadosCorrecaoFosforo.getTeor());
    	var teorFosforoAdicionarP2O5 = new ConverteKgHaEmP2O5().converte(teorFosforoAdicionarKgHa);
    	var necessidadeFosforo = correcaoFosforo.calculaEficienciaNutriente(teorFosforoAdicionarP2O5, (dadosCorrecaoFosforo.getEficiencia() / 100));
    	
        var qtdAplicar = correcaoFosforo.calculaQuantidadeAplicar(necessidadeFosforo,
                dadosCorrecaoFosforo.getFonteFosforo());
        var custoHa = correcaoFosforo.calculaCusto(qtdAplicar, dadosCorrecaoFosforo.getCustoFonte());
        var nutrientesAdicionais = correcaoFosforo.getNutrientesAdicionais(
            qtdAplicar, 
            dadosCorrecaoFosforo.getFonteFosforo());

        return new ResultadoCorrecaoFosforo(qtdAplicar, custoHa, nutrientesAdicionais);
    }
    
    @CrossOrigin
    @GetMapping("/")
    public String Hello() {
    	System.out.println("Solicitado GetHello");
    	return "Funcionando";
    }
}
