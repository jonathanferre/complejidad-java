package tp_final;

public class Ruta {
	
	private Ciudad destino;
	private Costos costos;
	
	//
	public Ciudad getDestino() {
		return destino;
	}

	public void setDestino(Ciudad destino) {
		this.destino = destino;
	}
	
	public Costos getCostos() {
		return costos;
	}
	public void setCostos(Costos costos) {
		this.costos = costos;
	}
	
	public Ruta(Ciudad destino, Costos costos) {
		super();
		this.destino = destino;
		this.costos = costos;
	}

	public String toString (){
		String o = "Esta ruta tiene destino: "+destino.getDatoCiudad().getNombreCiudad();
		String d="Distancia ruta: "+costos.getDistanciaRuta();
		String vm = "Velocidad máxima: "+costos.getVelocidadMaxCiudades();
		String p = "Peso máximo " +costos.getPesoMaximo();
		return o+" Y sus costos son: "+d+" "+p+" "+vm;
	}
	
	
	
	
}
