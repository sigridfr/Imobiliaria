package ifma.dcomp.lbd.imovel.teste;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import ifma.dcomp.lbd.imovel.model.Cliente;
import ifma.dcomp.lbd.imovel.model.Imovel;
import ifma.dcomp.lbd.imovel.model.Locacao;
import ifma.dcomp.lbd.imovel.model.TipoImovel;


public class TesteLocacao {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetoImobiliaria");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transacao = manager.getTransaction();
		
		transacao.begin();
		
		//Questão 1.Inserindo Dados
		
		//Inserindo Dados locacao 1
		Locacao locacao = new Locacao();
		locacao.setDataInicio(LocalDateTime.now());
		locacao.setDataFim(LocalDate.now().plusDays(30));
		locacao.setDiaVencimento(30);
		locacao.setValorAluguel(new BigDecimal(800));
		locacao.setPercentualMulta(new BigDecimal(0.36));
		locacao.setObservacao("Para pagamentos atrasados havera multa de 0.29% por dia/atraso");
		locacao.setAtivo(false);
		
		//Inserindo Dados locacao 2
		Locacao l2 = new Locacao();
		l2.setDataInicio(LocalDateTime.now());
		l2.setDataFim(LocalDate.now().plusDays(30));
		l2.setDiaVencimento(30);
		l2.setValorAluguel(new BigDecimal(1200));
		l2.setPercentualMulta(new BigDecimal(0.19));
		l2.setObservacao("Para pagamentos atrasados havera multa de 0.45% por dia/atraso");
		l2.setAtivo(true);		

		//Inserindo dados Imovel 1
		Imovel im1 = new Imovel();
		im1.setBairro("Rua das Flores");
		im1.setCep("65045-000");
		im1.setEndereco("Condominio Malia NÂº323, Bl 03, Ap 06");
		im1.setValorAluguelSugerido(new BigDecimal(960) );
		im1.setQtdeBanheiros(2);
		im1.setQtdeQuartos(4);
		im1.setMetragem(1900);
		im1.setSuites(1);
		im1.setVagasGaragem(2);
		im1.setObservacao("Imovel disponivel para alugar a partir de Janeiro de 2018");
		im1.setTipo(TipoImovel.APARTAMENTO);
		locacao.setImovel(im1);
		
		//Inserindo dados Imovel 2
		Imovel im2 = new Imovel();
		im2.setBairro("Rua do Sol");
		im2.setCep("65000-000");
		im2.setEndereco("Condominio Sol do Oriente Nº323, Bl 03, Ap 06");
		im2.setValorAluguelSugerido(new BigDecimal(1850) );
		im2.setQtdeBanheiros(2);
		im2.setQtdeQuartos(4);
		im2.setMetragem(1900);
		im2.setSuites(1);
		im2.setVagasGaragem(2);
		im2.setObservacao("Imovel disponível para alugar a partir de Janeiro de 2018");
		im2.setTipo(TipoImovel.TERRENO);
		l2.setImovel(im2);
		
		//Inserindo Dados do Inquilino 1
		Cliente c1 = new Cliente();
		c1.setNome("Joao da Silva");
		c1.setEmail("joao@silva.com");
		c1.setCelular("(98)987654321");
		c1.setTelefone("(98)32678909");
		c1.setCpf("765.897.098-99");
		LocalDate dn = LocalDate.of(1989,Month.NOVEMBER,15);
		c1.setDataNascimento(dn);
		locacao.setInquilino(c1);
		
		//Inserindo Dados do Inquilino 2
		Cliente c2 = new Cliente();
		c2.setNome("Maria Das Dores");
		c2.setEmail("maria@dores.com");
		c2.setCelular("(98)987652345");
		c2.setTelefone("(98)32671123");
		c2.setCpf("865.597.028-11");
		LocalDate dn2 = LocalDate.of(1993,Month.JULY,30);
		c2.setDataNascimento(dn2);
		l2.setInquilino(c2);
	
		
		//Questão 2. Atualizando Dados
		//manager.find(Locacao.class, 1L);
		locacao.setObservacao("Para pagamentos atrasados havera multa de 1.25% por dia/atraso");
		locacao.setDiaVencimento(29);

		// Ação
		manager.persist(c1);
		manager.persist(c2);
		manager.persist(im1);
		manager.persist(im2);
		manager.persist(locacao);
		manager.persist(l2);
		manager.flush();
		manager.clear();
		
		
		//Questão 3. Removendo Dados
		manager.remove(manager.merge(locacao));
		
		
		//Questão 4. Listando Dados Cadastrados Associando um imovel a um inquilino
		Query q = manager.createQuery("SELECT l FROM Locacao l");
				List<Locacao> locacoes = q.getResultList();		
					for (Locacao l: locacoes) {
						System.out.println("Id Cliente:" +l.getInquilino().getId());
						System.out.println("Cliente:" +l.getInquilino().getNome());
						System.out.println("Id Locacao:" +l.getId());
						System.out.println("Id Imovel:" +l.getImovel().getId());
						System.out.println("Data Inicio:" +l.getDataInicio());
						System.out.println("Data Vencimento:" +l.getDiaVencimento());
						System.out.println("Valor Pago:" +l.getValorAluguel());
						System.out.println("Percentual Multa:" +l.getPercentualMulta());
						System.out.println("Observacao:" +l.getObservacao()+"\n");
			}
					
					
		transacao.commit();
		manager.close();
		factory.close();
	}
}
