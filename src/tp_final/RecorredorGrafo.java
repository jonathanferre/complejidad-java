package tp_final;

import java.util.ArrayList;

public class RecorredorGrafo {
	
	private ArrayList<Ciudad> visitados = new ArrayList<Ciudad>();
	
			
	public void buscar_VelocidadMax (Ciudad origen, Ciudad destino, Ruta camino, Ruta mejorCamino){
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
		System.out.println(mejorCamino);
	}
	
	public void buscar_DistanciaMin (Ciudad origen, Ciudad destino, Ruta camino, Ruta mejorCamino){
		camino.setOrigen(origen);
		visitados.add(origen);
		if (origen.equals(destino)){
			if (camino.getDistancia()<mejorCamino.getDistancia()){
				mejorCamino=camino;
				
			}
		}else{
			for (Ruta r: origen.getAdyacentes()){
				if (!visitados.contains(r)){
					buscar_VelocidadMax(r.getDestino(), destino, camino, mejorCamino);
				}
			}
		}
		 System.out.println(mejorCamino);
	}
	
	
	public int buscar_VariacionAltura (Ciudad origen){
		int altura = origen.getDatoCiudad().getAltura();
		
		for (int i = 0; i < origen.getAdyacentes().size(); i++) {
			int alturaVar=  origen.getAdyacentes().get(i).getDestino().getDatoCiudad().getAltura();
		}
		return altura;
			
		
	}
	
	
	}
 

