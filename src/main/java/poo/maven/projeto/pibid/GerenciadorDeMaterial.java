package poo.maven.projeto.pibid;
import java.util.LinkedList;
import java.util.List;

public class GerenciadorDeMaterial {
	private List<Material> materiais = new LinkedList<Material>();

	public void cadastrarMaterial(Material material){
		this.materiais.add(material);
	}

	public List <Material> getListaDeMateriais(){
		return this.materiais;
	}

	public void removerMaterial (String codMaterial){
		for(Material m: this.materiais){
			if(m.getCodMaterial().equals(codMaterial)){
				this.materiais.remove(m);
				return;
			}
		}
		throw new MaterialInexistenteException("Material Inexistente!");
	}

	public Material pesquisarMaterial(String codigoMaterial){
		for(Material m: this.materiais){
			if(m.getCodMaterial().equals(codigoMaterial)){
				return m;
			}
		}
		throw new MaterialInexistenteException ("Material Inexistente!");		
	}

	public Material getMaterial(String cod){
		for (Material m: this.materiais){
			if(m.getCodMaterial().equals(cod)){
				return m;
			}
		}
		throw new MaterialInexistenteException ("Material Inexistente!");
	}
}