package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import conexao.ConnectionFactory;
import modelo.Filme;
import repositorio.FilmeRepositorio;

public class FilmeService {

	private final EntityManager manager;
	private final FilmeRepositorio repositorio;

	public FilmeService() {
		this.manager = new ConnectionFactory().getEntityManager();
		this.repositorio = new FilmeRepositorio(manager);
	}

	public void salvar(Filme filme) {

		try {
			manager.getTransaction().begin();
			repositorio.salvar(filme);
			manager.getTransaction().commit();

			System.out.println("Filme adicionado com sucesso!");
		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
		} finally {
			manager.close();
		}
	}

	public Filme buscar(int id) {
		return repositorio.porId(id);
	}

	public Filme buscarPorTitulo(String titulo) {
		return repositorio.porNome(titulo);
	}

	public List<Filme> buscarPorGenero(String genero) {
		return repositorio.porGenero(genero);
	}

	public void remover(Filme filme) {

		try {

			manager.getTransaction().begin();
			repositorio.remover(filme);
			manager.getTransaction().commit();

		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
		} finally {
			manager.close();
		}
	}

}
