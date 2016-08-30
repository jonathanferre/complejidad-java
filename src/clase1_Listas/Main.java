package clase1_Listas;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Lista con Arreglo");
		ListaConArreglo arrayList = new ListaConArreglo();
		
		System.out.println("Agregando elementos");
		arrayList.agregar("Elemento 1", 0);
		arrayList.agregar(10, 1);
		arrayList.agregar("Elemento 3", 2);
		System.out.printf("Tamaño %d",arrayList.getTamanio());
		arrayList.agregar("Elemento 4", 3);
		System.out.printf("Tamaño %d",arrayList.getTamanio());
	
		arrayList.recorredor();
		arrayList.recorredor().comenzar();
		arrayList.recorredor().elemento();
		
		System.out.println("Implementando Stack");
		Pila pila = new Pila();
		pila.poner("Elemento 1");
		pila.sacar();
		pila.esVacia();  //no retorna 
		System.out.println("Implementando Queue");
		Cola cola = new Cola();
		cola.poner("Elemento Queue 1");
		cola.esVacia(); //no retorna 
		
		
	}

}
