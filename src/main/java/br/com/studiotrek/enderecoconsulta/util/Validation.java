package br.com.studiotrek.enderecoconsulta.util;

public class Validation {
    private Validation() {
    }

    public static Boolean isCEP(String cep) {
        return cep.length() != 8;
    }
}
