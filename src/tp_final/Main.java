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
		inicializador.Aristas(uriArista);
		inicializador.Vertices(uriVertice);
		
		//llamar al m�todo que cree la matr�z y conecte
		
			
		//Hacer consultas
		}
}	
    	


	
	
	
	
	