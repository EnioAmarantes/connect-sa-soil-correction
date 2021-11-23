package edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.shared;

import java.util.Set;

import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.fontenutrientes.IFonteNutriente;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.fontenutrientes.NutrienteAdicional;

public interface ICorrecaoNutriente<T extends IFonteNutriente> {

    public default double calculaCusto(
        double custoFonte,
        double qtdeAplicar) {

        if ((custoFonte <= 0) || (qtdeAplicar <= 0)) {
            throw new IllegalArgumentException();
        }

        return custoFonte * qtdeAplicar / 1000;
    }

    public default Set<NutrienteAdicional> getNutrientesAdicionais(
        double qtdeAplicar,
        T fonteNutriente) {

        fonteNutriente
            .getNutrientesAdicionais()
            .forEach(
                item ->
                        item.setCorrecaoAdicional(
                                item.getTeorNutriente() * qtdeAplicar)
            );

        return fonteNutriente.getNutrientesAdicionais();
    }

    public default double calculaEficienciaNutriente(
        double qtdeNutrienteAdicionar,
        double eficienciaNutriente) {

        if ((qtdeNutrienteAdicionar <= 0) || (eficienciaNutriente <= 0)) {
            throw new IllegalArgumentException();
        }

        return qtdeNutrienteAdicionar / eficienciaNutriente;
    }
}
