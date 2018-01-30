package ifma.dcomp.lbd.imovel.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "locacoes")
public class Locacao {

	public Locacao() {  }
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "idImovel", nullable = false)
	private Imovel imovel;
	
	@ManyToOne
	@JoinColumn(name = "idInquilino", nullable = false)
	private Cliente inquilino;
	
	
	@Column(name="data_inicio")
	private LocalDateTime dataInicio;

	@Column(name="data_fim")
	private LocalDate dataFim;
	
	@Column(name="dia_vencimento")
	private int diaVencimento;
	
	@Column(name = "valor_aluguel", nullable = false, precision = 10, scale = 2)
	private BigDecimal valorAluguel;
	
	@Column(name = "percentual_multa", nullable = false, precision = 5, scale = 2)
	private BigDecimal percentualMulta;
	
	@Column(columnDefinition = "text")
	private String Observacao;
	
	private boolean ativo=true;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getObservacao() {
		return Observacao;
	}

	public void setObservacao(String observacao) {
		this.Observacao = observacao;
	}
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime localDateTime) {
		this.dataInicio = localDateTime;
	}

	public LocalDate getDataFim(LocalDateTime localDateTime){
		return dataFim;
	}

	public void setDataFim (LocalDate localDate) {
		this.dataFim = localDate;
	}

	public int getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(int diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public BigDecimal getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(BigDecimal valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	
	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Cliente getInquilino() {
		return inquilino;
	}

	public void setInquilino(Cliente inquilino) {
		this.inquilino = inquilino;
	}
	
	public BigDecimal getPercentualMulta() {
		return percentualMulta;
	}

	public void setPercentualMulta(BigDecimal percentualMulta) {
		this.percentualMulta = percentualMulta;
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
		Locacao other = (Locacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
