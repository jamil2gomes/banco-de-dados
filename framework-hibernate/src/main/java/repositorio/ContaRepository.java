package repositorio;

import javax.persistence.EntityManager;

import modelo.Conta;

public class ContaRepository {

	private EntityManager manager;

	public ContaRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Conta salvar(Conta conta) {
		Conta contaSalva = manager.merge(conta);
		return contaSalva;
	}

	public void remover(Conta conta) {
		manager.remove(conta);
	}

	public Conta buscaPor(int id) {
		return manager.find(Conta.class, id);
	}
}
