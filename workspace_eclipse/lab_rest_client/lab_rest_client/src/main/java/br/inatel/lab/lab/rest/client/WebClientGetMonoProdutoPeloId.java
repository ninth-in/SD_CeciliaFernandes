package br.inatel.lab.lab.rest.client;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;


import br.inatel.lab.lab.rest.client.model.dto.ProdutoDto;
import reactor.core.publisher.Mono;

public class WebClientGetMonoProdutoPeloId {	
	public static void  main(String[] args) {
		try {
			
		
		Mono<ProdutoDto> monoProduto = WebClient.create(Constantes.BASE_URL)
				.get()
				.uri("/produto/4")
				.retrieve()
				.bodyToMono(ProdutoDto.class);
		
		monoProduto.subscribe();
		
		ProdutoDto produto = monoProduto.block();
		
		System.out.println("Produto encontrado");
		System.out.println(produto);
		}	catch(WebClientResponseException e) {
			System.out.println("Status code: " + e.getStatusCode());
			System.out.println("Mensagem: " + e.getMessage());
		}
	}
}