package poo.maven.projeto.pibid;
import java.util.LinkedList;
import java.util.List;

public class GerenciadorDeEscola {
	
	private List<Escola> escolas= new LinkedList<Escola>();
	
	public List<Escola> getEscolas(){
		return this.escolas;
	}
	
	public void cadastrarEscola(Escola escola) {
		boolean existe=false;
		for (Escola e: this.escolas){
			if(e.getCodDoMec().equals(escola.getCodDoMec())){
				existe=true;
				break;
			}
		}
		if(existe==false){
			this.escolas.add(escola);
		}
		else{
			throw new EscolaExistenteException ("Escola Existente!");
		}
	}
	
	public void removerEscolaPeloCod(String cod){
		boolean removeu=false;
		for (Escola e: this.escolas){
			if(e.getCodDoMec().equals(cod)){
				removeu=true;
				escolas.remove(e);
				break;
			}
		}
		if(removeu==false){
			throw new EscolaInexistenteException ("Escola Inexistente!");
		}
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
