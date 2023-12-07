package br.inatel.lab.lab.rest.client;

import java.util.ArrayList;

import java.util.List;

import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.lab.lab.rest.client.model.dto.ProdutoDto;
import reactor.core.publisher.Flux;

public class WebClientGetFluxProduto {	
	public static void main(String[] args) {
		List<ProdutoDto> listaProduto = new ArrayList<ProdutoDto>();
		
		Flux<ProdutoDto> fluxProduto = WebClient.create(Constantes.BASE_URL)
				.get()
				.uri("/produto")
				.retrieve()
				.bodyToFlux(ProdutoDto.class);
		
		fluxProduto.subscribe(p -> listaProduto.add(p));
		
		fluxProduto.blockLast();
		
		System.out.println("Lista de produtos");
		System.out.println(listaProduto);		
	}
}