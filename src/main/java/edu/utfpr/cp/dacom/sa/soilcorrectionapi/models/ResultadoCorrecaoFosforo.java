package edu.utfpr.cp.dacom.sa.soilcorrectionapi.models;

import java.util.Set;
import lombok.Getter;

import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.fontenutrientes.NutrienteAdicional;

public class ResultadoCorrecaoFosforo {
	@Getter
	private final double qtdAplicar;
	@Getter
	private final double custoHa;
	@Getter
	private final Set<NutrienteAdicional> nutrientesAdicionais;
	
	public ResultadoCorrecaoFosforo(double qtdAplicar, double custoHa, Set<NutrienteAdicional> nutrientesAdicionais)
	{
		this.qtdAplicar = qtdAplicar;
		this.custoHa = custoHa;
		this.nutrientesAdicionais = nutrientesAdicionais;
	}
	
}
