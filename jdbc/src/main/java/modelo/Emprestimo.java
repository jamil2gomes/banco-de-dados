package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Emprestimo {

	private int id;
	private LocalDate dataLocacao, dataDevolucao;
	private Boolean statusEmprestimo;
	private BigDecimal valorAluguel;
	private Cliente cliente;
	
	
	
	public Emprestimo() {}


	public Emprestimo(LocalDate dataLocacao, LocalDate dataDevolucao, Boolean statusEmprestimo, BigDecimal valorAluguel ,Cliente cliente) {
		super();
		this.dataLocacao = dataLocacao;
		this.dataDevolucao = dataDevolucao;
		this.statusEmprestimo = statusEmprestimo;
		this.valorAluguel = valorAluguel;
		this.cliente = cliente;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public Boolean getStatusEmprestimo() {
		return statusEmprestimo;
	}


	public void setStatusEmprestimo(Boolean statusEmprestimo) {
		this.statusEmprestimo = statusEmprestimo;
	}

	

	public BigDecimal getValorAluguel() {
		return valorAluguel;
	}


	public void setValorAluguel(BigDecimal valorAluguel) {
		this.valorAluguel = valorAluguel;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	@Override
	public String toString() {
		return "Emprestimo [id=" + id + ", dataLocacao=" + dataLocacao + ", dataDevolucao=" + dataDevolucao
				+ ", statusEmprestimo=" + statusEmprestimo + ", cliente=" + cliente + "]";
	}
	
	
	
}
