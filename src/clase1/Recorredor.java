package clase1;

public class Recorredor {
	
	private int actual;
	private Lista lista;
	
	
	//method
    public void comenzar()
    {
        this.actual = 0;
        System.out.printf("La posición actual es: ", this.actual);
    }

    //Error
    public Object elemento()
    {
        return this.lista.elemento(actual);
    }

    public void proximo()
    {
        this.actual += 1;
        System.out.println(this.actual);
    }

    public Boolean fin()
    {
        if (this.actual == lista.getTamanio())
        {
            System.out.println("Fin");
            return true;
        }
        else
        {
            return false;
        }
    }

    public void agregar(Object elem)
    {
        this.lista.agregar(elem, this.actual);
    }

    public void eliminar()
    {
        this.lista.eliminar(this.actual);
    }

    public Recorredor(Lista lista)
    {
        this.lista = lista;
        this.actual = 0;
    }
}

