package repositorio;

import javax.persistence.EntityManager;

import modelo.Cliente;

public class ClienteRepositorio {

	private final EntityManager manager;

	public ClienteRepositorio(EntityManager manager) {
		this.manager = manager;
	}

	public Cliente salvar(Cliente cliente) {
		return manager.merge(cliente);

	}

	public void remover(Cliente cliente) {

		manager.remove(cliente);

	}

	public Cliente buscaPorId(int id) {
		return manager.find(Cliente.class, id);
	}

}
