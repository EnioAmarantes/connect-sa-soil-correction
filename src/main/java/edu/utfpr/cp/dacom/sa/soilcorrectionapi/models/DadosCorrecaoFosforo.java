package edu.utfpr.cp.dacom.sa.soilcorrectionapi.models;

import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.fontenutrientes.FonteFosforo;
import lombok.Getter;

public class DadosCorrecaoFosforo extends DadosCorrecao {
	@Getter
    private final double eficiencia;
	
	public DadosCorrecaoFosforo(double teor, FonteFosforo fonteFosforo, double custoFonte, double eficiencia) {
		super(teor, custoFonte, fonteFosforo);
		this.eficiencia = eficiencia;
	}
}
