package poo.maven.projeto.pibid;
import java.util.LinkedList;
import java.util.List;

public class GerenciadorPibid{
	
	private List<Aluno> alunos=new LinkedList<Aluno>();
	private List<Coordenador> coordenadores=new LinkedList<Coordenador>();
	
	//PARTE DE CADASTRO
	public void cadastraAluno(Aluno aluno){
		boolean existe=false;
		for (Aluno a: this.alunos){
			if(a.getMatricula().equals(aluno.getMatricula())){
				existe=true;
				break;
			}
		}
		if(existe==false){
			this.alunos.add(aluno);
		}
		else{
			throw new AlunoExistenteException("Aluno Existente!");
		}
	}
	
	public void cadastraCoordenador(Coordenador coo1) {
		boolean existe=false;
		for (Coordenador c: this.coordenadores){
			if(c.getMatricula().equals(coo1.getMatricula())){
				existe=true;
				break;
			}
		}
		if(existe==false){
			this.coordenadores.add(coo1);
		}
		else{
			throw new CoordenadorExistenteException("Coordenador Existente!");
		}
	}
	
	public void cadastrarParticipante(Aluno a,Grupo g) {
		g.cadastrarParticipante(a);
		
	}
	
    //PARTE DE ADICIONAR
	public void adicionarTarefaAoGrupo(Tarefa t, Grupo g){
		g.addTarefa(t);
	}
	
	// PARTE DE GETS
	public List<Coordenador> getListaDeCoordenadoresCriados(){
		return this.coordenadores;	
	}

	public List<Aluno> getListaDeAlunosCriados(){
		return this.alunos;
	}
	
	public List<Tarefa> getListaDeTarefasCadastradasEmUmGrupo(Grupo g1) {
		return g1.listTarefas();
	
		
	}
	
	//PARTE DE PESQUISAS
	
	public Aluno pesquisaAluno(String matricula){
		
		for ( Aluno a: alunos){
			if(a.getMatricula().equals(matricula)){
				
				return a;
			}
		}
		throw new AlunoInexistenteException ("Aluno Inexistente!");
	}
	
	public Aluno pesquisarAlunoPeloNome(String nome){
		for (Aluno a: alunos){
			if(a.getNome().equals(nome)){
				return a;
		}
	}
	throw new AlunoInexistenteException ("Aluno Inexistente!");
}

	public Coordenador pesquisarCoordenador(String siape){
		
		for ( Coordenador c: this.coordenadores){
			if ( c.getMatricula().equals(siape)){
				return c;
			}
		}
		throw new CoordenadorInexistenteException ("Coordenador Inexistente!");
	}
	
	public Coordenador pesquisarCoordenadorPeloNome(String nome){
		for(Coordenador c: this.coordenadores){
			if(c.getNome().equals(nome)){
				return c;
			}
		}
		throw new CoordenadorInexistenteException ("Coordenador Inexistente!");
	}
    	
	//PARTE DE REMO��O
	public void removerAlunoPelaMatricula(String matricula) {
		
		boolean removeu = false;
		
		for (Aluno x: this.alunos){
			
			if (x.getMatricula().equals(matricula)){
				removeu = true;
				this.alunos.remove(x);
				break;
			}
			
			
		}
		if(removeu ==false){
			throw new AlunoInexistenteException("Imposs�vel remover, pois n�o existe!");
		}
			
	}
	
	public void removerCoordenadorPeloSiape(String siape){
		boolean removeu = false;
		
		for (Coordenador c: this.coordenadores){
			
			if(c.getMatricula().equals(siape)){
				removeu = true;
				this.coordenadores.remove(c);
				break;
			}
		}
		if(removeu == false){
			throw new CoordenadorInexistenteException("Imposs�vel remover, pois não existe!");
		}
	}		
}
