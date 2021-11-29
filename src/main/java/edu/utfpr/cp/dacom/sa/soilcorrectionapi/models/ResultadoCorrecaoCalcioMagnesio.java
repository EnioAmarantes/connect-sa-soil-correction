package edu.utfpr.cp.dacom.sa.soilcorrectionapi.models;

import java.util.Set;

import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.fontenutrientes.NutrienteAdicional;
import lombok.Getter;

public class ResultadoCorrecaoCalcioMagnesio {
	@Getter
    private final double qtdAplicar;
	@Getter
    private final double custoHa;
	@Getter
    private final Set<NutrienteAdicional> nutrientesAdicionais;

    public ResultadoCorrecaoCalcioMagnesio(double qtdAplicar, double custoHa, Set<NutrienteAdicional> nutrientesAdicionais) {
        this.qtdAplicar = qtdAplicar;
        this.custoHa = custoHa;
        this.nutrientesAdicionais = nutrientesAdicionais;
    }
}
