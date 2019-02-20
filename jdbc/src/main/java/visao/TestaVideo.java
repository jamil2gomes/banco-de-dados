package visao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import dao.FilmeDAO;
import dao.VideoDAO;
import infra.ConnectionPool;
import modelo.Filme;
import modelo.Video;

public class TestaVideo {

	public static void main(String[] args) throws SQLException {
		
		   
		try (Connection conexao = new ConnectionPool().getConexao()) {
			
			FilmeDAO fd = new FilmeDAO(conexao);
			VideoDAO vd = new VideoDAO(conexao);
			
			//localiza filme já cadastrado no bd
			Filme filmeLocalizado = fd.procurarPelo(1);
			
			//cria um objeto video
			Video video = new Video("dvd", new BigDecimal(1.50), filmeLocalizado);
			
			//salva no bd
			Video salvo = vd.salvar(video);
			
			System.out.println("O " + salvo + " foi salvo com sucesso!");

	}
	
	}
}
