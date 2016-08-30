package clase1_Listas;

import java.util.Stack;

public class Pila {
	
	private Stack stack = new Stack();
	//private ListaConArreglo datos = new ListaConArreglo();
	
	public void poner(Object elem){
		this.stack.push(elem);
		System.out.println(elem);
	}
	
	public Object sacar(){
		return stack.pop();
	}
	
	public Object tope(){
		return stack.peek();
	}
	
	public boolean esVacia(){
		return stack.isEmpty();
	}
}
