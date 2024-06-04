package com.ipi.jva324.stock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipi.jva324.commande.model.Commande;
import com.ipi.jva324.stock.model.ProduitEnStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class Jva324Application {

	public static void main(String[] args) {
		SpringApplication.run(Jva324Application.class, args);
	}

	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {
		return RepositoryRestConfigurer.withConfig(config -> {
			config.exposeIdsFor(Commande.class, ProduitEnStock.class);
		});
	}

	@Bean
	public RestTemplate springDataRestTemplate(@Autowired ObjectMapper objectMapper) {
		// converter qui sait convertir le format HAL et le dit :
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(List.of(MediaTypes.HAL_JSON));
		converter.setObjectMapper(objectMapper);
		return new RestTemplate(Collections.singletonList(converter));
	}

	/**
	 * else can't resolve HTML views because no defaultViewResolver
	 * because no WebMvcAutoConfiguration even with @EnableWebMvc
	 */
	///@Configuration
	public class TriggeringWebMvcAutoConfiguration extends WebMvcAutoConfiguration {

		public TriggeringWebMvcAutoConfiguration() {

		}

	}

}
