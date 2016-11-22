package tp_final;

public class Costos {
	
	private int distanciaRuta;
	private float velocidadMaxCiudades;
	private int pesoMaximo;
	
	public int getDistanciaRuta() {
		return distanciaRuta;
	}
	public void setDistanciaRuta(int distanciaRuta) {
		this.distanciaRuta = distanciaRuta;
	}
	public float getVelocidadMaxCiudades() {
		return velocidadMaxCiudades;
	}
	public void setVelocidadMaxCiudades(float velocidadMaxCiudades) {
		this.velocidadMaxCiudades = velocidadMaxCiudades;
	}
	public int getPesoMaximo() {
		return pesoMaximo;
	}
	public void setPesoMaximo(int pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}
	
	public Costos(int distanciaRuta, float velocidadMaxCiudades, int pesoMaximo) {
		super();
		this.distanciaRuta = distanciaRuta;
		this.velocidadMaxCiudades = velocidadMaxCiudades;
		this.pesoMaximo = pesoMaximo;
	}
	

}
