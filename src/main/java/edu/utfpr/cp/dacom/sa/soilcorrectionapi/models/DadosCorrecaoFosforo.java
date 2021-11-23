package edu.utfpr.cp.dacom.sa.soilcorrectionapi.models;

import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.fontenutrientes.FonteFosforo;
import lombok.Getter;

public class DadosCorrecaoFosforo {
	@Getter
    private final double teor;
	@Getter
    private final FonteFosforo fonteFosforo;
	@Getter
    private final double custoFonte;
	@Getter
    private final double eficiencia;
	
	public DadosCorrecaoFosforo(double teor, FonteFosforo fonteFosforo, double custoFonte, double eficiencia) {
		this.teor = teor;
		this.fonteFosforo = fonteFosforo;
		this.custoFonte = custoFonte;
		this.eficiencia = eficiencia;
	}
}
