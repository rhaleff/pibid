package poo.maven.projeto.pibid;
public class EscolaInexistenteException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public EscolaInexistenteException(String msg){
		super(msg);
	}

}
