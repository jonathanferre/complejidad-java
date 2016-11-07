package tp_final;

import java.util.ArrayList;

public class Ciudad {
	
	private DatosCiudad datoCiudad;
	private int posicion;
	private ArrayList<Ruta> adyacentes = new ArrayList<Ruta>();
	
	
	public DatosCiudad getDatoCiudad() {
		return datoCiudad;
	}
	public void setDatoCiudad(DatosCiudad datoCiudad) {
		this.datoCiudad = datoCiudad;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public ArrayList<Ruta> getAdyacentes() {
		return adyacentes;
	}
	public void setAdyacentes(ArrayList<Ruta> adyacentes) {
		this.adyacentes = adyacentes;
	}
	
	public void mostrar(){
		if (this.getAdyacentes().isEmpty()) {
			System.out.println(this.getDatoCiudad().getNombreCiudad() + "no tiene adyacentes");			
		}else{
			ArrayList<Ciudad> rutasAux = new ArrayList<Ciudad>();
			for(Ruta a: this.getAdyacentes()){
				System.out.println(this.getDatoCiudad().getNombreCiudad() + "<- tiene como adyacente a:" + a.getDestino().getDatoCiudad().getNombreCiudad() + " / distancia =" + a.getPesoMaximo());
				rutasAux.add(a.getDestino());
			}
		}
	}
	

	
}
