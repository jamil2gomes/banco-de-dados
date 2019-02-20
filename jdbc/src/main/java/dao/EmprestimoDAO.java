package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Emprestimo;

public class EmprestimoDAO {

	private Connection conexao;

	public EmprestimoDAO(Connection conexao) {
		super();
		this.conexao = conexao;
	}

	public Emprestimo fazerLocacao(Emprestimo emprestimo) throws SQLException {

		String sql = "INSERT INTO emprestimo (dataLocacao, dataDevolucao, valorAluguel,statusEmprestimo,idCliente)"
				+ "VALUES(?,?,?,?,?)";

		try (PreparedStatement ps = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			ps.setDate(1, Date.valueOf(emprestimo.getDataLocacao()));
			ps.setDate(2, Date.valueOf(emprestimo.getDataDevolucao()));
			ps.setBigDecimal(3, emprestimo.getValorAluguel());
			ps.setBoolean(4, emprestimo.getStatusEmprestimo());
			ps.setInt(5, emprestimo.getCliente().getId());

			ps.executeUpdate();

			try (ResultSet key = ps.getGeneratedKeys()) {
				key.next();
				int id = key.getInt(1);
				emprestimo.setId(id);
			}

		}

		return emprestimo;
	}
	

	public Emprestimo fazerDevolucao(Emprestimo emprestimo) throws SQLException {

		String sql = "UPDATE emprestimo SET statusEmprestimo = ? WHERE id = " + emprestimo.getId();

		try (PreparedStatement ps = this.conexao.prepareStatement(sql)) {

			ps.setBoolean(1, emprestimo.getStatusEmprestimo());

			ps.executeUpdate();
			
		}
		
		return emprestimo;
	}
	
	
public Emprestimo buscarEmprestimoPor(int id) {
	
	try (PreparedStatement ps = this.conexao
			.prepareStatement("select * from emprestimo where id = ?") ) {

		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (!rs.next()) {
			return null;
		}
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setDataLocacao(rs.getDate("dataLocacao").toLocalDate());
		emprestimo.setDataDevolucao(rs.getDate("dataDevolucao").toLocalDate());
		emprestimo.setStatusEmprestimo(rs.getBoolean("statusEmprestimo"));
		emprestimo.setValorAluguel(rs.getBigDecimal("valorAluguel"));
		return emprestimo;

	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
}

}
