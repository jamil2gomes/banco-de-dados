package visao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.FilmeDAO;
import infra.ConnectionPool;
import modelo.Filme;

public class TesteFilme {

	public static void main(String[] args) throws SQLException {

//		Filme filme = new Filme(2018, 120, "DeadPool 2", "fantasia");
//		
//		salvar(filme);

		// atualizarFilmePelo(1);

	//	listarFilmes();

	}

	public static void salvar(Filme filme) throws SQLException {

		try (Connection conexao = new ConnectionPool().getConexao()) {

			FilmeDAO fd = new FilmeDAO(conexao);
			Filme filmeSalvo = fd.salvar(filme);

			System.out.println("O " + filmeSalvo + " foi salvo com sucesso!");

			System.out.println("############################################");

		}

	}

	public static void atualizarFilmePelo(int id) throws SQLException {

		try (Connection conexao = new ConnectionPool().getConexao()) {

			FilmeDAO fd = new FilmeDAO(conexao);

			Filme filmeLocalizado = fd.procurarPelo(id);

			System.out.println("filme localizado:" + filmeLocalizado);

			if (filmeLocalizado != null) {
				filmeLocalizado.setTitulo("Pantera Negra");
				;
				Filme atualizado = fd.atualizar(filmeLocalizado);
				System.out.println("O " + atualizado + " foi atualizado com sucesso!");
			} else {
				System.out.println("O filme não pôde ser localizado!");
			}
			System.out.println("############################################");

		}
	}

	public static void listarFilmes() throws SQLException {

		try (Connection conexao = new ConnectionPool().getConexao()) {

			FilmeDAO fd = new FilmeDAO(conexao);

			List<Filme> filmes = fd.listarTodosFilmes();

			filmes.forEach(System.out::println);
		}
	}
}
