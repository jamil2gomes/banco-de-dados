package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Filme;

public class FilmeDAO {

	private Connection conexao;

	public FilmeDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public Filme salvar(Filme filme) throws SQLException {

		String sql = "INSERT INTO filme(titulo,anoLancamento,duracao,genero) VALUES (?,?,?,?) ";

		try (PreparedStatement ps = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			ps.setString(1, filme.getTitulo());
			ps.setInt(2, filme.getAnoLancamento());
			ps.setInt(3, filme.getDuracao());
			ps.setString(4, filme.getGenero());

			ps.executeUpdate();

			try (ResultSet key = ps.getGeneratedKeys()) {
				key.next();
				int id = key.getInt(1);
				filme.setId(id);
			}

		}

		return filme;

	}

	public Filme procurarPelo(int id) {

		try (PreparedStatement ps = this.conexao
				.prepareStatement("select * from filme where id = ?") ) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				return null;
			}
			Filme filme = new Filme();
			filme.setTitulo(rs.getString("titulo"));
			filme.setAnoLancamento(rs.getInt("anoLancamento"));
			filme.setDuracao(rs.getInt("duracao"));
			filme.setGenero(rs.getString("genero"));
			filme.setId(rs.getInt("id"));
			
			return filme;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Filme atualizar(Filme filme) throws SQLException {

		String sql = "UPDATE filme SET titulo = ?,anoLancamento = ?,duracao = ?,genero = ? WHERE id = ? ";

		try (PreparedStatement ps = this.conexao.prepareStatement(sql)) {

			ps.setString(1, filme.getTitulo());
			ps.setInt(2, filme.getAnoLancamento());
			ps.setInt(3, filme.getDuracao());
			ps.setString(4, filme.getGenero());
			ps.setInt(5, filme.getId());

			ps.execute();

		}

		return filme;

	}

	public List<Filme> listarTodosFilmes() throws SQLException {

		String sql = "SELECT * FROM filme";
		try (PreparedStatement statment = conexao.prepareStatement(sql)) {

			ResultSet resultSet = statment.executeQuery(sql);

			List<Filme> filmes = new ArrayList<>();

			while (resultSet.next()) {

				String titulo = resultSet.getString("titulo");
				int anoLancamento = resultSet.getInt("anoLancamento");
				int duracao = resultSet.getInt("duracao");
				String genero = resultSet.getString("genero");

				int id = resultSet.getInt("id");
				Filme filme = new Filme(anoLancamento, duracao, titulo, genero);
				filme.setId(id);

				filmes.add(filme);
			}
			return filmes;
		}

	}

}
