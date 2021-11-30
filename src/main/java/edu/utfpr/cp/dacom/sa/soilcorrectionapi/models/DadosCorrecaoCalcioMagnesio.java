package edu.utfpr.cp.dacom.sa.soilcorrectionapi.models;

import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.fontenutrientes.FonteCalcioMagnesio;
import lombok.Getter;

public class DadosCorrecaoCalcioMagnesio extends DadosCorrecao {
	@Getter
    private final double participacaoAtual;
	@Getter
    private final double participacaoDesejada;
	@Getter
    private final double prnt;
	@Getter
    private final double teorCao;

    public DadosCorrecaoCalcioMagnesio(double participacaoAtual, double participacaoDesejada, FonteCalcioMagnesio fonteCalcioMagnesio, double custoFonte, double prnt, double teorCao, double teorSolo) {
        super(teorSolo, custoFonte, fonteCalcioMagnesio);
    	
    	this.participacaoAtual = participacaoAtual;
        this.participacaoDesejada = participacaoDesejada;
        this.prnt = prnt;
        this.teorCao = teorCao;
    }
}
