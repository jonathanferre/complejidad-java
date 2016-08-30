package clase3_arbolGeneral;

import clase1_Listas.ListaConArreglo;

public class NodoGeneral {
	
	private Object dato;
	private ListaConArreglo listaHijos;
	
	public Object getDato(){
		return this.dato;
	}
	
	public void setDato(Object elem){
		this.dato = elem;
	}
	
	public ListaConArreglo getHijos(){
		return this.listaHijos;
	}
	
	public void setHijos(ListaConArreglo hijos){
		this.listaHijos = hijos;
	}
	
	

}
