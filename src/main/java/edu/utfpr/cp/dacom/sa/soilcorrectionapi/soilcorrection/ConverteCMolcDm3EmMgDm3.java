package edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection;

import lombok.NonNull;

public class ConverteCMolcDm3EmMgDm3
        implements IConversao<Double, Double> {

    @Override
    public Double converte(@NonNull Double valor) {

        if (valor <= 0) {
            throw new IllegalArgumentException();
        }

        return valor * 391;
    }

}
