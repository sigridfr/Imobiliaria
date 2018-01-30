package ifma.dcomp.lbd.imovel.teste;


import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import ifma.dcomp.lbd.imovel.model.Imovel;
import ifma.dcomp.lbd.imovel.model.TipoImovel;


public class TesteImovel {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetoImobiliaria");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transacao = manager.getTransaction();
		
		transacao.begin();
		
		//Questão 1.Inserindo Dados
		
		// Inserindo dados Imovel 1
		Imovel imovel = new Imovel();
		imovel.setBairro("Rua das Flores");
		imovel.setCep("65045-000");
		imovel.setEndereco("Condominio Malia Nº323, Bl 03, Ap 06");
		imovel.setValorAluguelSugerido(new BigDecimal(960) );
		imovel.setQtdeBanheiros(2);
		imovel.setQtdeQuartos(4);
		imovel.setMetragem(1900);
		imovel.setSuites(1);
		imovel.setVagasGaragem(2);
		imovel.setObservacao("Imovel disponível para alugar a partir de Janeiro de 2018");
		imovel.setTipo(TipoImovel.APARTAMENTO);
		
		// Inserindo dados Imovel 2
		Imovel imovel2 = new Imovel();
		imovel2.setBairro("Rua do Sol");
		imovel2.setCep("65000-000");
		imovel2.setEndereco("Condominio Sol do Oriente Nº323, Bl 03, Ap 06");
		imovel2.setValorAluguelSugerido(new BigDecimal(1850) );
		imovel2.setQtdeBanheiros(2);
		imovel2.setQtdeQuartos(4);
		imovel2.setMetragem(1900);
		imovel2.setSuites(1);
		imovel2.setVagasGaragem(2);
		imovel2.setObservacao("Imovel disponível para alugar a partir de Janeiro de 2018");
		imovel2.setTipo(TipoImovel.TERRENO);
		
		
		//Questão 2. Atualizando Dados
		manager.find(Imovel.class, 2L);
		imovel2.setEndereco("Condominio Flores do Campo, Avenida Sao Luis Rei de Franca, Nº800, Bl 06, Ap 204");

		
		//Acao
		manager.persist(imovel);
		manager.persist(imovel2);
		manager.flush();
		manager.clear();
		
		
		//Questão 3. Removendo Dados
		manager.remove(manager.merge(imovel));
				
		
		//Questão 4. Listando Dados Cadastrados
		Query q = manager.createQuery("SELECT m FROM Imovel m");
		List<Imovel> imoveis = q.getResultList();
			for (Imovel m: imoveis) {
				System.out.println("ID:" +m.getId());
				System.out.println("Endereco:" +m.getEndereco());
				System.out.println("Bairro:" +m.getBairro());
				System.out.println("Quartos:" +m.getQtdeQuartos());
				System.out.println("Banheiros:" +m.getQtdeBanheiros());
				System.out.println("Suites:" +m.getSuites());
				System.out.println("Área Total:" +m.getMetragem());
				System.out.println("Vagas Garagem:" +m.getVagasGaragem());
				System.out.println("Observacao:" +m.getObservacao());
				System.out.println("Tipo:" +m.getTipo());
				System.out.println("Valor Aluguel:" +m.getValorAluguelSugerido()+"\n");
   }
		
		
		transacao.commit();
		manager.close();
		factory.close();
	}
	
}
