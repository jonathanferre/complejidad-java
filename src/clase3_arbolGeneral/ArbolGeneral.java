package clase3_arbolGeneral;

import clase1_Listas.ListaConArreglo;

public class ArbolGeneral {
	
	private NodoGeneral raiz = new NodoGeneral();

	
	private NodoGeneral getRaiz() {
		return raiz;
	}

	private void setRaiz(NodoGeneral raiz) {
		this.raiz = raiz;
	}
	
	private Object getDatoRaiz(){
		return raiz.getDato();
	}
	
	private ListaConArreglo gethijos(){
		return raiz.getHijos();
	}
	
	private void agregarHijo(ArbolGeneral unHijo){
		NodoGeneral raiz_hijo = unHijo.getRaiz();
		this.raiz.getHijos().agregar(raiz_hijo, this.raiz.getHijos().getTamanio() +1);
		System.out.println("Se ha agregado un hijo al arbol general");
	}
	
	//private void eliminarHijo(ArbolGeneral unHijo){}
	
	
	
	
	

}
