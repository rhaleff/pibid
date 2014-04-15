package poo.maven.projeto.pibid;
public class Escola {
	
	private String nome;
	private String cidade;
	private String codDoMec;
	
	public Escola(String nome,String cidade,String cod){
		this.nome=nome;
		this.cidade=cidade;
		this.codDoMec=cod;
	}
	
	public String getNome(){
		return this.nome;
	}
	public void setNome(String nome){
		this.nome=nome;
	}
	public String getCidade(){
		return this.cidade;
	}
	public void setCidade(String cidade){
		this.cidade=cidade;
	}
	public String getCodDoMec(){
		return this.codDoMec;
	}
	public void setCodDoMec(String cod){
		this.codDoMec=cod;
	}
	
}
