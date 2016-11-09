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
		listaDeCiudades.agregar(c, listaDeCiudades.getTamanio());
	}
	
	//se elimina los datos de la ruta y se agrega ruta como parámetro (mas origen y destino)
	public void conectar(Ciudad origen, Ciudad destino, Ruta ruta){
		origen.getAdyacentes().add(ruta);
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
