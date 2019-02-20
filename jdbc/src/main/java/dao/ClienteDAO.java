package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Cliente;


public class ClienteDAO {
	
	private Connection conexao;

	public ClienteDAO(Connection conexao) {
		super();
		this.conexao = conexao;
	}
	
	
	public Cliente buscaClientePor(int id) {
		
		try (PreparedStatement ps = this.conexao
				.prepareStatement("select * from cliente where id = ?") ) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				return null;
			}
			Cliente cliente = new Cliente();
			cliente.setCpf(rs.getString("cpf"));
			cliente.setEndereco(rs.getString("endereco"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setId(rs.getInt("id"));
			
			return cliente;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
