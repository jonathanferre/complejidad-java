package tp_final;


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
	public void conectar(Ciudad origen, Ciudad destino, Costos costos){
		//GetDestino tiene datoCiudad=Null;
	
		//crear una nueva ruta paśandole como parámetro Destino y Costo
		origen.getAdyacentes().add(new Ruta(destino,costos));
	}

}
