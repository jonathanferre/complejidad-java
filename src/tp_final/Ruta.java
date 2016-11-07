package tp_final;

public class Ruta {
	
	private Ciudad destino;
	private int distanciaRuta;
	private float velocidadMaxCiudades;
	private int pesoMaximo;
	
	//
	public Ciudad getDestino() {
		return destino;
	}
	public void setDestino(Ciudad destino) {
		this.destino = destino;
	}

	public int getDistancia() {
		return distanciaRuta;
	}
	public void setDistancia(int distancia) {
		this.distanciaRuta = distancia;
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
	
	public Ruta(){
	}
	
	
}
