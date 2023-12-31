package br.inatel.labs.labjpa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
@Transactional
public class NotaCompraService {
	
	@PersistenceContext
	private EntityManager em;
	
	public NotaCompra salvar(NotaCompra nc) {
		return em.merge(nc);
	}
	
	public NotaCompra buscarNotaCompraPeloId(Long id) {
		return em.find(NotaCompra.class, id);
	}
	
	public NotaCompra buscarNotaCompraPeloIdComListaItem(Long id) {
		NotaCompra notaCompra = em.find(NotaCompra.class, id);
		notaCompra.getListaNotaCompraItem().size();
		return em.find(NotaCompra.class, id);
	}
	
	public List<NotaCompra> listaNotaCompra(){
		return em.createQuery("select nc from NotaCompra nc", NotaCompra.class).getResultList();
	}
	
	public NotaCompraItem salvar(NotaCompraItem item){
		return em.merge(item);
	}
	
	public NotaCompraItem buscarNotaCompraItemPeloId(Long id) {
		return em.find(NotaCompraItem.class, id);
	}
	
	public List<NotaCompraItem> listaNotaCompraItem(){
		return em.createQuery("select i from NotaCompraItem i", NotaCompraItem.class).getResultList();
	}
	
}
