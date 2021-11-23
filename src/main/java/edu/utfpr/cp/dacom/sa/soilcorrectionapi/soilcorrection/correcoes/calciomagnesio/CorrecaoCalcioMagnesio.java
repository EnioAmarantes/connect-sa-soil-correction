package edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.correcoes.calciomagnesio;

import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.fontenutrientes.FonteCalcioMagnesio;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.shared.ICorrecaoNutriente;

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
