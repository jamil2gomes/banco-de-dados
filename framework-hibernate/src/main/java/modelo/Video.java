package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class Video {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tipo;
	private String status;
	private BigDecimal valorDiaria;
	
	public Video() {
		
	}
	
	public Video(String tipo, String status,  Filme filme) {
		
		this.tipo = tipo;
		this.status = status;
		this.filme = filme;
		
		if(filme.getCategoria() == CategoriaFilme.CATALOGO) {
			this.valorDiaria = new BigDecimal(2.50);
		}else if(filme.getCategoria() == CategoriaFilme.LANCAMENTO) {
			this.valorDiaria = new BigDecimal(3.50);
		}else {
			this.valorDiaria = new BigDecimal(1.0);
		}
	}
	
	@ManyToOne(optional = false, cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Filme filme;
	
	public Filme getFilme() {
		return filme;
	}
	
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getValorDiaria() {
		return valorDiaria;
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
		Video other = (Video) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
