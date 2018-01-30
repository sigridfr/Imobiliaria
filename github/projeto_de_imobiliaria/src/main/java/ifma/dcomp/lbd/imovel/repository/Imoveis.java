package ifma.dcomp.lbd.imovel.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import ifma.dcomp.lbd.imovel.model.Imovel;

public class Imoveis  {

	private EntityManager manager;
	
	public Imovel buscaPorId(Long id) {
		return this.manager.find(Imovel.class, id);
	}
	
	public Imovel salva(Imovel imovel) {
		return manager.merge(imovel);
	}
	
	@Transactional
	public void remove(Imovel imovel) {
		try {
			imovel = buscaPorId(imovel.getId());
			manager.remove(imovel);
			manager.flush();
		} catch (PersistenceException e) {
			throw new IllegalStateException("Imovel não pode ser excluído.");
		}
	}
	
	public void atualiza(Imovel imovel) {
		manager.find(Imovel.class, 1L);
		manager.createQuery("Atualização feita com Sucesso!").executeUpdate();
		manager.flush();
	}
	
	
	public List listaImoveis(Long id) {
		return ((Query) this.manager.find(Imovel.class, id))
				.getResultList();
	}
	 
}