package edu.utfpr.cp.dacom.sa.soilcorrectionapi.models;

import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.fontenutrientes.IFonteNutriente;
import lombok.Getter;

public abstract class DadosCorrecao {
	@Getter
    protected final IFonteNutriente fonteNutriente;
	@Getter
	protected final double custoFonte;
	@Getter
	protected final double teor;
	
	public DadosCorrecao(double teor, double custoFonte, IFonteNutriente fonteNutriente) {
		this.teor = teor;
		this.custoFonte = custoFonte;
		this.fonteNutriente = fonteNutriente;
	}

}
