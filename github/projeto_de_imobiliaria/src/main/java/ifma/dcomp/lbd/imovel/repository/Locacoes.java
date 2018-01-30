package ifma.dcomp.lbd.imovel.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import ifma.dcomp.lbd.imovel.model.Locacao;

public class Locacoes  {

	
	private EntityManager manager;
	
	public Locacao buscaPorId(Long id) {
		return this.manager.find(Locacao.class, id);
	}
	
	public List listaLocacoes(Long id) {
		return ((Query) this.manager.find(Locacao.class, id))
				.getResultList();
	}
	
	public Locacao salva(Locacao locacao) {
		return manager.merge(locacao);
	}
	
	@Transactional
	public void remove(Locacao locacao) {
		try {
			locacao = buscaPorId(locacao.getId());
			manager.remove(locacao);
			manager.flush();
		} catch (PersistenceException e) {
			throw new IllegalStateException("O contrato não pode ser excluído.");
		}
	}
	
	public void atualiza(Locacao locacao) {
		manager.find(Locacao.class, 1L);
		manager.createQuery("Atualização feita com Sucesso!").executeUpdate();
		manager.flush();
	}
	
}