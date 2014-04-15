package poo.maven.projeto.pibid;
public class Material {

	private String nome;
	private String codMaterial;
	private int quantidade;

	public Material (String nome, String codMaterial, int quantidade){
		this.nome=nome;
		this.codMaterial=codMaterial;
		this.quantidade=quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodMaterial() {
		return codMaterial;
	}

	public void setCodMaterial(String codMaterial) {
		this.codMaterial = codMaterial;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}



}