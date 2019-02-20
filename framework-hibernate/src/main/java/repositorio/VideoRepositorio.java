package repositorio;

import javax.persistence.EntityManager;

import modelo.Video;

public class VideoRepositorio {

	private final EntityManager manager;

	public VideoRepositorio(EntityManager manager) {
		this.manager = manager;
	}

	public Video salvar(Video video) {
		 return manager.merge(video);
	
	}

	public void remover(Video video) {
		
			manager.remove(video);
		
	}

	public Video porId(Integer id) {
		return manager.find(Video.class, id);
	}

}
