package br.com.teste.springtestehdi.handle;

import br.com.teste.springtestehdi.exception.BussinesException;
import br.com.teste.springtestehdi.exception.NoActiveBrokenException;
import br.com.teste.springtestehdi.exception.NotFoundBrokenException;
import br.com.teste.springtestehdi.exception.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandle {

    private final Integer HTTP_CODE_BUSSINES_EXCEPTON = 498;

    @ExceptionHandler(NoActiveBrokenException.class)
    public ResponseEntity<ErrorDTO> getError(NoActiveBrokenException exception){
        return ResponseEntity.status(HTTP_CODE_BUSSINES_EXCEPTON).body(ErrorDTO.builder()
                .status(HTTP_CODE_BUSSINES_EXCEPTON)
                .error(exception.getMessage())
                .message("Mensagem detalhada!").build()
        );
    }

    @ExceptionHandler(NotFoundBrokenException.class)
    public ResponseEntity<ErrorDTO> getError(NotFoundBrokenException exception){
        return ResponseEntity.status(HTTP_CODE_BUSSINES_EXCEPTON).body(ErrorDTO.builder()
                .status(HTTP_CODE_BUSSINES_EXCEPTON)
                .error(exception.getMessage())
                .message("Mensagem detalhada!").build()
        );
    }

    @ExceptionHandler(BussinesException.class)
    public ResponseEntity<ErrorDTO> getError(BussinesException exception){
        return ResponseEntity.status(HTTP_CODE_BUSSINES_EXCEPTON).body(ErrorDTO.builder()
                .status(HTTP_CODE_BUSSINES_EXCEPTON)
                .error(exception.getMessage())
                .message("Mensagem detalhada!").build()
        );
    }
}
