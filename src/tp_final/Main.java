package tp_final;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import clase1_Listas.ListaConArreglo;
import clase1_Listas.Recorredor;

public class Main {	
	
		public static void main(String[] args) throws IOException {
		
		//crear grafo o llamar inicializar de grafo (pasar grafo por par�metro
			
		Grafo g = new Grafo();
		
		
		
		
		//llamar al m�todo que cree la matr�z y conecte
		LecturaARchivos inicializador = new LecturaARchivos(g);
		//Archivos Nico
	//	inicializador.Vertices("/Users/NicoCav/Documents/vertices.txt");
	//	inicializador.Aristas("/Users/NicoCav/Documents/aristas.txt");
	//	inicializador.OrigenDestino("/Users/NicoCav/Documents/OrigDest.txt");
		
		//Archivos Joni
		inicializador.Vertices("/home/jferre/Documentos/vertices.txt");
		inicializador.Aristas("/home/jferre/Documentos/aristas.txt");
	//	inicializador.OrigenDestino("/home/jferre/Documentos/OrigDest.txt");
		
		//recorriendo las ciudades que tiene el grafo
		Recorredor r = g.getListaDeCiudades().recorredor();
		r.comenzar();
		while(!r.fin()){
			Ciudad elem = (Ciudad) r.elemento();
			System.out.println(elem.getDatoCiudad().toString());
			
			//obtengo la/s ruta/s de la ciudad/es
			System.out.println(elem.getAdyacentes().toString());
			
			//Verificar si la ruta está yendo a la ciudad indicada
			System.out.println(elem.getAdyacentes().get(1).getDestino().getDatoCiudad().getNombreCiudad());
			
			r.proximo();
			
		}
		//Hacer consultas
		
		}
}	
    	


	
	
	
	
	