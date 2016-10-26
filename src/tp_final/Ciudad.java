package tp_final;

import java.util.ArrayList;

public class Ciudad {
	
	private String nombreCiudad;
	private int altura;
	private int distancia;
	private float velocidadMedia;
	private ArrayList<Object> adyacentes = new ArrayList<Object>();
		
	
	public String getNombreCiudad() {
		return nombreCiudad;
	}


	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}


	public int getAltura() {
		return altura;
	}


	public void setAltura(int altura) {
		this.altura = altura;
	}


	public int getDistancia() {
		return distancia;
	}


	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}


	public float getVelocidadMedia() {
		return velocidadMedia;
	}

	public void setVelocidadMedia(float velocidadMedia) {
		this.velocidadMedia = velocidadMedia;
	}

	public ArrayList<Object> getAdyacentes() {
		return adyacentes;
	}

	public void setAdyacentes(ArrayList<Object> adyacentes) {
		this.adyacentes = adyacentes;
	}

	public Ciudad(String nombreCiudad, int altura, int distancia,
			float velocidadMedia, ArrayList<Object> adyacentes) {
		super();
		this.nombreCiudad = nombreCiudad;
		this.altura = altura;
		this.distancia = distancia;
		this.velocidadMedia = velocidadMedia;
		this.adyacentes = adyacentes;
	}

}
