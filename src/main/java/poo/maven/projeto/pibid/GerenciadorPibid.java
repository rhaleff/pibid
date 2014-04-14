package poo.maven.projeto.pibid;
import java.util.LinkedList;
import java.util.List;

public class GerenciadorPibid{
	
	private List<Aluno> alunos=new LinkedList<Aluno>();
	private List<Coordenador> coordenadores=new LinkedList<Coordenador>();
	private List<Grupo> grupos= new LinkedList<Grupo>();
	private List<Tarefa> tarefas= new LinkedList<Tarefa>();
	
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
	
	public void cadastrarGrupo(Grupo grupo){
		boolean existe = false;
		
		for(Grupo g: this.grupos){
			if(g.getCodigoGrupo().equals(grupo.getCodigoGrupo())){
				existe = true;
			}
		}
		if(!existe){
			this.grupos.add(grupo);
		}
		else{
			throw new GrupoJaexisteException("O grupo j� existe,por favor ultilize outro c�digo de identifica��o!");
		}
	}
	
	public void cadastraTarefa(Tarefa tarefa) {
		this.tarefas.add(tarefa);	
	}
	
	public void cadastrarAlunosEmGrupo(){
		Tarefa t = new Tarefa("Ministrar curso de Scratch","4346");
		Grupo g = new Grupo(t,"123");
		Aluno a = new Aluno("Deyvison","12234576");
		Aluno a1 = new Aluno("Tayna","53344545");
		g.cadastrarParticipante(a);
		g.cadastrarParticipante(a1);
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
	
	public List<Tarefa> getListaDeTarefas() {
		return this.tarefas;
	}
	
	public List<Grupo> getListaDeGrupos(){
		return this.grupos;
	}

	public List<Tarefa> getListaDeTarefasCadastradasEmUmGrupo(Grupo g1) {
		return g1.listTarefas();
	
		
	}
	
	//PARTE DE PESQUISAS
	public Grupo pesquisarGrupo(String codigo){
		for(Grupo i: this.grupos){
			if(i.getCodigoGrupo().equals(codigo)){
				return i;
			}
		}
		return null;
	}
	
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
    
	public Tarefa pesquisarTarefa(String codTarefa){
		for (Tarefa x : this.tarefas) {
			if (x.getcodDaTarefa().equals(codTarefa)) {
				return x;
			}
		}
		return null;
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
			throw new CoordenadorInexistenteException("Imposs�vel remover, pois n�o existe!");
		}
	}
	
	public void removerTarefaDoGrupo(String codTarefa, String codGrupo){
		for(Grupo x: this.grupos){
			if(x.getCodigoGrupo().equals(codGrupo)){
				for(Tarefa y: x.listTarefas()){
					if(y.getcodDaTarefa().equalsIgnoreCase(codTarefa)){
						x.listTarefas().remove(y);
						
					}
				}
			}
		}	
		
	}
	
	public void removerTarefa(String cod) {
		boolean removeu = false;
		for(Tarefa t : this.tarefas){
			if(t.getcodDaTarefa().equals(cod)){
				this.tarefas.remove(t);
				removeu = true;
				break;
			}
		}
		if(!removeu){
			throw new RuntimeException("ERRO!");
		}
		
	}
	public void removerTarefaDoGrupo(Tarefa t, Grupo g){
		g.removerTarefa(t);
		
	}
		
}
