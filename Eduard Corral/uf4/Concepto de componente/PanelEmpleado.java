package javabean;
import java.beans.*;


import java.io.Serializable;


@SuppressWarnings("serial")
public class PanelEmpleado implements Serializable, PropertyChangeListener  {

	private String[] listaDeCargos = {"Junior","Semisenior","Analista","CEO"};
	int limiteVariacionSueldo;
	Double porcentaje;
	PanelEmpleado(){
		this.setLimiteVariacionSueldo(10);
	}

	PanelEmpleado(int valor){
		this.setLimiteVariacionSueldo(valor);
	}
    
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if(event.getPropertyName().equals("cargo")) {

					switch ( event.getNewValue().toString()) {
					case "Junior":
						break;
					case "Semisenior":
						break;
					case "Analista":
						break;
					case "CEO":
						break;
					default:
					//	throw new ExcepcionCargo("El cargo no se encuestra en la lista, cargo no modificado"); Al final no implemente esta excepción dado que requeria de un try catch
						throw new IllegalArgumentException();
						
					
				}



		}
		if(event.getPropertyName().equals("sueldo")) {
			double old= Double.parseDouble(event.getOldValue().toString());
			double nuevo=Double.parseDouble(event.getNewValue().toString());
			System.out.println(old);
			//porcentaje=(antiguo-nuevo/antiguo)*100
			
					/**(
							(
									(
											(Double)event.getOldValue() - (Double)event.getNewValue()
									) 
										/
									(Double)event.getOldValue()
							)
							*100
					);**/
			
			 if(porcentaje>=(double)10 && porcentaje<=(double)50) {
				 
			 }else {
					throw new IllegalArgumentException();
			 }
		}


	}







	public String[] getListaDeCargos() {
		return listaDeCargos;
	}
	public void setListaDeCargos(String[] listaDeCargos) {
		this.listaDeCargos = listaDeCargos;
	}
	public int getLimiteVariacionSueldo() {
		return limiteVariacionSueldo;
	}
	public void setLimiteVariacionSueldo(int limiteVariacionSueldo) {
		if(limiteVariacionSueldo>= 10 && limiteVariacionSueldo <= 50) {
			this.limiteVariacionSueldo = limiteVariacionSueldo;
		}
	}


}
