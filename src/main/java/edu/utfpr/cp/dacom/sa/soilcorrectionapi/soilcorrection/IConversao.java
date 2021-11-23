package edu.utfpr.cp.dacom.sa.soilcorrectionapi.soilcorrection;

public interface IConversao<T, R> {

    public R converte(T valor);
}
