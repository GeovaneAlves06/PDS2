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
	private Integer codMoto;
	
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

	public Integer getCodMoto() {
		return codMoto;
	}

	public void setCodMoto(Integer codMoto) {
		this.codMoto = codMoto;
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
		result = prime * result + ((codMoto == null) ? 0 : codMoto.hashCode());
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
		if (codMoto == null) {
			if (other.codMoto != null)
				return false;
		} else if (!codMoto.equals(other.codMoto))
			return false;
		return true;
	}
	
	
	
	
}
