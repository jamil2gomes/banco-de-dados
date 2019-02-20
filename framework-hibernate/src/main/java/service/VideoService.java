package service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import conexao.ConnectionFactory;
import modelo.Video;
import repositorio.VideoRepositorio;

public class VideoService {

	private final EntityManager manager;
	private final VideoRepositorio repositorio;
	
	public VideoService() {
		this.manager = new ConnectionFactory().getEntityManager();
		this.repositorio = new VideoRepositorio(manager);
	}
	
	
	public void salvar (Video video) {
		
		try {
			manager.getTransaction().begin();
			repositorio.salvar(video);
			manager.getTransaction().commit();
			System.out.println("Video salvo com sucesso");
			
		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
		}finally {
			manager.close();
		}
	}
	
	public Video buscar(int id) {
		return repositorio.porId(id);
	}
}
