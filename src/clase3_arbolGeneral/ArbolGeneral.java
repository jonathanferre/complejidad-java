package clase3_arbolGeneral;

import clase1_Listas.ListaConArreglo;

public class ArbolGeneral {
	
	private NodoGeneral raiz = null;
	
	//
	public ArbolGeneral(NodoGeneral raiz) {
		this.setRaiz(raiz);
	}

	//Method
	private NodoGeneral getRaiz() {
		return raiz;
	}

	private void setRaiz(NodoGeneral raiz) {
		this.raiz = raiz;
	}
	
	public Object getDatoRaiz(){
		return raiz.getDato();
	}
	
	public ListaConArreglo gethijos(){
		return raiz.getHijos();
	}
	
	public void agregarHijo(ArbolGeneral unHijo){
		NodoGeneral raiz_hijo = unHijo.getRaiz();
		this.raiz.getHijos().agregar(raiz_hijo, this.raiz.getHijos().getTamanio());
		System.out.println("Se ha agregado un hijo al arbol general");
	}
	
	//public void eliminarHijo(ArbolGeneral unHijo){}
	
	
	
	
	

}
