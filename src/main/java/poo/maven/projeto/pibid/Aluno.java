package poo.maven.projeto.pibid;

public class Aluno{
	
	Pessoa pessoa = new Pessoa();
	public Aluno(String nome, String matricula){
		pessoa.setNome(nome);
		pessoa.setMatricula(matricula);
	}
	
	public String getMatricula() {
		return pessoa.getMatricula();
	}

	public String getNome() {
		return pessoa.getNome();
	}

}
