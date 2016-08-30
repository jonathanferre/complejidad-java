package clase1_Listas;

import sun.misc.Queue;

public class Cola {
	
	private Queue cola = new Queue();
	
	public void poner(Object elem){
		this.cola.enqueue(elem);
	}
	
	//!!!!!!
	public void sacar(){
			try {
				this.cola.dequeue();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public boolean esVacia(){
		return this.cola.isEmpty();
	}
	
}
