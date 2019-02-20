package infra;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ConnectionPool {

private DataSource dataSource;
	
	
	public ConnectionPool() {
		
		MysqlDataSource mysqlDataSource = new MysqlDataSource();
		String url = "jdbc:mysql://localhost/locadora?useSSL=false";
		
		mysqlDataSource.setURL(url);
		mysqlDataSource.setUser("root");
		mysqlDataSource.setPassword("");
		
		this.dataSource = mysqlDataSource;
		
	}
	
	
	public Connection getConexao() throws SQLException {
		
		Connection conexao = dataSource.getConnection();
	
		return conexao;
	}
}
