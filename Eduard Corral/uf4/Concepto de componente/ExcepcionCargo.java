package javabean;

public class ExcepcionCargo extends Exception {
	
	private String string;
	
	public ExcepcionCargo(String string) {
		super();
		this.string=string;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
	
		return super.getMessage();
	}

}
