package bdoo;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
class Jugadores { //Clase Jugadores
private String nombre;
private String deporte;
private String ciudad;
private int edad;
private Paises pais;
public Jugadores() {}
public Jugadores(String nombre, String deporte,Paises pais,
 String ciudad, int edad) {
 this.nombre = nombre;
 this.deporte = deporte;
 this.pais = pais;
 this.ciudad = ciudad;
 this.edad = edad;
 
}

public void setNombre(String nombre) {this.nombre = nombre;}
public String getNombre() {return nombre;}
public void setDeporte(String deporte) {this.deporte = deporte;}
public String getDeporte() {return deporte;}
public void setCiudad(String ciudad) {this.ciudad = ciudad;}
public String getCiudad () {return ciudad;}
public void setEdad(int edad) {this.edad = edad;}
public int getEdad() {return edad;}
public Paises getPais() {
	return pais;
}
public void setPais(Paises pais) {
	this.pais = pais;
}

}
