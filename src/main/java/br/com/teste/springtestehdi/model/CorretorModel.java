package br.com.teste.springtestehdi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "corretor")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CorretorModel {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;
    private String document;
    private String code;
    private LocalDate createDate;
    private String commissionRate;
    @JsonProperty("active")
    @Column(name = "active")
    private boolean isActive;
}
