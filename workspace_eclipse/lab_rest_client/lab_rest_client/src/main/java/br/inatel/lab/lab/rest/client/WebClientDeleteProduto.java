package br.inatel.lab.lab.rest.client;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class WebClientDeleteProduto {
	public static void main(String[] args) {
		try {
		ResponseEntity<Void> responseEntity = WebClient.create(Constantes.BASE_URL)
				.delete()
				.uri("/produto/3")
				.retrieve()
				.toBodilessEntity()
				.block();
	
		HttpStatusCode statusCode = responseEntity.getStatusCode();
		
		System.out.println("Produto removido");
		System.out.println("Status da resposta: " + statusCode);
		} catch(WebClientResponseException e) {
			System.out.println(e.getStatusCode());
		}
	}
}