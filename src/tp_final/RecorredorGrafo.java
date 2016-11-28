package tp_final;

import java.util.ArrayList;

import com.sun.media.jfxmedia.events.VideoTrackSizeListener;

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
	System.out.println(Math.rint(mejorCamino*1000)/1000);
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
	
	
	
/*	public void buscar_DistanciaMin (Ciudad origen, Ciudad destino, int caminoDis, int mejorCaminoDis, ArrayList<Ciudad> visitados,ArrayList<Ciudad> caminoMejor){
		visitados.add(origen);
		if(caminoMejor.size()==0){
			caminoMejor.add(origen);
		}
		if (origen.equals(destino)){
			System.out.println(mejorCaminoDis);
		}else{
			ArrayList<Object> mejorDistancia = new ArrayList<>();
			mejorDistancia.add(origen.getAdyacentes().get(0).getDestino());
			mejorDistancia.add(origen.getDatoCiudad().getDistanciaCiudad()+ origen.getAdyacentes().get(0).getCostos().getDistanciaRuta());
			for (Ruta ruta : origen.getAdyacentes()){
				caminoDis= caminoDis+ origen.getDatoCiudad().getDistanciaCiudad()+ ruta.getCostos().getDistanciaRuta(); 
				if (caminoDis<(Integer)mejorDistancia.get(1)){
					caminoMejor.add(ruta.getDestino());
					mejorDistancia.set(1, caminoMejor);
					mejorDistancia.set(0, ruta.getDestino());
					buscar_DistanciaMin(ruta.getDestino(), destino, (Integer) mejorDistancia.get(1), mejorCaminoDis, visitados, caminoMejor);
				}else{
					buscar_DistanciaMin((Ciudad)mejorDistancia.get(0), destino, (Integer) mejorDistancia.get(1), mejorCaminoDis, visitados, caminoMejor);
				}
			}
			caminoMejor.add((Ciudad)mejorDistancia.get(0));
			System.out.println(caminoMejor);
		}
	}
	*/
	
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
