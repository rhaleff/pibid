package poo.maven.projeto.pibid;

public class Coordenador{
	Pessoa pessoa = new Pessoa();
	
	public Coordenador(String nome,String siape){
		pessoa.setNome(nome);
		pessoa.setMatricula(siape);
	}
	public String getDescricao(){
		return "Nome: "+pessoa.getNome()+" | SIAPE: "+pessoa.getMatricula();
	}
	public String toString(){
		return getDescricao();
	}
	public String getMatricula() {
		return pessoa.getMatricula();
	}
	public String getNome() {
		return pessoa.getNome();
	}

}
