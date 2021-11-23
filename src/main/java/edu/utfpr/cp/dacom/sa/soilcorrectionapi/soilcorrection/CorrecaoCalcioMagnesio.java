package edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection;

import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.fontenutrientes.FonteCalcioMagnesio;

public class CorrecaoCalcioMagnesio
        implements ICorrecaoNutriente<FonteCalcioMagnesio> {

    public double calculaQuantidadeAplicar(
        double qtdeFonteAdicionar,
        double prntPercent) {

        if ((qtdeFonteAdicionar <= 0) || (prntPercent <= 0)) {
            throw new IllegalArgumentException();
        }

        return qtdeFonteAdicionar / prntPercent;
    }
}
