package poo.maven.projeto.pibid;

public class Coordenador extends Pessoa{
	public Coordenador(String nome, String siape){
		super(nome, siape);
	}
	public String getDescricao(){
		return "Nome: "+super.getNome()+" | SIAPE: "+super.getMatricula();
	}
	public String toString(){
		return getDescricao();
	}

}
