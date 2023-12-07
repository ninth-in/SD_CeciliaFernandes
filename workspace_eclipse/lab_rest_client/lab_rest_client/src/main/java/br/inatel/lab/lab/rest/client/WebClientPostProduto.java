package br.inatel.lab.lab.rest.client;

import java.math.BigDecimal;

import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.lab.lab.rest.client.model.dto.ProdutoDto;


public class WebClientPostProduto {
	public static void main(String[] args) {
		ProdutoDto novoProduto = new ProdutoDto();
		novoProduto.setDescricao("Martelo");
		novoProduto.setPreco(new BigDecimal(25.00));
		
		ProdutoDto produtoCriado = WebClient.create(Constantes.BASE_URL)
				.post()
				.uri("/produto")
				.bodyValue(novoProduto)
				.retrieve()
				.bodyToMono(ProdutoDto.class)
				.block();
		
		System.out.println("Produto criado"); 
		System.out.println(produtoCriado);
	}
}