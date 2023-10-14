package br.inatel.labs.labjpa;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import br.inatel.labs.labjpa.service.NotaCompraService;

@SpringBootTest
public class LoadingDemo {
	
	@Autowired
	private NotaCompraService service;
	
	public void demoPlanejandoConsulta() {
		try {
			NotaCompra nota = service.buscarNotaCompraPeloIdComListaItem(1L);
			List<NotaCompraItem> listaNotaCompraItem = nota.getListaNotaCompraItem();
			
			for(NotaCompraItem item : listaNotaCompraItem) {
				System.out.println(item);
			}
			System.out.println("O planejamento da consulta funcionou");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void demoLazyLoading() {
		try {
			NotaCompra nota = service.buscarNotaCompraPeloId(1L);
			int numDeItens = nota.getListaNotaCompraItem().size();
			
			System.out.println(numDeItens);
			System.out.println("O carregamento foi laze e por isso lançou a exception");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void demoEagerLoading() {
		try {
			NotaCompraItem item = service.buscarNotaCompraItemPeloId(1L);
			
			LocalDate dataEmissao = item.getNotaCompra().getDataEmissao();
			
			System.out.println(dataEmissao);
			System.out.println("Aconteceu o carregamento EAGER");
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
}
