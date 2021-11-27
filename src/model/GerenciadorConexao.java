package model;
import java.sql.*;  
  
public class GerenciadorConexao {
	private static Connection conexao;

	public static Connection pegarConexao() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://127.0.0.1/dblocadora?characterEncoding=latin1";
        //em caso de erro, colocar o encoding, mas nem sempre eh necessario:
        //url = "jdbc:mysql://127.0.0.1/dblocadora";
		String usuario = "root";
		String senha = "admin";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conexao = DriverManager.getConnection(url, usuario, senha);
		return(conexao);
	}		
} 
