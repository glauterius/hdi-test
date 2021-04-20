package br.com.teste.springtestehdi.exception;

public class NoActiveBrokenException extends RuntimeException{

    public NoActiveBrokenException() {
        super("O código que você inseriu, não retornou um corretor ativo.");
    }
}
