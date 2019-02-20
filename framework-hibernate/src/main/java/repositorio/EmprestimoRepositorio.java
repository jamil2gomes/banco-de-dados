package repositorio;

import java.util.List;

import javax.persistence.EntityManager;


import modelo.Emprestimo;


public class EmprestimoRepositorio {

	private final EntityManager manager;

	public EmprestimoRepositorio(EntityManager manager) {
		this.manager = manager;
	}

	public Emprestimo salvar(Emprestimo emprestimo) {
		return manager.merge(emprestimo);
		
	}

	public void remover(Emprestimo emprestimo) {
			manager.remove(emprestimo);

	}

	public Emprestimo porId(Integer id) {
		return manager.find(Emprestimo.class, id);
	}
	
	public List<Emprestimo> temDebito(int idCliente) {
		return this.manager.createQuery("from Emprestimo where cliente_id=:idCliente and status = true",Emprestimo.class)
                .setParameter("idCliente", idCliente)
                .getResultList();
	}
	
	public Emprestimo buscaPorNome(String nomeCliente) {
		return this.manager.createQuery("from Emprestimo " +
                "inner join Cliente on Emprestimo.id_cliente = Cliente.id_cliente where Cliente.nome : nomeCLiente and status = true",Emprestimo.class)
                .setParameter("nomeCliente", nomeCliente)
                .getSingleResult();
	}
	
	
}


