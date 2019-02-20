package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.EmprestimoVideo;

public class EmprestimoVideoDAO {
	
	private Connection conexao;

	public EmprestimoVideoDAO(Connection conexao) {
		super();
		this.conexao = conexao;
	}
	
	public EmprestimoVideo salvar(EmprestimoVideo ev) throws SQLException{
		
		String sql = "INSERT INTO emprestimo_video (idVideo, idEmprestimo) VALUES(?, ?)";
		try(PreparedStatement ps = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			ps.setInt(1,ev.getVideo().getId());
			ps.setInt(2,ev.getEmprestimo().getId());
			
			ps.executeUpdate();
			
			try(ResultSet key = ps.getGeneratedKeys()){
				key.next();
				int id = key.getInt(1);
				ev.setId(id);
			}
		}
		
		return ev;
	}

}
