package poo.maven.projeto.pibid;
import java.util.LinkedList;
import java.util.List;

public class GerenciadorDeGrupo {

	private List<Grupo> grupos= new LinkedList<Grupo>();
	
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
			throw new GrupoJaexisteException("O grupo já existe,por favor ultilize outro código de identificação!");
		}
	}
	
	public List<Grupo> getListaDeGrupos(){
		return this.grupos;
	}
	
	public Grupo pesquisarGrupo(String codigo){
		for(Grupo i: this.grupos){
			if(i.getCodigoGrupo().equals(codigo)){
				return i;
			}
		}
		throw new GrupoJaexisteException("O grupo já existe,por favor ultilize outro código de identificação!");
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
}
