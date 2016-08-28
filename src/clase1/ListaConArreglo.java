package clase1;
import java.util.ArrayList;


public class ListaConArreglo extends Lista {
	
	private ArrayList<Object> arrayList = new ArrayList<Object>();
	
	@Override
	public Object elemento (int pos){
		if (arrayList.get(pos) == null){
			return null;
			
		}else{
			return this.arrayList.get(pos);
		} 
    }

	@Override
	public void agregar(Object elem, int pos) {
		this.arrayList.add(pos, elem);
		this.tamanio += 1;
		System.out.println(this.arrayList.get(pos));
	}


	@Override
	public void eliminar(int pos) {
		try {
			this.arrayList.remove(pos);
			this.tamanio -= 1;
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.printf("Se ha eliminado un dato: ", this.arrayList.get(pos));
		}
	}

	@Override
	public Boolean esVacia() {
		if (this.arrayList.isEmpty() == true){
			System.out.println("La lista está vacía");
			return true;
		}else{
			return false;
		}
	}


	@Override
	public Boolean incluye(Object elem) {
		if (this.arrayList.contains(elem) == true){
			System.out.println("Se ha encontrado el elemento en la lista");
			return true;
		}else{
			System.out.println("El elemento NO existe");
			return false;
		}
	}

	
    
	
	
}
