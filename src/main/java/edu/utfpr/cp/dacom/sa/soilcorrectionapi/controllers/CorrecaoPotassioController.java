package edu.utfpr.cp.dacom.sa.soilcorrectionapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.utfpr.cp.dacom.sa.soilcorrectionapi.models.DadosCorrecaoFosforo;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.models.DadosCorrecaoPotassio;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.models.ResultadoCorrecaoFosforo;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.models.ResultadoCorrecaoPotassio;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.conversao.ConverteCMolcDm3EmMgDm3;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.conversao.ConverteKgHaEmK2O;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.conversao.ConverteKgHaEmP2O5;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.conversao.ConverteMgDm3EmKgHa;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.correcoes.CorrecaoFosforo;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.correcoes.CorrecaoPotassio;

@RestController
public class CorrecaoPotassioController {
	
	@CrossOrigin
	@PostMapping("/correcaopotassio")
	public ResultadoCorrecaoPotassio equilibrioCorrecao(@RequestBody DadosCorrecaoPotassio dadosCorrecaoPotassio){
		
		CorrecaoPotassio correcaoPotassio = new CorrecaoPotassio();
		
		var necessidadeCMolcDM3 = correcaoPotassio.calculaNecessidadeAdicionarCMolcDm3(
				dadosCorrecaoPotassio.getTeor(),
				dadosCorrecaoPotassio.getParticipacaoAtual(), 
				dadosCorrecaoPotassio.getParticipacaoDesejada());
		
        var teorPotassioMgDM3 = new ConverteCMolcDm3EmMgDm3().converte(necessidadeCMolcDM3); 
        var teorPotassioKgHa = new ConverteMgDm3EmKgHa().converte(teorPotassioMgDM3);  
        var teorPotassioK20 = new ConverteKgHaEmK2O().converte(teorPotassioKgHa);
        var eficienciaNutriente = correcaoPotassio.calculaEficienciaNutriente(teorPotassioK20, 0.85);
 
        var qtdAplicar = correcaoPotassio.calculaQuantidadeAplicar(eficienciaNutriente,
                dadosCorrecaoPotassio.getFontePotassio());
        
        var custoHa = correcaoPotassio.calculaCusto(qtdAplicar, dadosCorrecaoPotassio.getCustoFonte());
        var nutrientesAdicionais = correcaoPotassio.getNutrientesAdicionais(
                qtdAplicar,
                dadosCorrecaoPotassio.getFontePotassio());
	
	    return new ResultadoCorrecaoPotassio(qtdAplicar, custoHa, nutrientesAdicionais);
  }
}