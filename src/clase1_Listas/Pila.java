package clase1_Listas;

public class Pila {
	
	private ListaConArreglo datos;
	
	public Pila (ListaConArreglo lista){
		datos = lista;
	}
	
	public void poner(Object elem){
		if (datos.esVacia()){
			this.datos.agregar(elem,0);
		}
		else{
			this.datos.agregar(elem,this.datos.getTamanio());
		}
		
	}
	public Object sacar(){
		Object elem = this.datos.elemento(this.datos.getTamanio()-1);
		this.datos.eliminar(this.datos.getTamanio()-1);
		return elem;
	}
	
	public Object tope(){
		return  this.datos.elemento(this.datos.getTamanio()-1);
	}
	
	public Boolean esVacia(){
		return this.datos.esVacia();
	}
	
	
}
