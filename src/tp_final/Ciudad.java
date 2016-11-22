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
	
	public void printNombreCiudad(){
		System.out.println(datoCiudad.getNombreCiudad());
	}
	
	public void printAlturaCiudad(){
		System.out.println(datoCiudad.getAltura());
	}
	
	public void printDistanciaCiudad(){
		System.out.println(datoCiudad.getDistanciaCiudad());
	}
	
	public void printVelocidadMediaCiudad(){
		System.out.println(datoCiudad.getVelocidadMedia());
	}


	
}
