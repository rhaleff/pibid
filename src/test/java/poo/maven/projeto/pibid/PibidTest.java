package poo.maven.projeto.pibid;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class PibidTest {
	Pibid pibid;
	
	@Before
	public void Inicializar() {
		this.pibid = new Pibid();
	}
	
	@Test
	public void CadastrarCoordenadorTest(){
		Coordenador coord = new Coordenador("Ana Liz","12345678");
		pibid.cadastraCoordenador(coord);
		List <Coordenador> list = pibid.getListaDeCoordenadoresCriados();
		assertEquals(1,list.size());
		assertEquals(coord, list.get(0));
	}
	
	@Test(expected = CoordenadorExistenteException.class)
	public void cadastroCoordenadorDuplicadoTest() {
		Coordenador coord = new Coordenador("Ana Liz","12345678");
		Coordenador coord2 = new Coordenador("Ana Liz","12345678");
		pibid.cadastraCoordenador(coord);
		pibid.cadastraCoordenador(coord2);
	}
		
	@Test
	public void cadastraAlunoTest(){
		Aluno aluno= new Aluno("Luana Costa","81211021");
		pibid.cadastrarAluno(aluno);
		List<Aluno> list = pibid.getListaDeAlunosCriados();
		assertEquals(1,list.size());
		assertEquals(aluno,list.get(0));
	}
	
	@Test(expected = AlunoExistenteException.class)
	public void cadastrarAlunoDuplicadoTest(){
		Aluno aluno1= new Aluno("Luana Tainá","81211021");
		Aluno aluno2= new Aluno("Luana Tainá","81211021");
		pibid.cadastrarAluno(aluno1);
		pibid.cadastrarAluno(aluno2);
	}
	
	@Test(expected = AlunoExistenteException.class)
	public void cadastraAlunoComMesmaMatriculaTest(){
		Aluno aluno1= new Aluno("Luana Tainá","81211369");
		Aluno aluno2= new Aluno("Marina Oliveira","81211369");
		pibid.cadastrarAluno(aluno1);
		pibid.cadastrarAluno(aluno2);
	}
	
	@Test
	public void cadastrarTarefasTest(){
		Tarefa tarefa=new Tarefa("Ministrar aula de HTML","01");
		Grupo g = new Grupo(tarefa,"01");
		pibid.cadastrarTarefa(tarefa);
		pibid.cadastrarGrupo(g);
		List<Tarefa> lista=pibid.getListaDeTarefas();
		assertEquals(1,lista.size());
		assertEquals(tarefa,lista.get(0));
	}
	
	@Test(expected = Exception.class)
	public void cadastraUmAlunoQueJaParticipeDoGrupoTest(){
		Aluno a = new Aluno("Rodrigo", "66557788");
		pibid.cadastrarAluno(a);
		Aluno a1 = pibid.pesquisaAluno("66557788");
		Tarefa t = new Tarefa("Planejar aula","32");
		Grupo g = new Grupo(t,"123");
		pibid.cadastrarParticipante(a1,g);
		pibid.cadastrarParticipante(a1,g);
	}
	
	@Test
	public void cadastrarGrupoTest(){
		Tarefa tarefa = new Tarefa("Ministrar Aula de Python","79");
		pibid.cadastrarTarefa(tarefa);
		Grupo grupo = new Grupo(tarefa,"012");
		pibid.cadastrarGrupo(grupo);
		assertEquals(grupo,pibid.pesquisarGrupo("012"));
	}
	
	@Test(expected = GrupoJaexisteException.class)
	public void cadastraGrupoComMesmoCodigoTest(){
		Tarefa tarefa = new Tarefa("Produzir materiais","123");
		pibid.cadastrarTarefa(tarefa);
		Grupo grupo = new Grupo(tarefa,"007");
		pibid.cadastrarGrupo(grupo);
		Tarefa tarefa2 = new Tarefa("Elaborar testes no jogo de raciocio logico","098");
		pibid.cadastrarTarefa(tarefa2);
		Grupo grupo2 = new Grupo(tarefa,"007");
		pibid.cadastrarGrupo(grupo2);
	}
	
	@Test
	public void adicionarTarefasAoGrupoTest(){
		Tarefa t = new Tarefa("Ministrar curso de Python","345");
		pibid.cadastrarTarefa(t);
		Grupo g = new Grupo(t,"12398473");
		pibid.cadastrarGrupo(g);
		pibid.adicionarTarefaAoGrupo(t,g);
		List<Tarefa> tarefas = pibid.getListaDeTarefas();
		assertEquals(1,tarefas.size());		
	}
	
	@Test
	public void pesquisaAlunoTest(){
		Aluno a = new Aluno("Luana","81211067");
		pibid.cadastrarAluno(a);
		assertEquals(a,pibid.pesquisaAluno("81211067"));	
	}
	
	@Test(expected = AlunoInexistenteException.class)
	public void pesquisarAlunoInexistenteTest(){
		Aluno a = new Aluno("Rhaleff","81211133");
		pibid.cadastrarAluno(a);
		pibid.pesquisaAluno("1312312");
	}
	
	@Test(expected = GrupoJaexisteException.class)
	public void pesquisarGrupoInexistenteTest(){
		Tarefa t = new Tarefa("Ministrar curso de HTML","456");
		Grupo g = new Grupo(t,"123");
		pibid.cadastrarGrupo(g);
		pibid.pesquisarGrupo("321");
	}
	
	@Test
	public void pesquisarGrupoPeloCodigoTest(){
		Tarefa t = new Tarefa("Ministrar curso de HTML","456");
		Grupo g = new Grupo(t,"123");
		pibid.cadastrarGrupo(g);
		assertEquals(g,pibid.pesquisarGrupo("123"));
	}
		
	@Test
	public void pesquisarCoordenadorTest(){
		Coordenador c = new Coordenador("Ana Liz", "1241243");
		pibid.cadastraCoordenador(c);
		assertEquals(c, pibid.pesquisarCoordenador("1241243"));
	}

	@Test
	public void pesquisarCoordenadorPeloNomeTest(){
		Coordenador c = new Coordenador("Ana Liz", "1241243");
		pibid.cadastraCoordenador(c);
		assertEquals(c,pibid.pesquisarCoordenadorPeloNome("Ana Liz"));
		
	}
	
	@Test(expected = CoordenadorInexistenteException.class)
	public void pesquisarCoordenadorInexistenteTest(){
		Coordenador c = new Coordenador("Flavia Veloso", "8124122");
		pibid.cadastraCoordenador(c);
		pibid.pesquisarCoordenador("9077");
	}
	
	@Test
	public void pesquisarTarefaTest(){
		Tarefa tarefa=new Tarefa("Ministrar aula de HTML","765");
		pibid.cadastrarTarefa(tarefa);
		Tarefa retorno=pibid.pesquisarTarefa("765");
		assertEquals(tarefa,retorno);	
	}
	
	@Test
	public void pesquisarTarefaInexistenteTest() {
		Tarefa t = new Tarefa("Elaborar roteiros","9234");
		pibid.cadastrarTarefa(t);
		Tarefa tarefa = pibid.pesquisarTarefa("876");
		assertNull(tarefa);
	}
	
	@Test
	public void verificarTamanhoDaListadeCoordenadoresTest(){
		Coordenador coord = new Coordenador("Ana Liz","12345678");
		Coordenador coord2 = new Coordenador("Flávia veloso","781454653");
		Coordenador coord3 = new Coordenador("Ana Cristina","099877533");
		Coordenador coord4 = new Coordenador("Maria Helena","85423923791");
		pibid.cadastraCoordenador(coord);
		pibid.cadastraCoordenador(coord2);
		pibid.cadastraCoordenador(coord3);
		pibid.cadastraCoordenador(coord4);
		List<Coordenador> listaCoord=pibid.getListaDeCoordenadoresCriados();
		assertEquals(4,listaCoord.size());	
	}
	
	@Test
	public void verificarTamanhoDaListadeTarefasTest(){
		Tarefa t= new Tarefa("Pesquisar sobre HTML","01");
		pibid.cadastrarTarefa(t);
		Tarefa t2= new Tarefa("Aulas de HTML","02");
		pibid.cadastrarTarefa(t2);
		Tarefa t3= new Tarefa("Entregar relat�rios sobre a aula de HTML","03");
		pibid.cadastrarTarefa(t3);
		pibid.removerTarefa("03");
		List<Tarefa> listTarefa = pibid.getListaDeTarefas();
		assertEquals(2,listTarefa.size());
	}
	
	@Test
	public void verificarTamanhoDaListadeGruposTest(){
		Tarefa t= new Tarefa("Pesquisar sobre HTML","012");
		pibid.cadastrarTarefa(t);
		Grupo grupo = new Grupo(t,"1");
		pibid.cadastrarGrupo(grupo);
		Tarefa t2= new Tarefa("Aulas de HTML","345");
		pibid.cadastrarTarefa(t2);
		Grupo grupo2 = new Grupo(t2,"2");
		pibid.cadastrarGrupo(grupo2);
		Tarefa t3= new Tarefa("Entregar relat�rios sobre HTML","098");
		pibid.cadastrarTarefa(t3);
		Grupo grupo3 = new Grupo(t3,"3");
		pibid.cadastrarGrupo(grupo3);
		List<Grupo> listGrupo = pibid.getListaDeGrupo();
		assertEquals(3,listGrupo.size());	
	}
	
	@Test
	public void verificarTamanhoDaListadeAlunosTest(){
		Aluno a= new Aluno ("Luana","12132456");
		Aluno b= new Aluno("Rhaleff","098876786");
		pibid.cadastrarAluno(a);
		pibid.cadastrarAluno(b);
		List<Aluno> listaAluno=pibid.getListaDeAlunosCriados();
		assertEquals(2,listaAluno.size());	
	}
	
	@Test
	public void removerTarefaDoGrupoTest(){
		Tarefa t = new Tarefa("Ministrar curso de Python","478");
		pibid.cadastrarTarefa(t);
		Grupo g = new Grupo("12398473");
		pibid.cadastrarGrupo(g);
		Tarefa t1 = pibid.pesquisarTarefa("478");
		Grupo g1 = pibid.pesquisarGrupo("12398473");
		pibid.adicionarTarefaAoGrupo(t1, g1);
		pibid.removerTarefaDoGrupo(t1, g1);
		List<Tarefa> tarefas = pibid.getListaDeTarefasCadastradasEmUmGrupo(g);
		assertEquals(0, tarefas.size());
	}
	
	@Test
	public void removerAlunoPelaMatriculaTest(){
		Aluno a= new Aluno("Luana","81211021");
		pibid.cadastrarAluno(a);
		pibid.removerAlunoPelaMatricula("81211021");
		List<Aluno> alunos = pibid.getListaDeAlunosCriados();
		assertEquals(0,alunos.size());	
	}
	
	@Test
	public void removerAlunoPelaMatriculaSegundoTest(){
		Aluno a= new Aluno("Luana","813521");
		Aluno a2= new Aluno("Rhaleff","8981154");
		Aluno a3= new Aluno("Marina","083856546");
		Aluno a4= new Aluno("Deyvison","71453346");
		Aluno a5= new Aluno("Elze","3275456");
		Aluno a6= new Aluno("Rivan","00824625");
		pibid.cadastrarAluno(a);
		pibid.cadastrarAluno(a2);
		pibid.cadastrarAluno(a3);
		pibid.cadastrarAluno(a4);
		pibid.cadastrarAluno(a5);
		pibid.cadastrarAluno(a6);
		pibid.removerAlunoPelaMatricula(a5.getMatricula());
		pibid.removerAlunoPelaMatricula(a3.getMatricula());
		List<Aluno> listaAlunos = pibid.getListaDeAlunosCriados();
		assertEquals(4,listaAlunos.size());
		assertEquals(a,listaAlunos.get(0));
		assertEquals(a2, listaAlunos.get(1));
		assertEquals(a4, listaAlunos.get(2));
		assertEquals(a6, listaAlunos.get(3));
	}
	
	@Test(expected = AlunoInexistenteException.class)
	public void removerAlunoInexistenteTest(){
		pibid.removerAlunoPelaMatricula("123456567");
	}
	
	@Test
	public void removerCoordenadorPeloSiapeTest(){
		Coordenador c= new Coordenador("Ana Liz","12345678");
		pibid.cadastraCoordenador(c);
		pibid.removerCoordenadorPeloSiape("12345678");
		List<Coordenador> coord = pibid.getListaDeCoordenadoresCriados();
		assertEquals(0,coord.size());	
	}
	
	@Test(expected = CoordenadorInexistenteException.class)
	public void removerCoordenadorInexistenteTest(){
		pibid.removerCoordenadorPeloSiape("81241432");
	}
	
	

	@Test
	public void cadatraEscolaTest(){
		Escola e= new Escola("E.E.E.F.M. Luis Gonzaga Burity","Rio Tinto","01235");
		pibid.cadastrarEscola(e);
		List <Escola> escolas = pibid.getEscola();
		assertEquals(1,escolas.size());
		assertEquals(e, escolas.get(0));
	}
	
	@Test(expected = EscolaExistenteException.class)
	public void cadastrarEscolaDuplicadaTest(){
		Escola e= new Escola("E.E.E.F.M. Luis Gonzaga Burity","Rio Tinto","01235");
		Escola e2= new Escola("E.E.E.F.M. Luis Gonzaga Burity","Rio Tinto","01235");
		pibid.cadastrarEscola(e);
		pibid.cadastrarEscola(e2);
	}
	
	@Test
	public void removerEscolaPeloCodTest(){
		Escola e= new Escola("E.E.E.F.M. Luis Gonzaga Burity","Rio Tinto","01235");
		pibid.cadastrarEscola(e);
		pibid.removerEscolaPeloCod("01235");
		List <Escola> escolas = pibid.getEscola();
		assertEquals(0,escolas.size());
	}
	
	@Test
	public void pesquisarEscolaPeloNomeTest(){
		Escola e= new Escola("E.E.E.F.M. Luis Gonzaga Burity","Rio Tinto","01235");
		pibid.cadastrarEscola(e);
		assertEquals(e,pibid.pesquisarEscolaPeloNome("E.E.E.F.M. Luis Gonzaga Burity"));
	}
	
	@Test(expected = EscolaInexistenteException.class)
	public void removerEscolaInexistenteTest(){
		pibid.removerEscolaPeloCod("123");
	}
	
	@Test
	public void pesquisarEscolaPeloCodTest(){
		Escola e= new Escola("E.E.E.F.M. Luis Gonzaga Burity","Rio Tinto","01235");
		pibid.cadastrarEscola(e);
		assertEquals(e,pibid.pesquisarEscolaPeloCod("01235"));
	}	
	
	@Test
	public void cadastrarMaterialTest(){
		Material m = new Material ("Canetas","0112",10);
		pibid.cadastrarMaterial(m);
		List <Material> list = pibid.getListaDeMateriais();
		assertEquals(1,list.size());
		assertEquals(m, list.get(0));
	}

	@Test
	public void removerMaterialTest(){
		Material m = new Material ("Canetas","0112",10);
		pibid.cadastrarMaterial(m);
		pibid.removerMaterial("0112");
		List <Material> list = pibid.getListaDeMateriais();
		assertEquals(0,list.size());
	}

	@Test(expected = MaterialInexistenteException.class)
	public void removerMaterialInexistenteTest(){
		pibid.removerMaterial("0123");
	}

	@Test
	public void pesquisarMaterialTest(){
		Material m = new Material ("Borrachas","0012",11);
		pibid.cadastrarMaterial(m);
		Material retorno = pibid.pesquisarMaterial("0012");
		assertEquals(m,retorno);
	}

	@Test(expected = MaterialInexistenteException.class)
	public void pesquisarMaterialInexistenteTest(){
		Material m = new Material ("Cadernos","1212",1);
		pibid.cadastrarMaterial(m);
		pibid.pesquisarMaterial("0102");
	}
}
