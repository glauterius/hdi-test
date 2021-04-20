package br.com.teste.springtestehdi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CorretorDataModel {
    private String code;
    private Boolean active;
    private String commissionRate;
}
