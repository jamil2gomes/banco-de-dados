package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import conexao.ConnectionFactory;
import modelo.Emprestimo;
import repositorio.EmprestimoRepositorio;

public class EmprestimoService {

	private final EntityManager manager;
	private final EmprestimoRepositorio repositorio;
	
	public EmprestimoService(){
		this.manager = new ConnectionFactory().getEntityManager();
		this.repositorio = new EmprestimoRepositorio(manager);
	}
	
	
	public void locar(Emprestimo emprestimo) {
		
		try {
			
			manager.getTransaction().begin();
			
			if(!buscaPorDebito(emprestimo.getCliente().getId()).isEmpty()) {
				throw new DebitoEmEmprestimoException("Cliente possui emprestimo em aberto. Não pode fazer um novo!");
			}
			
			repositorio.salvar(emprestimo);
			
			manager.getTransaction().commit();
			System.out.println("Locacao realizada com sucesso!");
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			manager.close();
		}
	}
	
	public void devolucao(Emprestimo emprestimo) {
		
		try {
			manager.getTransaction().begin();
			emprestimo.setStatus(false);
			repositorio.salvar(emprestimo);
			manager.getTransaction().commit();
			System.out.println("Devolução salva com sucesso!");
		} catch (PersistenceException e) {
			System.err.println(e.getMessage());
		}finally {
			manager.close();
		}
	}
	
	public Emprestimo busca(int id) {
		return repositorio.porId(id);
	}
	
	public List<Emprestimo> buscaPorDebito(int idCliente){
		return repositorio.temDebito(idCliente);
	}
}
