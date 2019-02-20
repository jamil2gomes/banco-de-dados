package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Emprestimo {
	
	

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="data_locacao")
	private LocalDate dataLocacao;
	
	@Column(name="data_devolucao")
	private LocalDate dataDevolucao;
	
	private BigDecimal valorAluguel;
	private Boolean status;

	@ManyToMany
	@JoinTable(name = "emprestimo_video",
	joinColumns = @JoinColumn(name = "id_emprestimo"),
	inverseJoinColumns = @JoinColumn(name = "id_video"))
	private List <Video> video;
	
	@ManyToOne
	private Cliente cliente;
	
	public Emprestimo() {
		
	}
	
	
	public Emprestimo( LocalDate dataLocacao, List<Video> video, Cliente cliente) {

		this.dataLocacao = dataLocacao;
		this.dataDevolucao = dataLocacao.plusDays(3);
		this.status = true;
		this.video = video;
		this.cliente = cliente;
		
		
		BigDecimal valorParcial = new BigDecimal(0);
		
		for (Video video2 : video) {
			valorParcial = valorParcial.add(video2.getValorDiaria());
		}
		
		long qtdDias = ChronoUnit.DAYS.between(dataLocacao, dataDevolucao);
		BigDecimal quantidade = new BigDecimal(qtdDias);
		
		this.valorAluguel = valorParcial.multiply(quantidade);
	}



	public Integer getId() {
		return id;
	}


	public BigDecimal getValorAluguel() {
		return valorAluguel;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(LocalDate dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public List<Video> getVideo() {
		return video;
	}

	public void adicionaVideo(Video video) {
		this.video.add(video);
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
		Emprestimo other = (Emprestimo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emprestimo [id=" + id + ", dataLocacao=" + dataLocacao + ", dataDevolucao=" + dataDevolucao
				+ ", valorAluguel=" + valorAluguel + ", status=" + status + ", video=" + video + ", cliente=" + cliente.getNome()
				+ "]";
	}

}
