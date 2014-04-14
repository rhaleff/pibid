package poo.maven.projeto.pibid;

public class Aluno extends Pessoa{
	
	public Aluno(String nome, String matricula){
		super(nome, matricula);
	}
	
	public String getDescricao(){
		return "Nome: "+super.getNome()+" | Matr�cula: "+super.getMatricula();
	}
	public String toString(){
		return getDescricao();
	}

}
