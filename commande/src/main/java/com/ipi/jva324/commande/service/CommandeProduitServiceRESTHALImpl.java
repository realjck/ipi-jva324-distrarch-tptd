package com.ipi.jva324.commande.service;

import com.ipi.jva324.stock.model.ProduitEnStock;
import com.ipi.jva324.stock.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CommandeProduitServiceRESTHALImpl implements CommandeProduitService {

    @Autowired
    private ProduitService produitService;

    @Autowired @Qualifier("springDataRestTemplate")
    private RestTemplate restTemplate;

    /** URL serveur : (configurée dans application.properties, sinon valeur par défaut) */
    @Value("${apiserver.url:http://localhost:8080/api/data-rest/}")
    private String url;

    @Override
    public ProduitEnStock getProduit(Long id) {
        return restTemplate.getForObject (
                url + "produitEnStocks/" + id,
                ProduitEnStock.class);
    }
}
