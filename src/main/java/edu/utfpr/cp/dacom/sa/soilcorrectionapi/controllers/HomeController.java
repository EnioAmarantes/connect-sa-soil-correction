package edu.utfpr.cp.dacom.sa.soilcorrectionapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.utfpr.cp.dacom.sa.soilcorrectionapi.models.DadosCorrecaoCalcioMagnesio;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.models.DadosCorrecaoFosforo;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.models.DadosCorrecaoPotassio;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.models.ResultadoCorrecao;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.conversao.ConverteCMolcDm3EmMgDm3;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.conversao.ConverteKgHaEmK2O;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.conversao.ConverteKgHaEmP2O5;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.conversao.ConverteMgDm3EmKgHa;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.correcoes.CorrecaoCalcioMagnesio;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.correcoes.CorrecaoFosforo;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.correcoes.CorrecaoPotassio;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.fontenutrientes.FonteCalcioMagnesio;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.fontenutrientes.FonteFosforo;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.fontenutrientes.FontePotassio;

@RestController
public class HomeController {
    @CrossOrigin
    @GetMapping("/")
    public String Home() {
    	return "A API SoilCorrectionAPI está funcionando e pronta para comunicar os dados.";
    }
    
    @CrossOrigin
	@PostMapping("/correcaopotassio")
	public ResultadoCorrecao equilibrioCorrecao(@RequestBody DadosCorrecaoPotassio dadosCorrecaoPotassio){
		
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
                (FontePotassio) dadosCorrecaoPotassio.getFonteNutriente());
        
        var custoHa = correcaoPotassio.calculaCusto(qtdAplicar, dadosCorrecaoPotassio.getCustoFonte());
        var nutrientesAdicionais = correcaoPotassio.getNutrientesAdicionais(
                qtdAplicar,
                (FontePotassio) dadosCorrecaoPotassio.getFonteNutriente());
	
	    return new ResultadoCorrecao(qtdAplicar, custoHa, nutrientesAdicionais);
    }
    
    @CrossOrigin
    @PostMapping("/correcaofosforo")
    public ResultadoCorrecao equilibrioCorrecao(@RequestBody DadosCorrecaoFosforo dadosCorrecaoFosforo){
    	
    	CorrecaoFosforo correcaoFosforo = new CorrecaoFosforo();
    	
    	var teorFosforoAdicionarKgHa = new ConverteMgDm3EmKgHa().converte(dadosCorrecaoFosforo.getTeor());
    	var teorFosforoAdicionarP2O5 = new ConverteKgHaEmP2O5().converte(teorFosforoAdicionarKgHa);
    	var necessidadeFosforo = correcaoFosforo.calculaEficienciaNutriente(teorFosforoAdicionarP2O5, (dadosCorrecaoFosforo.getEficiencia() / 100));
    	
        var qtdAplicar = correcaoFosforo.calculaQuantidadeAplicar(necessidadeFosforo,
                (FonteFosforo) dadosCorrecaoFosforo.getFonteNutriente());
        var custoHa = correcaoFosforo.calculaCusto(qtdAplicar, dadosCorrecaoFosforo.getCustoFonte());
        var nutrientesAdicionais = correcaoFosforo.getNutrientesAdicionais(
            qtdAplicar, 
            (FonteFosforo) dadosCorrecaoFosforo.getFonteNutriente());

        return new ResultadoCorrecao(qtdAplicar, custoHa, nutrientesAdicionais);
    }
    
    @CrossOrigin
    @PostMapping("/correcaocalciomagnesio")
    public ResultadoCorrecao equilibrioCorrecao(@RequestBody DadosCorrecaoCalcioMagnesio dadosCorrecaoCalcioMagnesio) {
        CorrecaoCalcioMagnesio correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        var qtdAplicar = correcaoCalcioMagnesio.calculaQuantidadeAplicar(dadosCorrecaoCalcioMagnesio.getParticipacaoDesejada(), dadosCorrecaoCalcioMagnesio.getPrnt());
        var custoHa = correcaoCalcioMagnesio.calculaCusto(dadosCorrecaoCalcioMagnesio.getCustoFonte(), qtdAplicar);
        var nutrientesAdicionais = correcaoCalcioMagnesio.getNutrientesAdicionais(qtdAplicar, (FonteCalcioMagnesio) dadosCorrecaoCalcioMagnesio.getFonteNutriente());


        return new ResultadoCorrecao(qtdAplicar, custoHa, nutrientesAdicionais);
    }
}
