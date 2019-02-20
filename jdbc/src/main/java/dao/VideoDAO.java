package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import modelo.Video;

public class VideoDAO {

	private Connection conexao;

	public VideoDAO(Connection conexao) {
		
		this.conexao = conexao;
	}
	
	
	public Video salvar(Video video)throws SQLException
	{
		String sql = "INSERT INTO video (tipo, valorDiaria,idFilme) VALUES(?,?,?)";
		try(PreparedStatement ps = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			ps.setString(1,video.getTipo());
			ps.setBigDecimal(2,video.getValorDiaria());
			ps.setInt(3,video.getFilme().getId());
			
			ps.executeUpdate();
			
			try(ResultSet key = ps.getGeneratedKeys()){
				key.next();
				int id = key.getInt(1);
				video.setId(id);	
			}
		}
		
		
		return video;
	}
	
	
	public Video buscaVideoPor(int id) {
		
		try (PreparedStatement ps = this.conexao
				.prepareStatement("select * from video where id = ?") ) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				return null;
			}
			Video video = new Video();
			
			video.setTipo(rs.getString("tipo"));
			video.setValorDiaria(rs.getBigDecimal("valorDiaria"));
			video.setId(rs.getInt("id"));
	
			
			return video;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
}
