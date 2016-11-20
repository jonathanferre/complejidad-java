package tp_final;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import clase1_Listas.ListaConArreglo;
import clase1_Listas.Recorredor;

public class Main {	
	
		public static void main(String[] args) throws IOException {
		
		//crear grafo o llamar inicializar de grafo (pasar grafo por parï¿½metro
			
		Grafo g = new Grafo();		
		
		
		//llamar al mï¿½todo que cree la matrï¿½z y conecte
		LecturaARchivos inicializador = new LecturaARchivos(g);
		//Archivos Nico
		inicializador.Vertices("/Users/NicoCav/Documents/vertices.txt");
		inicializador.Aristas("/Users/NicoCav/Documents/aristas.txt");
		inicializador.OrigenDestino("/Users/NicoCav/Documents/OrigDest.txt");
		
		//Archivos Joni
		//inicializador.Vertices("/home/jferre/Documentos/vertices.txt");
		//inicializador.Aristas("/home/jferre/Documentos/aristas.txt");
	//	inicializador.OrigenDestino("/home/jferre/Documentos/OrigDest.txt");
		
		//recorriendo las ciudades que tiene el grafo
		Recorredor r = g.getListaDeCiudades().recorredor();
		r.comenzar();
		while(!r.fin()){
			Ciudad elem = (Ciudad) r.elemento();
			//System.out.println(elem.getDatoCiudad().toString());
			
			//obtengo la/s ruta/s de la ciudad/es
			//System.out.println(elem.getAdyacentes().toString());
			
			//Verificar si la ruta estÃ¡ yendo a la ciudad indicada
			//System.out.println(elem.getAdyacentes().get(1).getDestino().getDatoCiudad().getNombreCiudad());
			
			r.proximo();
			
		}

		Scanner sc = new Scanner(System.in);
		
		
		System.out.println(">>>Modulo de Consulta>>>");
		System.out.println("Eliga una de las siguientes opciones");
		System.out.println("1-Florencio Varela,La Plata");
		System.out.println("2-Buenos Aires,Avellaneda");
		System.out.println("3-Mar del Plata,Azul");
		System.out.println("4-Olavarria,Bolivar");
		System.out.println("5-Tandil,Junin");
		System.out.println("6-Florencio Varela,Junin");
		System.out.println("Su opcion es:");
		String opcion = sc.nextLine();
		
		//Variables vacías
		Ciudad origen = null;
		Ciudad destino = null;
		Ruta camino = null;
		Ruta mejorCamino = null;
		
		
		if (opcion.equals("1")){
			origen = (Ciudad) g.getListaDeCiudades().elemento(0);
			destino = (Ciudad) g.getListaDeCiudades().elemento(1);
			
		}
		
		if (opcion.equals("2")){
			origen = (Ciudad) g.getListaDeCiudades().elemento(2);
			destino = (Ciudad) g.getListaDeCiudades().elemento(3);
			
		}
		
		if (opcion.equals("3")){
			origen = (Ciudad) g.getListaDeCiudades().elemento(4);
			destino = (Ciudad) g.getListaDeCiudades().elemento(5);
			
		}
		
		if (opcion.equals("4")){
			origen = (Ciudad) g.getListaDeCiudades().elemento(6);
			destino = (Ciudad) g.getListaDeCiudades().elemento(7);
			
		}
		
		if (opcion.equals("5")){
			origen = (Ciudad) g.getListaDeCiudades().elemento(8);
			destino = (Ciudad) g.getListaDeCiudades().elemento(9);
			
		}
		
		if (opcion.equals("6")){
			origen = (Ciudad) g.getListaDeCiudades().elemento(0);
			destino = (Ciudad) g.getListaDeCiudades().elemento(9);
			
		}
		
		RecorredorGrafo recorredorGrafo = new RecorredorGrafo();

		System.out.println("Eliga que desea hacer");
		System.out.println("1-Velocidad máxima que puede alcanzar un vehículo entre una ciudad origen y otradestino.");
		System.out.println("2-Ruta desde una ciudad origen y otra destino donde la distancia transitada seamínima.");
		System.out.println("3-Variación de Alturas entre una ciudad origen y todas las ciudades vecinas.");
		System.out.println("Su opcion es:");
		String consulta = sc.nextLine();
		
		
		if (consulta.equals("1")){
			recorredorGrafo.buscar_VelocidadMax(origen, destino, camino, mejorCamino);
		}
		
		if (consulta.equals("2")){
			recorredorGrafo.buscar_DistanciaMin(origen, destino, camino, mejorCamino);
		}
		
		if (consulta.equals("3")){
			recorredorGrafo.buscar_VariacionAltura(origen);
		}
		
		
		
		
	
	
	
	
	}
}	
    	


	
	
	
	
	