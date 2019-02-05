package bdoo;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
public class Paises {
	private int id;
	private String nombrepais;
	
	public Paises() {}

	public Paises(int id, String nombrepais) {
		super();
		this.id = id;
		this.nombrepais = nombrepais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombrepais() {
		return nombrepais;
	}

	public void setNombrepais(String nombrepais) {
		this.nombrepais = nombrepais;
	}

	@Override
	public String toString() {
		return nombrepais ;
	}


}
