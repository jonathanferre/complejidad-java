package clase1;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.SystemException;

public class ListaConArreglo extends Lista {
	
	private ArrayList arrayList = new ArrayList();
	
	@Override
	public Object elemento (int pos){
		if (arrayList.get(pos) == null){
			return 
		}
		try {
			return arrayList.get(pos); //acceder a la lista en la posicion
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Elemento no encontrado");
		}
		
    }


	@Override
	public void agregar(Object elem, int pos) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminar(int pos) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Boolean esVacia() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean incluye(Object elem) {
		// TODO Auto-generated method stub
		return null;
	}

	
    
	
	
}
