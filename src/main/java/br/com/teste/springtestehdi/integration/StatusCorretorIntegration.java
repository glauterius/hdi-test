package br.com.teste.springtestehdi.integration;

import br.com.teste.springtestehdi.model.CorretorModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class StatusCorretorIntegration {

    @Value( "${config.url.brokerData}" )
    private String url;

    public List<CorretorModel> getStatus(String code){
        RestTemplate restTemplate = new RestTemplate();
        return Arrays.asList(restTemplate.getForObject(  url + "?code=" + code, CorretorModel[].class ));
    }
}
