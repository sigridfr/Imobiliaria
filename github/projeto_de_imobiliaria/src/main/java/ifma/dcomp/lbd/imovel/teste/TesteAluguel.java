package ifma.dcomp.lbd.imovel.teste;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ifma.dcomp.lbd.imovel.model.Aluguel;


public class TesteAluguel {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetoImobiliaria");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transacao = manager.getTransaction();
		
		transacao.begin();
		
		//Questão 1.Inserindo Dados
		
		//Inserir dados Aluguel 1
		Aluguel aluguel = new Aluguel();
		aluguel.setDataPagamento(LocalDateTime.now());
		aluguel.setDataVencimento(LocalDate.now().plusDays(30));
		aluguel.setValorPago(new BigDecimal(900));
		aluguel.setObservacao("Para pagamentos atrasados haverá multa de 0.29% por dia/atraso");
		
		//Inserir dados Aluguel 2
		Aluguel al2 = new Aluguel();
		al2.setDataPagamento(LocalDateTime.now());
		al2.setDataVencimento(LocalDate.now().plusDays(30));
		al2.setValorPago(new BigDecimal(2900));
		al2.setObservacao("Para pagamentos atrasados haverá multa de 0.53% por dia/atraso");
		
		
		//Questão 2. Atualizando Dados
		al2.setValorPago(new BigDecimal(3900));
		
		
		//Ação
		manager.persist(aluguel);
		manager.persist(al2);
		manager.flush();
		manager.clear();
		
			
		//Questão 3. Removendo Dados
		manager.remove(manager.merge(aluguel));
		
		
		//Questão 4. Listando Dados Cadastrados
		Query q = manager.createQuery("SELECT a FROM Aluguel a");
		List<Aluguel> alugueis = q.getResultList();		
			for (Aluguel a: alugueis) {
				System.out.println("ID:" +a.getId());
				System.out.println("Data Pagamento:" +a.getDataPagamento());
				System.out.println("Data Vencimento:" +a.getDataVencimento());
				System.out.println("Valor Pago:" +a.getValorPago());
				System.out.println("Observacao:" +a.getObservacao()+"\n");
		}
		
		
		transacao.commit();
		manager.close();
		factory.close();
	}
	
}
