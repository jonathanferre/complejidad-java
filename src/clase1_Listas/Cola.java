package clase1_Listas;

public class Cola {
	
	ListaConArreglo lista;
	
	public Cola(ListaConArreglo lista){
		this.lista = lista;
	}
	
	public void poner(Object elem){
		lista.agregar(elem,lista.getTamanio());
	}
	
	public Object sacar(){
		Object elem = lista.elemento(0);
		lista.eliminar(0);
		return elem;
	}
	
	public Object tope(){
		return lista.elemento(0);
	}
	
	public Boolean esVacia(){
		return lista.esVacia();
	}
}
