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
		boolean removeu = false;
		for(Material m: this.materiais){
			if(m.getCodMaterial().equals(codMaterial)){
				this.materiais.remove(m);
				removeu = true;
				break;
			}
		}
		if(removeu == false){
			throw new MaterialInexistenteException("Material Inexistente!");
		}
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
	
	public void adicionarQuantidadeDeMaterial (String codigo, int quant){
		int quantidade;
		for (Material m: this.materiais){
			if(m.getCodMaterial().equals(codigo)){
				if(quant>=0){
					quantidade=m.getQuantidade()+quant;
					m.setQuantidade(quantidade);
				}
				else{
					throw new QuantidadeNegativaException("Imposs�vel Adicionar! Quantidade Negativa!");
				}
			}
		}
	}
	
	public void removerQuantidadeDeMaterial (String codigo, int quant){
		int quantidade;
		for (Material m: this.materiais){
			if(m.getCodMaterial().equals(codigo)){
				if(m.getQuantidade()>=quant){
					quantidade=m.getQuantidade()-quant;
					m.setQuantidade(quantidade);
				}
				else{
					throw new QuantidadeNegativaException("Imposs�vel Remover!");
				}
			}
		}
	}
	
	public void alterarNomeDeMaterial (Material m,String nome){
		m.setNome(nome);
	}
	
	public Material pesquisarMaterialPeloNome (String nome){
		for(Material m: this.materiais){
				if(m.getNome().equals(nome)){
					return m;
					
				}
			}
			throw new MaterialInexistenteException ("Material Inexistente!");		
		}
	
	public List<Material> pesquisarMaterialEmFalta(){
		List<Material> retorno=new LinkedList<Material>();
		for(Material m: this.materiais){
			if(m.getQuantidade()==0){
				retorno.add(m);
			}
				
		}
		return retorno;
		
	}
	}



