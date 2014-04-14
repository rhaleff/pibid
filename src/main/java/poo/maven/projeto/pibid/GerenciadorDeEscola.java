package poo.maven.projeto.pibid;
import java.util.LinkedList;
import java.util.List;

public class GerenciadorDeEscola {
	
	private List<Escola> escolas= new LinkedList<Escola>();
	
	public List<Escola> getEscolas(){
		return this.escolas;
	}
	
	public void cadastrarEscola(Escola escola) {
		for (Escola e: this.escolas){
			if(e.getCodDoMec().equals(escola.getCodDoMec())){
				throw new EscolaExistenteException ("Escola Existente!");
			}
		}
		this.escolas.add(escola);
	}
	
	public void removerEscolaPeloCod(String cod){
		for (Escola e: this.escolas){
			if(e.getCodDoMec().equals(cod)){
				escolas.remove(e);
				return ;
			}
		}
		throw new EscolaInexistenteException ("Escola Inexistente!");
	}
	
	public Escola pesquisarEscolaPeloNome(String nome){
		for(Escola e: this.escolas){
			if(e.getNome().equalsIgnoreCase(nome)){
				return e;
			}
		}
		throw new EscolaInexistenteException ("Escola Inexistente!");
	}
	
	public Escola pesquisarEscolaPeloCod(String cod){
		for(Escola e:this.escolas){
			if(e.getCodDoMec().equalsIgnoreCase(cod)){
				return e;
			}
		}
		throw new EscolaInexistenteException ("Escola Inexistente!");
	}
	
	
	

}
