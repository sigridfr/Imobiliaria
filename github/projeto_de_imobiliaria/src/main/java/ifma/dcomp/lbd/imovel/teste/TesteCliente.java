package ifma.dcomp.lbd.imovel.teste;



import java.time.Month;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ifma.dcomp.lbd.imovel.model.Cliente;


public class TesteCliente {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetoImobiliaria");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transacao = manager.getTransaction();
		
		transacao.begin();
		
		//Questão 1.Inserindo Dados

		// Inserindo dados Cliente 1
		Cliente cliente = new Cliente();
		cliente.setNome("Marcos Santos");
		cliente.setEmail("marcos@santos.com");
		cliente.setCelular("(98)987324321");
		cliente.setTelefone("(98)32070909");
		cliente.setCpf("165.597.098-29");
		LocalDate dn = LocalDate.of(1989,Month.NOVEMBER,15);
		cliente.setDataNascimento(dn);
	
		// Inserindo dados Cliente 2
		Cliente cliente2 = new Cliente();
		cliente2.setNome("João da Silva");
		cliente2.setEmail("joao@silva.com");
		cliente2.setCelular("(98)987654321");
		cliente2.setTelefone("(98)32678909");
		cliente2.setCpf("765.897.098-99");
		LocalDate dn2 = LocalDate.of(1994,Month.APRIL,3);
		cliente2.setDataNascimento(dn2);
		
		
		//Questão 2. Atualizando Dados
		cliente2.setNome("Maria Silva");
		cliente2.setEmail("maria@gmail.com");
		
		
		//Ação
		manager.persist(cliente);
		manager.persist(cliente2);
		manager.flush();
		manager.clear();
		
		
		// verificação
		/*Cliente clienteDoBanco = manager.createQuery("from Cliente where email= :email", Cliente.class)
			.setParameter("email", "marcos@santos.com")
			.getSingleResult();
				
		System.out.println("################ " + clienteDoBanco.getNome() );		
		System.out.println("################ " + clienteDoBanco.getNome().equals("Marcos Santos") );*/
		
		
		
		//Questão 3. Removendo Dados
		manager.remove(manager.merge(cliente));
				
			
		
		//Questão 4. Listando Dados Cadastrados
		Query q = manager.createQuery("SELECT c FROM Cliente c");
		List<Cliente> clientes = q.getResultList();
		for (Cliente c: clientes) {
			System.out.println("ID:" +c.getId());
			System.out.println("Nome:" +c.getNome());
			System.out.println("CPF:" +c.getCpf());
			System.out.println("Data de Nascimento:" +c.getDataNascimento());
			System.out.println("Email:" +c.getEmail());
			System.out.println("Telefone:" +c.getTelefone());
			System.out.println("Celular:" +c.getCelular()+"\n");
		}
		
				
		
		transacao.commit();
		manager.close();
		factory.close();
	}
	
}
