package edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.fontenutrientes;

import java.util.Set;

public interface IFonteNutriente {

    public double getTeorFonte();
    public Set<NutrienteAdicional> getNutrientesAdicionais();
}
