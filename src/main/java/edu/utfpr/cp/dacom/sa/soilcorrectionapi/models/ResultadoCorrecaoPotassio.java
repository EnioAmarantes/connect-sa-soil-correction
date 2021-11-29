package edu.utfpr.cp.dacom.sa.soilcorrectionapi.models;

import lombok.Getter;
import java.util.Set;

import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.fontenutrientes.NutrienteAdicional;

public class ResultadoCorrecaoPotassio {
	
	@Getter
    private final double qtdAplicar;
	@Getter
    private final double custoHa;
	@Getter
    private final Set<NutrienteAdicional> nutrientesAdicionais;

    public ResultadoCorrecaoPotassio(double qntAplicar, double custoHa, Set<NutrienteAdicional> nutrientesAdicionais) {
        this.qtdAplicar = qntAplicar;
        this.custoHa = custoHa;
        this.nutrientesAdicionais = nutrientesAdicionais;
    }

}
