package tp_final;

import java.util.ArrayList;
import java.util.Queue;

public class Grafo {
	
	private ArrayList<Ciudad> listaDeCiudades = new ArrayList<Ciudad>();
	
	public ArrayList<Ciudad> getListaDeCiudades() {
		return listaDeCiudades;
	}

	public void setListaDeCiudades(ArrayList<Ciudad> listaDeCiudades) {
		this.listaDeCiudades = listaDeCiudades;
	}

	private void agregar_ciudad(Ciudad c){
		listaDeCiudades.add(c);
	}
	
	private void conectar(Ciudad origen, Ciudad destino, int pesoMaximo, float velocidadMaxCiudades, int distanciaRuta){
		Ruta ruta = new Ruta();
		ruta.setPesoMaximo(pesoMaximo);
		ruta.setDistancia(distanciaRuta);
		ruta.setVelocidadMaxCiudades(velocidadMaxCiudades);
		ruta.setDestino(destino);
		origen.getAdyacentes().add(ruta);
	}
	
	//recorrer grafos
	public void bfs(Ciudad origen){
		ArrayList<Boolean> visitado = new ArrayList<Boolean>();
		for (int i = 0; i < this.getListaDeCiudades().size(); i++) {
			visitado.add(false);
		}
		return 
	}
	
	
	private ArrayList<Ciudad> privateBfs(Ciudad origen, Ciudad visitado){
		Queue<> cola = new Queue
	}
	
	

}
