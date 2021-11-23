package edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection;

import lombok.NonNull;

public class ConverteKgHaEmK2O
        implements IConversao<Double, Double> {

    @Override
    public Double converte(@NonNull Double valor) {

        if (valor <= 0) {
            throw new IllegalArgumentException();
        }

        return valor * 1.2;
    }

}
