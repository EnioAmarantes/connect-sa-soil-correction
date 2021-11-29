package edu.utfpr.cp.dacom.sa.soilcorrectionapi.models;

import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.fontenutrientes.FonteCalcioMagnesio;
import lombok.Getter;

public class DadosCorrecaoCalcioMagnesio {
	@Getter
    private final double participacaoAtual;
	@Getter
    private final double participacaoDesejada;
	@Getter
    private final FonteCalcioMagnesio fonteCalcioMagnesio;
	@Getter
    private final double custoFonte;
	@Getter
    private final double prnt;
	@Getter
    private final double teorCao;
	@Getter
	private final double teorSolo;

    public DadosCorrecaoCalcioMagnesio(double participacaoAtual, double participacaoDesejada, FonteCalcioMagnesio fonteCalcioMagnesio, double custoFonte, double prnt, double teorCao, double teorSolo) {
        this.participacaoAtual = participacaoAtual;
        this.participacaoDesejada = participacaoDesejada;
        this.fonteCalcioMagnesio = fonteCalcioMagnesio;
        this.custoFonte = custoFonte;
        this.prnt = prnt;
        this.teorCao = teorCao;
        this.teorSolo = teorSolo;
    }
}
