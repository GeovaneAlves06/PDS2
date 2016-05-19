package util;

public class MotoNaoEncontradoException extends Exception {
		
	private static final long serialVersionUID = 1L;

	public MotoNaoEncontradoException(Integer codigo) {
		super(codigo.toString());
	}

}
