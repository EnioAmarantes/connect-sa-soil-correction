package edu.utfpr.cp.dacom.sa.soilcorrectionapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.utfpr.cp.dacom.sa.soilcorrectionapi.models.DadosCorrecaoCalcioMagnesio;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.models.ResultadoCorrecaoCalcioMagnesio;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.correcoes.CorrecaoCalcioMagnesio;

@RestController
public class CorrecaoCalcioMagnesioController {

    @CrossOrigin
    @PostMapping("/correcaocalciomagnesio")
    public ResultadoCorrecaoCalcioMagnesio equilibrioCorrecao(@RequestBody DadosCorrecaoCalcioMagnesio dadosCorrecaoCalcioMagnesio) {
        CorrecaoCalcioMagnesio correcaoCalcioMagnesio = new CorrecaoCalcioMagnesio();

        var qtdAplicar = correcaoCalcioMagnesio.calculaQuantidadeAplicar(dadosCorrecaoCalcioMagnesio.getParticipacaoDesejada(), dadosCorrecaoCalcioMagnesio.getPrnt());
        var custoHa = correcaoCalcioMagnesio.calculaCusto(dadosCorrecaoCalcioMagnesio.getCustoFonte(), qtdAplicar);
        var nutrientesAdicionais = correcaoCalcioMagnesio.getNutrientesAdicionais(qtdAplicar, dadosCorrecaoCalcioMagnesio.getFonteCalcioMagnesio());


        return new ResultadoCorrecaoCalcioMagnesio(qtdAplicar, custoHa, nutrientesAdicionais);
    }
}