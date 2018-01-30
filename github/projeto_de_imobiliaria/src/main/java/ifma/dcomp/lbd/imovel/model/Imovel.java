package ifma.dcomp.lbd.imovel.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="imoveis")
public class Imovel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private TipoImovel tipo;
	
	@Column(name = "valoraluguelsugerido", nullable = false, precision = 10, scale = 2)
	private BigDecimal valorAluguelSugerido;
	
	@Column(columnDefinition = "text")
	private String Endereco;
	
	@Column(name = "metragem", nullable = false, precision = 10, scale = 2)
	private double Metragem;
	
	@Column(name = "banheiros")
	private int qtdeBanheiros;
	
	@Column(name = "quartos")
	private int qtdeQuartos;

	@Column(nullable = false, length = 9)
	private String cep;
	
	@Column(nullable = false, length = 45)
	private String bairro;
	
	@Column(name = "vagasgaragem")
	private int vagasGaragem;
	
	@Column(columnDefinition = "text")
	private String Observacao;

	@Column(name = "suites")
	private int Suites;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public double getMetragem() {
		return Metragem;
	}

	public void setMetragem(double Metragem) {
		this.Metragem = Metragem;
	}

	public int getQtdeQuartos() {
		return qtdeQuartos;
	}

	public void setQtdeQuartos(int qtdeQuartos) {
		this.qtdeQuartos = qtdeQuartos;
	}

	
	public TipoImovel getTipo() {
		return tipo;
	}

	public void setTipo(TipoImovel tipo) {
		this.tipo = tipo;
	}
	
	
	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public BigDecimal getValorAluguelSugerido() {
		return valorAluguelSugerido;
	}

	public void setValorAluguelSugerido(BigDecimal valorAluguelSugerido) {
		this.valorAluguelSugerido = valorAluguelSugerido;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public int getVagasGaragem() {
		return vagasGaragem;
	}

	public void setVagasGaragem(int vagasGaragem) {
		this.vagasGaragem = vagasGaragem;
	}

	public int getSuites() {
		return Suites;
	}

	public void setSuites(int suites) {
		this.Suites = suites;
	}
	
	public String getObservacao() {
		return Observacao;
	}

	public void setObservacao(String observacao) {
		Observacao = observacao;
	}
	

	public int getQtdeBanheiros() {
		return qtdeBanheiros;
	}

	public void setQtdeBanheiros(int qtdeBanheiros) {
		this.qtdeBanheiros = qtdeBanheiros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imovel other = (Imovel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public boolean ehNovo() {
		return ( this.id == null );
	}
	

	
}
