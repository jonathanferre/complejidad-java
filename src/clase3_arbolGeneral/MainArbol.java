package clase3_arbolGeneral;

public class MainArbol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArbolGeneral arbol = new ArbolGeneral(new NodoGeneral("Nodo 1"));
		ArbolGeneral arbol2 = new ArbolGeneral(new NodoGeneral("Nodo 2"));

		arbol.agregarHijo(arbol2);
		

	}

}
