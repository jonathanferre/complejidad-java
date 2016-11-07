package tp_final;

import java.util.ArrayList;
import java.util.Queue;

import clase1_Listas.ListaConArreglo;

public class Grafo {
	
	private ListaConArreglo listaDeCiudades = new ListaConArreglo();

	public ListaConArreglo getListaDeCiudades() {
		return listaDeCiudades;
	}

	public void setListaDeCiudades(ListaConArreglo listaDeCiudades) {
		this.listaDeCiudades = listaDeCiudades;
	}

	public void agregar_ciudad(Ciudad c){
		listaDeCiudades.agregar(c, listaDeCiudades.getTamanio());;
	}
	
	public void conectar(Ciudad destino, int pesoMaximo, float velocidadMaxCiudades, int distanciaRuta){
		Ruta ruta = new Ruta();
		ruta.setPesoMaximo(pesoMaximo);
		ruta.setDistancia(distanciaRuta);
		ruta.setVelocidadMaxCiudades(velocidadMaxCiudades);
		ruta.setDestino(destino);
		destino.getAdyacentes().add(ruta);
		
	}
	
	//recorrer grafos
	/*public void bfs(Ciudad origen){
		ArrayList<Boolean> visitado = new ArrayList<Boolean>();
		for (int i = 0; i < this.getListaDeCiudades().size(); i++) {
			visitado.add(false);
		}
		return 
	}*/
	
	
/*	private ArrayList<Ciudad> privateBfs(Ciudad origen, Ciudad visitado){
		Queue<> cola = new Queue
	}*/
	
	

}
