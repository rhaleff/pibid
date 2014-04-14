package poo.maven.projeto.pibid;

import java.util.LinkedList;
import java.util.List;

public class GerenciadorDeTerefas {

	private List<Tarefa> tarefas= new LinkedList<Tarefa>();
	
	public void cadastraTarefa(Tarefa tarefa) {
		this.tarefas.add(tarefa);	
	}

	public List<Tarefa> getListaDeTarefas() {
		return this.tarefas;
	}
	
	public Tarefa pesquisarTarefa(String codTarefa){
		for (Tarefa x : this.tarefas) {
			if (x.getcodDaTarefa().equals(codTarefa)) {
				return x;
			}
		}
		return null;
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
