package edu.utfpr.cp.dacom.sa.soilcorrectionapi.models;

import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.fontenutrientes.FontePotassio;
import lombok.Getter;

public class DadosCorrecaoPotassio extends DadosCorrecao {

	@Getter
    private final double participacaoAtual;
	@Getter
    private final double participacaoDesejada;

    public DadosCorrecaoPotassio(double participacaoAtual, double participacaoDesejada, FontePotassio fontePotassio, double custoFonte, double teor) {
        super(teor, custoFonte, fontePotassio);
        
    	this.participacaoAtual = participacaoAtual;
        this.participacaoDesejada = participacaoDesejada;
    }
}
