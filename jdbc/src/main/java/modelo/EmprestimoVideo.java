package modelo;

public class EmprestimoVideo {

	private int id;
	private Emprestimo emprestimo;
	private Video video;
	
	
	public EmprestimoVideo() {}


	public EmprestimoVideo(Emprestimo emprestimo, Video video) {
		super();
		this.emprestimo = emprestimo;
		this.video = video;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Emprestimo getEmprestimo() {
		return emprestimo;
	}


	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}


	public Video getVideo() {
		return video;
	}


	public void setVideo(Video video) {
		this.video = video;
	}
	
	
}
