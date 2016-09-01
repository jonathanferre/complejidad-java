package clase3_arbolGeneral;

import clase1_Listas.ListaConArreglo;

public class NodoGeneral {
	
	private String dato;
	private ListaConArreglo listaHijos = new ListaConArreglo();
	
	public NodoGeneral(String elem) {
		// TODO Auto-generated constructor stub
		this.setDato(elem);
	}

	public String getDato(){
		return this.dato;
	}
	
	public void setDato(String elem){
		this.dato = elem;
	}
	
	public ListaConArreglo getHijos(){
		return this.listaHijos;
	}
	
	public void setHijos(ListaConArreglo hijos){
		this.listaHijos = hijos;
	}
	
	

}
