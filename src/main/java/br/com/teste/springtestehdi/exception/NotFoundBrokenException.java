package br.com.teste.springtestehdi.exception;

public class NotFoundBrokenException extends RuntimeException{

    public NotFoundBrokenException() {
        super("Corretor não encontrado.");
    }
}
