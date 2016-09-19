package clase3_arbolGeneral;

public class MainArbol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArbolGeneral arbolgeneral = new ArbolGeneral(new NodoGeneral("Nodo 1"));
		ArbolGeneral arbol2 = new ArbolGeneral(new NodoGeneral("Nodo 2"));
		ArbolGeneral arbol3 = new ArbolGeneral(new NodoGeneral("Nodo 3"));
		ArbolGeneral arbol4 = new ArbolGeneral(new NodoGeneral("Nodo 4"));
		ArbolGeneral arbol5 = new ArbolGeneral(new NodoGeneral("Nodo 5"));
		ArbolGeneral arbol6 = new ArbolGeneral(new NodoGeneral("Nodo hijo"));

		arbolgeneral.agregarHijo(arbol2);
		arbolgeneral.agregarHijo(arbol3);
		//arbolgeneral.agregarHijo(arbol4);
		//arbolgeneral.agregarHijo(arbol5);
		arbol2.agregarHijo(arbol6);
		
		System.out.println(arbolgeneral.getDatoRaiz());
		System.out.println(arbolgeneral.gethijos().getTamanio());
		System.out.println(arbol2.altura());
	}

}
