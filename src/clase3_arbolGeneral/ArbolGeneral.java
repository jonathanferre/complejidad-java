package clase3_arbolGeneral;

import java.util.ArrayList;

import clase1_Listas.Cola;
import clase1_Listas.ListaConArreglo;
import clase1_Listas.Recorredor;

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
	
	
    public int altura(){
        int value = 0;
        Cola colaAux = new Cola(new ListaConArreglo());
        Cola cola = new Cola(new ListaConArreglo());
        cola.poner(this.raiz.getHijos());
        while(!cola.esVacia()){
            Object aux = cola.sacar();
            NodoGeneral arbol = (NodoGeneral) cola.sacar(); //saca arboles generales
            Recorredor rec_hijos = arbol.getHijos().recorredor();
            rec_hijos.comenzar();
            while (!rec_hijos.fin()) {
                colaAux.poner(rec_hijos.elemento());
                value += 1;
                rec_hijos.proximo();
            }
        }
        return value;
    }

	

}

/*
 * def porNiveles(self):
	cola=estructuras.Cola()
	cola.poner(self)
	while not cola.esVacia():
		arbol = cola.sacar()
		print arbol.getDatoRaiz()
		rec_hijos = arbol.getHijos().recorredor()
		rec_hijos.comenzar()
		while not rec_hijos.fin():
			cola.poner(rec_hijos.elemento())
			rec_hijos.proximo()


//Preorden: Se procesa primero la raíz y luego los hijos
def preorden(self):
		print self.__getRaiz().getDato()
		rec_hijos = self.getHijos().recorredor()
		rec_hijos.comenzar()
		while not rec_hijos.fin():
			rec_hijos.elemento().preorden()
			rec_hijos.proximo()*/


/*public void altura2()){
	if (this.hijos == null){
		return 0
	}else{
		int h2 = 0;
		for (arbolgeneral h:this.hijos;) {
			h1 = Altura(h);
			if (h1 > h2){
				h2 = h1;
			}
		}
		return h2+1;
	}
	
}*/
