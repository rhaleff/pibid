package poo.maven.projeto.pibid;
public class MaterialInexistenteException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public MaterialInexistenteException (String m){
		super (m);
	}

}