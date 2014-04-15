package poo.maven.projeto.pibid;
import java.util.List;

public class Pibid {
	
	private GerenciadorPibid gerenciador;
	private GerenciadorDeEscola gerenciadorEscola;
	private GerenciadorDeGrupo gerenciadorGrupo;
	private GerenciadorDeTerefas gerenciadorTarefas;
	private GerenciadorDeMaterial gerenciadorMaterial;
	
	public Pibid(){
		this.gerenciador= new GerenciadorPibid();
		this.gerenciadorEscola= new GerenciadorDeEscola(); 
		this.gerenciadorGrupo= new GerenciadorDeGrupo();
		this.gerenciadorTarefas= new GerenciadorDeTerefas();
		this.gerenciadorMaterial = new GerenciadorDeMaterial();
	}
	
	//PARTE DE CADASTROS
	public void cadastrarAluno(Aluno aluno){
		this.gerenciador.cadastraAluno(aluno);
	}
	public List<Aluno> getParticipantes(String cod){
		Grupo g= this.gerenciadorGrupo.pesquisarGrupo(cod);
		return g.listParticipantes();
	}
	
	public void cadastraCoordenador(Coordenador coord){
		this.gerenciador.cadastraCoordenador(coord);	
	}
	
	public void cadastrarTarefa(Tarefa tarefa){
		this.gerenciadorTarefas.cadastraTarefa(tarefa);
	}
	
	public void cadastrarGrupo(Grupo grupo) {
		this.gerenciadorGrupo.cadastrarGrupo(grupo);
	}
	
	public void cadastrarParticipante(Aluno a,Grupo g) {
		this.gerenciador.cadastrarParticipante(a,g);
		
	}
	
	public void cadastrarEscola(Escola e){
		this.gerenciadorEscola.cadastrarEscola(e);
	}
	
	public void cadastrarMaterial(Material m){
		this.gerenciadorMaterial.cadastrarMaterial(m);
	}

	//PARTE DE ADICIONAR
	public void adicionarTarefaAoGrupo(Tarefa t, Grupo g){
		this.gerenciador.adicionarTarefaAoGrupo(t, g);
	}
	
	// PARTE DE GETS
	public List<Coordenador> getListaDeCoordenadoresCriados(){
		return this.gerenciador.getListaDeCoordenadoresCriados();
	}
	
	public List<Aluno> getListaDeAlunosCriados(){
		return this.gerenciador.getListaDeAlunosCriados();
	}

	public List<Tarefa> getListaDeTarefas() {
		return this.gerenciadorTarefas.getListaDeTarefas();
	}
	
	public List<Grupo> getListaDeGrupo(){
		return this.gerenciadorGrupo.getListaDeGrupos();
	}
	
	public List<Tarefa> getListaDeTarefasCadastradasEmUmGrupo(Grupo g) {
		return this.gerenciador.getListaDeTarefasCadastradasEmUmGrupo(g);
	}
	
	public List<Escola> getEscola (){
		return this.gerenciadorEscola.getEscolas();
	}
	
	public List <Material> getListaDeMateriais (){
		return this.gerenciadorMaterial.getListaDeMateriais();
	}

	public Material getMaterial (String codigo){
		return this.gerenciadorMaterial.getMaterial(codigo);
	}
	
	// PARTE DE PESQUISAS
	public Grupo pesquisarGrupo(String codigo){
		return this.gerenciadorGrupo.pesquisarGrupo(codigo);
	}
	
	public Material pesquisarMaterial (String codMaterial){
		return this.gerenciadorMaterial.pesquisarMaterial(codMaterial);
	}
	
	public Aluno pesquisaAluno(String matricula){
		return this.gerenciador.pesquisaAluno(matricula);
	}
	
	public Aluno pesquisarAlunoPeloNome(String nome){
		return this.gerenciador.pesquisarAlunoPeloNome(nome);
	}
	
	public Coordenador pesquisarCoordenador(String siape){
		return this.gerenciador.pesquisarCoordenador(siape);
	}
	
	public Coordenador pesquisarCoordenadorPeloNome(String nome){
		return this.gerenciador.pesquisarCoordenadorPeloNome(nome);
	}
	
	public Tarefa pesquisarTarefa(String codTarefa){
		return this.gerenciadorTarefas.pesquisarTarefa(codTarefa);
	}
	
	public Escola pesquisarEscolaPeloNome (String n){
		return this.gerenciadorEscola.pesquisarEscolaPeloNome(n);
	}
	
	public Escola pesquisarEscolaPeloCod(String cod){
		return this.gerenciadorEscola.pesquisarEscolaPeloCod(cod);
	}

	// PARTE DE REMOÇÕES
	public void removerAlunoPelaMatricula(String matricula){
		this.gerenciador.removerAlunoPelaMatricula(matricula);
	}
	
	public void removerMaterial(String codMaterial){
		this.gerenciadorMaterial.removerMaterial(codMaterial);
	}
	
	public void removerCoordenadorPeloSiape(String siape){
		this.gerenciador.removerCoordenadorPeloSiape(siape);
	}
	public void atualizarMaterial(Material m){
		this.gerenciadorMaterial.atualizarMaterial(m);
		
	}
	public void removerTarefa(String cod) {
		this.gerenciadorTarefas.removerTarefa(cod);
	}
	public void removerTarefaDoGrupo(Tarefa t, Grupo g){
		this.gerenciadorTarefas.removerTarefaDoGrupo(t,g);
	}
	 
	public void removerEscolaPeloCod (String cod){
		this.gerenciadorEscola.removerEscolaPeloCod(cod);
	}
	
	
	
	
	

}
 