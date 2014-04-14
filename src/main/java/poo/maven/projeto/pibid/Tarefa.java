package poo.maven.projeto.pibid;
public class Tarefa{
	private String descricao;
	private String codDaTarefa;
	
	public Tarefa(String descricao,String cod){
		this.codDaTarefa=cod;
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
	
	public String getcodDaTarefa(){
		return this.codDaTarefa;
		
	}
}
