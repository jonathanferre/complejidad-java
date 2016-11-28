package tp_final;

import java.util.ArrayList;

public class RecorredorGrafo {
	
	public void buscar_VelocidadMax (Ciudad origen, Ciudad destino, double camino, double mejorCamino,ArrayList<Ciudad> visitados){
		visitados.add(origen);
		if (origen.equals(destino)){
			if (camino> mejorCamino){
				mejorCamino= camino;
			}
		}
		else{
			for (int i = 0; i < origen.getAdyacentes().size(); i++) {
				Ruta ruta = origen.getAdyacentes().get(i);
				if (!visitados.contains(ruta.getDestino())){
					buscar_VelocidadMax(ruta.getDestino(), destino,Math.max(camino, ruta.getCostos().getVelocidadMaxCiudades()),mejorCamino,visitados );
				}
			}
		}	
		
			
	//if (mejorCamino!= 0.0){
	System.out.println("Velocidad M\u00e1xima que alcanza el veh\u00edculo es: "+Math.rint(mejorCamino*1000)/1000);
	System.exit(1);
	//}
	}
	
	public void buscar_DistanciaMin(Ciudad origen,Ciudad destino, ArrayList<Ciudad> caminoList, ArrayList<Ciudad> visitado, int distancia, int mejorDis, ArrayList<Ciudad> mejorCaminoLis ){
		caminoList.add(origen);
		visitado.add(origen);
		distancia=distancia+origen.getDatoCiudad().getDistanciaCiudad();
		if (origen.equals(destino)){
			if (distancia<=mejorDis){
				mejorDis=distancia;
				for (Ciudad ciudad : caminoList) {
					mejorCaminoLis.add(ciudad);
				}
			}
		}
		else{
			for (int i = 0; i < origen.getAdyacentes().size(); i++) {
				Ruta ruta = origen.getAdyacentes().get(i);
				if (!visitado.contains(ruta.getDestino())){
					distancia= distancia+ruta.getCostos().getDistanciaRuta();
					buscar_DistanciaMin(ruta.getDestino(), destino, caminoList, visitado, distancia, mejorDis,mejorCaminoLis);
				}
				
			}
		}
		caminoList.remove(origen);
		visitado.remove(origen);
		distancia=distancia-origen.getDatoCiudad().getDistanciaCiudad();
		
		System.out.println( mejorCaminoLis +" esto tiene una distancia de: "+ mejorDis + "m");
		System.exit(1);
		
		
	} 
	
	public void buscar_VariacionAltura (Ciudad origen){
  		int altura = origen.getDatoCiudad().getAltura();
 		int variacionAltura = 0;
  		for (int i = 0; i < origen.getAdyacentes().size(); i++) {
  			int alturaVar=  origen.getAdyacentes().get(i).getDestino().getDatoCiudad().getAltura();
  			variacionAltura=altura-alturaVar;
 			System.out.println("La variacion de altura que hay entre la ciudad "+origen.getDatoCiudad().getNombreCiudad()+" y la ciudad "+ origen.getAdyacentes().get(i).getDestino().getDatoCiudad().getNombreCiudad()+" es: "+ variacionAltura);
  		}
 
	}
 
}
