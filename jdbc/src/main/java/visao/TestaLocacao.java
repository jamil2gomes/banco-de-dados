package visao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import dao.ClienteDAO;
import dao.EmprestimoDAO;
import dao.EmprestimoVideoDAO;
import dao.VideoDAO;
import infra.ConnectionPool;
import modelo.Cliente;
import modelo.Emprestimo;
import modelo.EmprestimoVideo;
import modelo.Video;

public class TestaLocacao {

	public static void main(String[] args) throws SQLException {
		
		try (Connection conexao = new ConnectionPool().getConexao()) {
			
			
			ClienteDAO cliDao = new ClienteDAO(conexao);
			VideoDAO vDao = new VideoDAO(conexao);
			EmprestimoDAO empDao = new EmprestimoDAO(conexao);
			EmprestimoVideoDAO empvidDAO = new EmprestimoVideoDAO(conexao);
			
			
			//busca cliente cadastrado no bd
			Cliente cliente = cliDao.buscaClientePor(1);
			System.out.println("Cliente " + cliente.getCpf() + "está procurando um filme...");
			
			//busca video cadastrado no bd
			Video video = vDao.buscaVideoPor(1);
			System.out.println("Cliente " +cliente.getCpf()+" achou um vídeo do tipo  "+video.getTipo());
			
			
			
			
			//cria o empréstimo
			Emprestimo emprestado = new Emprestimo(LocalDate.now(), LocalDate.of(2018, 12, 3), false, new BigDecimal(5.00), cliente);
			System.out.println("Locação sendo criada...");
			
			
			//salva esse empréstimo no bd
			Emprestimo salvo = empDao.fazerLocacao(emprestado);
			System.out.println("Locação " + salvo + "salva com sucesso!");
			
			//cria objeto que representa a tabela de relacionamentos
			EmprestimoVideo empv = new EmprestimoVideo(emprestado, video);
			
			//salva no bd
			empvidDAO.salvar(empv);
			
			
	}
  }
}
