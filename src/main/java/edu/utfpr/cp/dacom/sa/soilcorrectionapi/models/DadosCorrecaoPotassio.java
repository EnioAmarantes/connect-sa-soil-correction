package edu.utfpr.cp.dacom.sa.soilcorrectionapi.models;

import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.fontenutrientes.FontePotassio;
import lombok.Getter;

public class DadosCorrecaoPotassio {

	@Getter
    private final double participacaoAtual;
	@Getter
    private final double participacaoDesejada;
	@Getter
    private final FontePotassio fontePotassio;
	@Getter
    private final double custoFonte;
	@Getter
    private final double teor;

    public DadosCorrecaoPotassio(double participacaoAtual, double participacaoDesejada, FontePotassio fontePotassio, double custoFonte, double teor) {
        this.participacaoAtual = participacaoAtual;
        this.participacaoDesejada = participacaoDesejada;
        this.fontePotassio = fontePotassio;
        this.custoFonte = custoFonte;
        this.teor = teor;
    }
}
