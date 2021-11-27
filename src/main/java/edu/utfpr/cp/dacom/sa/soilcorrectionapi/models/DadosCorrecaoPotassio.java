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
    private final double teorSolo;

    public DadosCorrecaoPotassio(double participacaoAtual, double participacaoDesejada, FontePotassio fontePotassio, double custoFonte, double teorSolo) {
        this.participacaoAtual = participacaoAtual;
        this.participacaoDesejada = participacaoDesejada;
        this.fontePotassio = fontePotassio;
        this.custoFonte = custoFonte;
        this.teorSolo = teorSolo;
    }
}
