package tp_final;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import clase1_Listas.Recorredor;

public class Main {	
	
		public static void main(String[] args) throws IOException {
		
		//crear grafo o llamar inicializar de grafo (pasar grafo por par�metro
			
		Grafo g = new Grafo();
		
		LecturaARchivos inicializador = new LecturaARchivos(g);
		inicializador.Vertices("/home/jferre/Documentos/vertices.txt");
		inicializador.Aristas("/home/jferre/Documentos/aristas.txt");
		//inicializador.OrigenDestino("/Users/NicoCav/Documents/OrigDest.txt");
		
		//recorriendo las ciudades que tiene el grafo
		Recorredor r = g.getListaDeCiudades().recorredor();
		r.comenzar();
		while(!r.fin()){
			Ciudad elem = (Ciudad) r.elemento();
			System.out.println(elem.getDatoCiudad().toString());
			r.proximo();
		}
		
		//revisar si las ciudades tienen rutas asignadas
		
		Recorredor r2 = g.getListaDeCiudades().recorredor();
		r.comenzar();
		while(!r2.fin()){
			Ciudad elem = (Ciudad) r.elemento();
			//obtengo la/s ruta/s de la ciudad/es
			for (int i = 0; i < elem.getAdyacentes().size(); i++) {
				System.out.println(elem.getAdyacentes().size());
				
			}
			r2.proximo();
		}
		
		
		//llamar al m�todo que cree la matr�z y conecte
		
		
			
		//Hacer consultas
		}
}	
    	


	
	
	
	
	