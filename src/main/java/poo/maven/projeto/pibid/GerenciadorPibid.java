package poo.maven.projeto.pibid;
import java.util.LinkedList;
import java.util.List;

public class GerenciadorPibid{
	
	private List<Aluno> alunos=new LinkedList<Aluno>();
	private List<Coordenador> coordenadores=new LinkedList<Coordenador>();
	
	//PARTE DE CADASTRO
	public void cadastraAluno(Aluno aluno){
		for (Aluno a: this.alunos){
			if(a.getMatricula().equals(aluno.getMatricula())){
				throw new AlunoExistenteException("Aluno Existente!");
			}
		}
		this.alunos.add(aluno);
	}
	
	public void cadastraCoordenador(Coordenador coo1) {
		for (Coordenador c: this.coordenadores){
			if(c.getMatricula().equals(coo1.getMatricula())){
				throw new CoordenadorExistenteException("Coordenador Existente!");
			}
		}
		this.coordenadores.add(coo1);
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
	
		for (Aluno x: this.alunos){
			if (x.getMatricula().equals(matricula)){
				this.alunos.remove(x);
				return;
			}
		}
		throw new AlunoInexistenteException("Impossível remover, pois não existe!");		
	}
	
	public void removerCoordenadorPeloSiape(String siape){
		
		for (Coordenador c: this.coordenadores){
			if(c.getMatricula().equals(siape)){
			 	this.coordenadores.remove(c);
				return;
			}
		}
		throw new CoordenadorInexistenteException("Impossível remover, pois não existe!");
	}		
}
