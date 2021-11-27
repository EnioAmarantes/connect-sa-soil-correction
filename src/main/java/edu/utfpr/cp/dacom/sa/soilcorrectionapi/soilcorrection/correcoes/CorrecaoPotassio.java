package edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.correcoes;

import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.fontenutrientes.FontePotassio;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.shared.ICorrecaoNutriente;
import edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.shared.ICorrecaoNutrienteQuantidadeAplicar;

public class CorrecaoPotassio
        implements
            ICorrecaoNutriente<FontePotassio>,
            ICorrecaoNutrienteQuantidadeAplicar<FontePotassio> {

    public double calculaNecessidadeAdicionarCMolcDm3 (
        double teorSolo,
        double participacaoCTCExistente,
        double participacaoCTCDesejada) {

            if ((teorSolo <= 0) || (participacaoCTCExistente <= 0) || (participacaoCTCDesejada <= 0)) {
                throw new IllegalArgumentException();
            }

            return (teorSolo
                    * participacaoCTCDesejada
                    / participacaoCTCExistente)
                    - teorSolo;
    }

}
