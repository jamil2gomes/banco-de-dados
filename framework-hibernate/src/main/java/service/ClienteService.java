package service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import conexao.ConnectionFactory;
import modelo.Cliente;
import modelo.Emprestimo;
import repositorio.ClienteRepositorio;

public class ClienteService {

	private final ClienteRepositorio repositorio;
	private final EntityManager manager;

	public ClienteService() {
		this.manager = new ConnectionFactory().getEntityManager();
		this.repositorio = new ClienteRepositorio(manager);
	}

	public void salvar(Cliente cliente) {
		try {
			manager.getTransaction().begin();
			repositorio.salvar(cliente);
			manager.getTransaction().commit();
			System.out.println("Cliente salvo com sucesso");

		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
		} finally {
			manager.close();
		}

		System.out.println("Conexão fechada");
	}
	
	public void remover(Cliente cliente) {

		try {
			manager.getTransaction().begin();

			
			for (Emprestimo emprestimo : cliente.getEmprestimos()) {
				if (emprestimo.getStatus())
					throw new ExclusaoClienteException("Cliente possui débito em emprestimo. Não pode ser excluído");
			}
			
			cliente.setAtivo(false);
			repositorio.salvar(cliente);
			manager.getTransaction().commit();
			
			System.out.println("Cliente Excluído com sucesso");

		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			manager.close();
		}
	}
	
	
	public Cliente buscar(int id) {
		return repositorio.buscaPorId(id);
	}

}
