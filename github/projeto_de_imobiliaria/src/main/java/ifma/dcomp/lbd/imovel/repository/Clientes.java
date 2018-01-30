package ifma.dcomp.lbd.imovel.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import ifma.dcomp.lbd.imovel.model.Cliente;
import ifma.dcomp.lbd.imovel.model.Imovel;

public class Clientes  {

	
	private EntityManager manager;
	
	public Cliente buscaPorId(Long id) {
		return this.manager.find(Cliente.class, id);
	}
	
	public List<Cliente> listaClientes(String nome) {
		return this.manager.createQuery("from Cliente " +
				"where upper(nome) like :nome", Cliente.class)
				.setParameter("nome", nome.toUpperCase() + "%")
				.getResultList();
	}
	
	/*public Cliente salva(Cliente cliente) {
		return manager.merge(cliente);
	}*/
	
	
	/* public void adiciona(Cliente cliente) {
	        manager.persist(cliente);
	    }*/
	
	 /*public void altera(Cliente cliente) {
	        System.out.println("CÃ³digo do Cliente: "+ cliente.getId());
	        manager.merge(cliente);
	    }*/
	
	@Transactional
	public void remove(Cliente cliente) {
		try {
			cliente = buscaPorId(cliente.getId());
			manager.remove(cliente);
			manager.flush();
		} catch (PersistenceException e) {
			throw new IllegalStateException("Cliente não pode ser excluído.");
		}
	}
	
	public void atualiza(Cliente cliente) {
		manager.find(Cliente.class, 1L);
		manager.createQuery("Atualização feita com Sucesso!").executeUpdate();
		manager.flush();
	}
	
	/*public void atualiza(Cliente cliente, int linha) {
		if (cliente.getId() < 1) {
			if (linha == 0) {
				cliente.setId((long) 1);
			} else {
				this.manager.remove(cliente);
			}
		}
	
     }*/

	
}