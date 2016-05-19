package model.domain;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="TB_MOTO")
public class Moto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_MOTO")
	private Integer Codigo;
	
	@Column(name = "NM_MOTO")
	private String nome;
	
	@Column(name = "DT_ANO")
	private Integer ano;
	
	@Column(name = "PRECO")
	private BigDecimal preco;
	
	@ManyToOne
	@JoinColumn(name = "marca", referencedColumnName = "CD_MARCA")
	private Marca marca;
	
	@OneToMany(mappedBy="moto", fetch = FetchType.EAGER)
	private List<Acessorio> acessorios;
	
	public Moto(){
		
	}

	public Integer getCodigo() {
		return Codigo;
	}

	public void setCodigo(Integer codigo) {
		this.Codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@XmlTransient
	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Codigo == null) ? 0 : Codigo.hashCode());
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
		Moto other = (Moto) obj;
		if (Codigo == null) {
			if (other.Codigo != null)
				return false;
		} else if (!Codigo.equals(other.Codigo))
			return false;
		return true;
	}
	
	
	
	
}
