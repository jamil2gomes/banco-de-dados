package repositorio;

import java.util.List;

import javax.persistence.EntityManager;


import modelo.Filme;

public class FilmeRepositorio {

	private final EntityManager manager;

	public FilmeRepositorio(EntityManager manager) {
		this.manager = manager;
	}

	public Filme salvar(Filme filme) {
		return manager.merge(filme);

	}

	public void remover(Filme filme) {
	      manager.remove(filme);
			
	}

	public Filme porId(Integer id) {
		return manager.find(Filme.class, id);
	}
	
	
	public Filme porNome(String titulo){
		 return this.manager.createQuery("from Filme " +
	                "where upper(titulo) like :titulo", Filme.class)
	                .setParameter("titulo", titulo.toUpperCase() + "%")
	                .getSingleResult();
	}
	
	public List<Filme>porGenero(String genero){
		 return this.manager.createQuery("from Filme " +
	                "where upper(genero) like :genero", Filme.class)
	                .setParameter("genero", genero.toUpperCase() + "%")
	                .getResultList();
	}

}
