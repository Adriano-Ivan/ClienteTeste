package model;
public class Cliente {
    private int codigo;
    private Integer idade;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Integer numCartaoExclusivo;

    public int getCodigo() {
		return codigo;
	}
		
	public void setCodigo(int c) {
		this.codigo = c;
	}
	
	public Integer getIdade() {
		return idade;
	}
		
	public void setIdade(Integer idade) {
		this.idade= idade;
	}

	public String getNome() {
		return nome;
	}
		
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return cpf;
	}
		
	public void setCPF(String cpf) {
		this.cpf=cpf;
	}	
		
	public String getTelefone() {
		return telefone;
	}
		
	public void setTelefone(String telefone) {
		this.telefone=telefone;
	}

    public String getEmail() {
		return email;
	}
		
	public void setEmail(String email) {
		this.email=email;
	}
     public Integer getCartaoExclusivo() {
		return numCartaoExclusivo;
	}
		
	public void setCartaoExclusivo(Integer cartaoExlusivo) {
		this.numCartaoExclusivo=cartaoExlusivo;
	}
}