package ifma.dcomp.lbd.imovel.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import ifma.dcomp.lbd.imovel.model.Aluguel;
import ifma.dcomp.lbd.imovel.model.Locacao;

public class Alugueis  {

	
	private EntityManager manager;
	
	public Aluguel buscaPorId(Long id) {
		return this.manager.find(Aluguel.class, id);
	}
	
	public List listaAlugueis(Locacao id) {
		return ((Query) this.manager.find(Aluguel.class, id))
				.getResultList();
	}
	
	public Aluguel salva(Aluguel aluguel) {
		return manager.merge(aluguel);
	}
	
	@Transactional
	public void remove(Aluguel aluguel) {
		try {
			aluguel = buscaPorId(aluguel.getId());
			manager.remove(aluguel);
			manager.flush();
		} catch (PersistenceException e) {
			throw new IllegalStateException("Aluguel não pode ser excluído.");
		}
	}
	
	
}