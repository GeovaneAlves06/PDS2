package model.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TB_ACESSORIO")
public class Acessorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_ACESSORIO")
	private Integer codAcessorio;
	
	@Column(name = "TP_TIPO")
	private String tipo;
	
	@Column(name = "PC_PRECO")
	private BigDecimal preco;
	
	
	@ManyToOne
	@JoinColumn(name = "moto", referencedColumnName = "CD_MOTO")
	private Moto moto;
	
	public Acessorio() {
	}
		
	public Integer getCodAcessorio() {
		return codAcessorio;
	}

	public void setCodAcessorio(Integer codAcessorio) {
		this.codAcessorio = codAcessorio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public Moto getMoto() {
		return moto;
	}

	public void setMoto(Moto moto) {
		this.moto = moto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAcessorio == null) ? 0 : codAcessorio.hashCode());
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
		Acessorio other = (Acessorio) obj;
		if (codAcessorio == null) {
			if (other.codAcessorio != null)
				return false;
		} else if (!codAcessorio.equals(other.codAcessorio))
			return false;
		return true;
	}

	

}
