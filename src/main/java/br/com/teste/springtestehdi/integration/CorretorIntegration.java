package br.com.teste.springtestehdi.integration;

import br.com.teste.springtestehdi.model.CorretorModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class CorretorIntegration {

    @Value( "${config.url.broker}" )
    private String url;

    public List<CorretorModel> getCorretor(String corretor){
        RestTemplate restTemplate = new RestTemplate();
        return Arrays.asList(restTemplate.getForObject( url, CorretorModel[].class ));
    }
}
