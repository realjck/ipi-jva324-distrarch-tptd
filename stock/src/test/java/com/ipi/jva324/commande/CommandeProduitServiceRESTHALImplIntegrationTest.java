package com.ipi.jva324.commande;

import com.ipi.jva324.Jva324Application;
import com.ipi.jva324.commande.service.CommandeProduitServiceRESTHALImpl;
import com.ipi.jva324.stock.model.ProduitEnStock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) // Junit 4 : @RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(Jva324Application.class)
class CommandeProduitServiceRESTHALImplIntegrationTest {

    @Autowired
    private CommandeProduitServiceRESTHALImpl commandeProduitService;

    @Test
    void testGetProduit() {
        ProduitEnStock produitEnStock = commandeProduitService.getProduit(0L);
        Assertions.assertEquals(0, produitEnStock.getId());
    }

}
