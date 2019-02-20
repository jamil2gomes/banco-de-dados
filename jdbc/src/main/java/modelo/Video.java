package modelo;

import java.math.BigDecimal;

public class Video {
	
	private int id;
	private String tipo;
	private BigDecimal valorDiaria;
	private Filme filme;
	
	
	public Video() {}


	public Video(String tipo, BigDecimal valorDiaria, Filme filme) {
		super();
		this.tipo = tipo;
		this.valorDiaria = valorDiaria;
		this.filme = filme;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}


	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}


	public Filme getFilme() {
		return filme;
	}


	public void setFilme(Filme filme) {
		this.filme = filme;
	}


	@Override
	public String toString() {
		return "Video [id=" + id + ", tipo=" + tipo + ", valorDiaria=" + valorDiaria + ", filme=" + filme + "]";
	}
	
	
	

}
