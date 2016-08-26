package clase1;

public abstract class Lista {
	protected int tamanio = 0;
	
	//method
	public abstract Object elemento(int pos);
	
	public abstract void agregar(Object elem, int pos);
	
	public abstract void eliminar(int pos);
    
	public abstract Boolean esVacia();

    public abstract Boolean incluye(Object elem);

    public Recorredor recorredor() {
         return new Recorredor(this);
     }

     public int getTamanio() {
         return this.tamanio;
     }
}
