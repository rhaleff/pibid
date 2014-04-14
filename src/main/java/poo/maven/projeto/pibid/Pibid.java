package poo.maven.projeto.pibid;
import java.util.List;

public class Pibid {
	
	private GerenciadorPibid gerenciador;
	private GerenciadorDeMaterial gerenciadorMaterial;
	private GerenciadorDeEscola gerenciadorEscola;
	private GerenciadorDeGrupo gerenciadorGrupo;
	private GerenciadorDeTerefas gerenciadorTarefas;
	
	public Pibid(){
		this.gerenciador= new GerenciadorPibid();
		this.gerenciadorMaterial = new GerenciadorDeMaterial();
		this.gerenciadorEscola= new GerenciadorDeEscola(); 
		this.gerenciadorGrupo= new GerenciadorDeGrupo();
		this.gerenciadorTarefas= new GerenciadorDeTerefas();
	}
	
	//PARTE DE CADASTROS
	public void cadastrarAluno(Aluno aluno){
		this.gerenciador.cadastraAluno(aluno);
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
	
	public void cadastrarMaterial(Material m){
		this.gerenciadorMaterial.cadastrarMaterial(m);
	}
	
	public void cadastrarEscola(Escola e) throws EscolaExistenteException{
		this.gerenciadorEscola.cadastrarEscola(e);
	}

	//PARTE DE ADICIONAR
	public void adicionarTarefaAoGrupo(Tarefa t, Grupo g){
		this.gerenciador.adicionarTarefaAoGrupo(t, g);
	}
	
	public void adicionarQuantidadeDeMaterial(String codigo, int quantidade){
		this.gerenciadorMaterial.adicionarQuantidadeDeMaterial(codigo, quantidade);
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
	
	public List <Material> getListaDeMateriais (){
		return this.gerenciadorMaterial.getListaDeMateriais();
	}
	
	public Material getMaterial (String codigo){
		return this.gerenciadorMaterial.getMaterial(codigo);
	}
	public List<Escola> getEscola (){
		return this.gerenciadorEscola.getEscolas();
	}
	// PARTE DE PESQUISAS
	public Grupo pesquisarGrupo(String codigo){
		return this.gerenciadorGrupo.pesquisarGrupo(codigo);
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
	
	public Material pesquisarMaterial (String codMaterial){
		return this.gerenciadorMaterial.pesquisarMaterial(codMaterial);
	}
	
	public Material pesquisarMaterialPeloNome (String n){
		return this.gerenciadorMaterial.pesquisarMaterialPeloNome(n);
	}
	
	public List<Material> pesquisarMaterialEmFalta(){
		return this.gerenciadorMaterial.pesquisarMaterialEmFalta();
	}
	
	public Escola pesquisarEscolaPeloNome (String n){
		return this.gerenciadorEscola.pesquisarEscolaPeloNome(n);
	}
	
	public Escola pesquisarEscolaPeloCod(String cod){
		return this.gerenciadorEscola.pesquisarEscolaPeloCod(cod);
	}

	// PARTE DE REMO��ES
	public void removerAlunoPelaMatricula(String matricula){
		this.gerenciador.removerAlunoPelaMatricula(matricula);
	}
	
	public void removerCoordenadorPeloSiape(String siape){
		this.gerenciador.removerCoordenadorPeloSiape(siape);
	}
	public void removerTarefa(String cod) {
		this.gerenciadorTarefas.removerTarefa(cod);
	}
	public void removerTarefaDoGrupo(Tarefa t, Grupo g){
		this.gerenciadorTarefas.removerTarefaDoGrupo(t,g);
	}
	
	public void removerMaterial(String codMaterial){
		this.gerenciadorMaterial.removerMaterial(codMaterial);
	}
	
	public void removerQuantidadeDeMaterial (String codigo, int quant){
		this.gerenciadorMaterial.removerQuantidadeDeMaterial(codigo, quant);
	} 
	public void removerEscolaPeloCod (String cod){
		this.gerenciadorEscola.removerEscolaPeloCod(cod);
	}
	
	
	
	
	

}
 