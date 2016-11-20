package tp_final;

import java.util.ArrayList;

public class RecorredorGrafo {
	
	private ArrayList<Ciudad> visitados = new ArrayList<Ciudad>();
	
	public void DFS (Grafo gr, Ciudad origen){
		
		/**
		 * el recorrido va--> empieza por el origen
		 * 1-marca origen como visitado
		 * 2-elije un adyacente
		 * 3-marca como visitado ese adyacente
		 * 4-no tiene mas adyacentes?
		 * 5-backTracking
		 * */

		visitados.add(origen);
		System.out.println("Camino profundidad: -->" + origen.getDatoCiudad());
		for (Ruta a: origen.getAdyacentes()){
			//si no esta en la tabla se revisa sino que salte a otro ady
			if (!visitados.contains(a.getDestino())){
				if (a.getDestino()!=null){
					DFS(gr,a.getDestino());
					}
				}
			else{
				System.err.println("Ya pase por "+a.getDestino().getDatoCiudad());
				}
			}
		}
	
	
	public Ruta buscar_VelocidadMax (Ciudad origen, Ciudad destino, Ruta camino, Ruta mejorCamino){
		camino.setOrigen(origen);
		visitados.add(origen);
		if (origen.equals(destino)){
			if (camino.getVelocidadMaxCiudades()>mejorCamino.getVelocidadMaxCiudades()){
				mejorCamino=camino;
				
			}
		}else{
			for (Ruta r: origen.getAdyacentes()){
				if (!visitados.contains(r)){
					buscar_VelocidadMax(r.getDestino(), destino, camino, mejorCamino);
				}
			}
		}
		return mejorCamino;
	}
	
	
	}
 

