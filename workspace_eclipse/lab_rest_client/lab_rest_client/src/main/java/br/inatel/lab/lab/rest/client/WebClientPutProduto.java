package br.inatel.lab.lab.rest.client;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.lab.lab.rest.client.model.dto.ProdutoDto;

public class WebClientPutProduto {
	public static void main(String[] args) {
		ProdutoDto produtoExistente = new ProdutoDto();
		produtoExistente.setId(1L);
		produtoExistente.setDescricao("Furadeira a bateria");
		
		ResponseEntity<Void> responseEntity = WebClient.create(Constantes.BASE_URL)
				.put()
				.uri("/produto")
				.bodyValue(produtoExistente)
				.retrieve()
				.toBodilessEntity()	
				.block();
		
		HttpStatusCode statusCode = responseEntity.getStatusCode();
		
		System.out.println("Produto atualizado: ");
		System.out.println("Status da resposta: " + statusCode);
	}
}