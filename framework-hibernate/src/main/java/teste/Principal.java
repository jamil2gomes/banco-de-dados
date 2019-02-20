package teste;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaFilme;
import modelo.Cliente;
import modelo.Emprestimo;
import modelo.Filme;
import modelo.Video;
import service.ClienteService;
import service.EmprestimoService;
import service.FilmeService;
import service.VideoService;

public class Principal {

	public static void main(String[] args) {
		
		//fazerLocacao();
		
		//salvarCliente();
		
		//salvarFilme();
		
		//salvarVideo();
		
		
		

		
		
	}
	
	
	
	public static void fazerDevolucao() {
		
	}
	
	
	public static void fazerLocacao() {
		ClienteService cs = new ClienteService();
		Cliente clienteEncontrado = cs.buscar(1);
		
		VideoService vs = new VideoService();
		Video videoEncontrado = vs.buscar(1);
		
		
		List<Video> videos = new ArrayList<>();
		videos.add(videoEncontrado);
		
		
		Emprestimo emprestimo = new Emprestimo(LocalDate.now(), videos, clienteEncontrado);
		
		EmprestimoService es = new EmprestimoService();
		es.locar(emprestimo);
		
	
	}
	
	
	public static void salvarVideo(){
		FilmeService fs = new FilmeService();
		Filme filmeBuscado = fs.buscar(1);
		Video video = new Video("dvd","disponivel",filmeBuscado);
		
		VideoService vs = new VideoService();
		vs.salvar(video);
		
	}
	
	public static void salvarFilme() {
		Filme filme = new Filme();
		filme.setTitulo("filme 3");
		filme.setCategoria(CategoriaFilme.LANCAMENTO);
		
		
		
		FilmeService fs = new FilmeService();
		fs.salvar(filme);
	}
	
	public static void salvarCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome("jamil");
		
		ClienteService cs = new ClienteService();
		cs.salvar(cliente);
	}
}
