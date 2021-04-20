package br.com.teste.springtestehdi.service;

import br.com.teste.springtestehdi.exception.BussinesException;
import br.com.teste.springtestehdi.exception.NoActiveBrokenException;
import br.com.teste.springtestehdi.exception.NotFoundBrokenException;
import br.com.teste.springtestehdi.integration.CorretorIntegration;
import br.com.teste.springtestehdi.integration.StatusCorretorIntegration;
import br.com.teste.springtestehdi.model.CorretorModel;


import br.com.teste.springtestehdi.repository.CorretorRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class CorretorService {

    @Autowired
    private CorretorIntegration integrationCorretor;

    @Autowired
    private StatusCorretorIntegration integrationStatus;

    @Autowired
    private CorretorRepository repository;

    @SneakyThrows
    public CorretorModel getCorretor(String document) {
        CorretorModel corretor = new CorretorModel();

        corretor = getInfoCorretor(document);
        if (ObjectUtils.isEmpty(corretor)) {
            throw new NotFoundBrokenException();
        }else if (ObjectUtils.isEmpty(corretor.getCode())) {
            throw new BussinesException("O code no correto esta vazio! Por favor, verificar cadastro");
        }

        CorretorModel statusCorretor = getStatusCorretor(corretor.getCode());
        corretor.setActive(statusCorretor.isActive());
        corretor.setCommissionRate((statusCorretor.getCommissionRate()));


        if (corretor.isActive())
            return corretor;
        else
            throw new NoActiveBrokenException();
    }

    private CorretorModel getInfoCorretor(String document) {
        List<CorretorModel> corretores = integrationCorretor.getCorretor(document);

        Optional<CorretorModel> corretorModel = corretores.stream()
                .filter(CorretorModel -> CorretorModel.getDocument().equals(document))
                .findFirst();
        return (corretorModel.isPresent())? corretorModel.get() : null;
    }

    private CorretorModel getStatusCorretor(String code) {
        List<CorretorModel> corretores = integrationStatus.getStatus(code);

        Optional<CorretorModel> corretorModel = corretores.stream().filter(CorretorModel -> CorretorModel.getCode().equals(code))
                .findFirst();
        return (corretorModel.isPresent())? corretorModel.get() : null;
    }

    public CorretorModel putCorretor(CorretorModel corretor) {
        if (repository.existsById(corretor.getId()))
            return repository.save(corretor);
        else
            throw new NotFoundBrokenException();
    }
}
