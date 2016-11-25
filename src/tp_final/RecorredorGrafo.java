package tp_final;

import java.util.ArrayList;

public class RecorredorGrafo {
			
	public void buscar_VelocidadMax (Ciudad origen, Ciudad destino, ArrayList<Ciudad> camino, ArrayList<Ciudad> mejorCamino, double vma,double vmm){
		camino.add(origen);
		if (origen.equals(destino)){
			if (vma > vmm){
				mejorCamino.clear();
				for (Ciudad ciudad : camino) {
					mejorCamino.add(ciudad);
				}
			}
			vmm=vma;
		}else{
			for (Ruta r: origen.getAdyacentes()){
				if (!camino.get(0).getDatoCiudad().getNombreCiudad().equals(r.getDestino().getDatoCiudad().getNombreCiudad())){
					buscar_VelocidadMax(r.getDestino(), destino, camino, mejorCamino, Math.max(vma, r.getCostos().getVelocidadMaxCiudades()),vmm);
				}
			}
		}
		camino.remove(origen);
		System.out.println("La velocidad maxima que hay en las rutas entre "+ origen.getDatoCiudad().getNombreCiudad()+" y "+destino.getDatoCiudad().getNombreCiudad()+" es " +vmm);
	}
	
	public void buscar_DistanciaMin (Ciudad origen, Ciudad destino, ArrayList<Ciudad> camino, ArrayList<Ciudad> mejorCamino , double DistanciaMin, double DistanciaMinMejor ){
		camino.add(origen);
		if (origen.equals(destino)){
			if (DistanciaMin < DistanciaMinMejor){
				mejorCamino.clear();
				for (Ciudad ciudad : camino){
					mejorCamino.add(ciudad);
				}
			}
		}else{
			for (Ruta r: origen.getAdyacentes()){
				if (!camino.contains(r)){
					buscar_VelocidadMax(r.getDestino(), destino, camino, mejorCamino, Math.min(DistanciaMin, r.getCostos().getDistanciaRuta()), DistanciaMinMejor);
				}
			}
		}
		 System.out.println(mejorCamino);
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
