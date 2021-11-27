package model;
import java.sql.*;
import java.util.Vector;
import java.util.ArrayList;

public class DaoCliente {
    private Connection conn;
    private Statement st;

    private void conectar() {
        try {
            conn = GerenciadorConexao.pegarConexao();
            st=conn.createStatement();
        }catch(ClassNotFoundException e1){
            System.out.println(e1.getMessage());
        }catch(SQLException e2){
            System.out.println(e2.getMessage());
        }
    }

    private void desconectar() {
        try {
            st.close();
            conn.close();
        }catch(SQLException e){
            System.out.println("ERRO AO FECHAR A CONEXAO: "+e.getMessage());
        }
    }

    public boolean inserir(Cliente c){
		boolean resultado = false;
		try{
			conectar();
			String comando = "INSERT INTO tb_clientes(nome,idade,cpf,telefone,email,numCartaoExclusivo) VALUES ( '"
				+ c.getNome() + "', " + c.getIdade() + ", '"
				+ c.getCPF() + "', '" + c.getTelefone() + "', '"
                + c.getEmail()+"', " + c.getCartaoExclusivo()+");";
			
			System.out.println("SQL: " + comando);
			
			st.executeUpdate(comando);
			resultado = true;
		}catch(SQLException e){
			System.out.println("Erro ao inserir o registro: " + e.getMessage());
		}finally{
			desconectar();
		}
		return resultado;
	}

	public ArrayList<Cliente> buscarTodos(){
		ArrayList<Cliente> resultados = new ArrayList<Cliente>();
		try{
			conectar();
			ResultSet rs = st.executeQuery("select * from tb_clientes order by nome;");
			while(rs.next()){
				Cliente c = new Cliente();
				c.setCodigo(rs.getInt("codigo"));
				c.setNome(rs.getString("nome"));
				c.setCPF(rs.getString("cpf"));
				c.setTelefone(rs.getString("telefone"));
				c.setIdade(rs.getInt("idade"));
                c.setEmail(rs.getString("email"));
                c.setCartaoExclusivo(rs.getInt("numCartaoExclusivo"));
				
				resultados.add(c);
			}
		}catch(SQLException e){
			System.out.println("Erro: " + e.getMessage());
		}finally{
			desconectar();
		}
		return resultados;
	}	
        public ArrayList<Cliente> buscarPorFiltro(String campo, String filtro) {
            ArrayList<Cliente> resultado = new ArrayList<Cliente>();
            
            if(!campo.equals("email") && !campo.equals("nome") && !campo.equals("cpf")
                    && !campo.equals("telefone")){
                return resultado;
            }
            
            try {
                conectar();
                ResultSet result = st.executeQuery("SELECT * FROM  tb_clientes WHERE " +
                        campo + " LIKE '%"+filtro+"%' ORDER BY codigo");
                
                while(result.next()){
                    Cliente c = new Cliente();
                    c.setCodigo(result.getInt("codigo"));
                    c.setCPF(result.getString("cpf"));
                    c.setCartaoExclusivo(result.getInt("numCartaoExclusivo"));
                    c.setIdade(result.getInt("idade"));
                    c.setEmail(result.getString("email"));
                    c.setTelefone(result.getString("telefone"));
                    c.setNome(result.getString("nome"));
                    
                    resultado.add(c);
                }
            }catch(SQLException e){
                System.out.println("ERRO: "+e.getMessage());
            } finally {
                desconectar();
            }
            return resultado;
        }
	public int excluir(int cod){
		int qtde = 0;
		try{
			conectar();
			String comando = "delete from tb_clientes where codigo = " + cod + ";";
			st.executeUpdate(comando);
			qtde = st.getUpdateCount();//mostra quantos registros foram afetados no BD
		}catch(SQLException e){
			System.out.println("Erro: " + e.getMessage());
		}finally{
			desconectar();
		}		
		return qtde;
	}	
	public Cliente consultar(int id){
		Cliente c = null;
		try {
			conectar();
			String comando = "SELECT * FROM tb_clientes WHERE codigo= "+id+";";
			ResultSet rs = st.executeQuery(comando);
			if(rs.next()){
				c = new Cliente();
				c.setCodigo(rs.getInt("codigo"));
				c.setIdade(rs.getInt("idade"));
				c.setNome(rs.getString("nome"));
				c.setCPF(rs.getString("cpf"));
				c.setEmail(rs.getString("email"));
				c.setCartaoExclusivo(rs.getInt("numCartaoExclusivo"));
				c.setTelefone(rs.getString("telefone"));

			}
		}catch(SQLException e){
			System.out.println("ERRO: "+e.getMessage());
		}finally{
			desconectar();
		}
		return c;
	}
	public int alterar(Cliente c){
		int qtde = 0;
		try {
			conectar();
			String comando="UPDATE  tb_clientes SET idade = " + c.getIdade()
				+ ", nome = '" + c.getNome() + "', cpf = '" + c.getCPF() 
				+ "', email = '" + c.getEmail() +"', numCartaoExclusivo = "+c.getCartaoExclusivo()
				+ ", telefone='"+c.getTelefone()+"'"+" WHERE codigo = " + c.getCodigo() + ";";  
			st.executeUpdate(comando);
			qtde = st.getUpdateCount();
		}catch(SQLException e){
			System.out.println("ERRO: "+e.getMessage());
		}finally {
			desconectar();
		}
		return qtde;
	}
}