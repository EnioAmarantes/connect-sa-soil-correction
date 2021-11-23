package edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection.conversao;

public interface IConversao<T, R> {

    public R converte(T valor);
}
