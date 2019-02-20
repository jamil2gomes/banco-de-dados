package modelo;

public class Filme {

	private int id, anoLancamento, duracao;
	private String titulo,genero;
	
	
	public Filme() {}


	public Filme(int anoLancamento, int duracao, String titulo, String genero) {
		this.anoLancamento = anoLancamento;
		this.duracao = duracao;
		this.titulo = titulo;
		this.genero = genero;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getAnoLancamento() {
		return anoLancamento;
	}


	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}


	public int getDuracao() {
		return duracao;
	}


	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	@Override
	public String toString() {
		return "Filme [id=" + id + ", anoLancamento=" + anoLancamento + ", duracao=" + duracao + ", titulo=" + titulo
				+ "]";
	}
	
	
	
	
	
	
	
}
