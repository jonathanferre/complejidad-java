package tp_final;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import clase1_Listas.ListaConArreglo;
import clase1_Listas.Recorredor;

public class Main {	
	
		public static void main(String[] args) throws IOException {
		
		
			
		Grafo g = new Grafo();		
		
		
		//llamar al metodo que cree la matriz y conecte
		LecturaARchivos inicializador = new LecturaARchivos(g);

		inicializador.Vertices("vertices.txt");
		inicializador.Aristas("aristas.txt");
		inicializador.OrigenDestino("OrigDest.txt");
		inicializador.menuConsola(inicializador.listaCamino);
		
		//recorriendo las ciudades que tiene el grafo
		Recorredor r = g.getListaDeCiudades().recorredor();
		r.comenzar();
		while(!r.fin()){
			Ciudad elem = (Ciudad) r.elemento();
			//System.out.println(elem.getDatoCiudad().toString());
			
			//obtengo la/s ruta/s de la ciudad/es
			//System.out.println(elem.getAdyacentes().toString());
			
			//Verificar si la ruta está yendo a la ciudad indicada
			//System.out.println(elem.getAdyacentes().get(0).getDestino().getDatoCiudad().getNombreCiudad());
			
			r.proximo();
			
		}
	
		
		//Variables vac�as
		Ciudad origen = null;
		Ciudad destino = null;
		int distancia = 0;
		int mejorDis = 999999999;
		double camino= 0.0;
		double mejorCamino= 0.0;
		ArrayList<Ciudad> visitado = new ArrayList<Ciudad>();
		double valor = 0.0;
		double valormax = 0.0;
		ArrayList<Ciudad> caminoList = new ArrayList<Ciudad>();
		ArrayList<Ciudad> mejorCaminoLis = new ArrayList<Ciudad>();	
		
		
		
		/*if (opcion.equals("1")){
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
		*/
		RecorredorGrafo recorredorGrafo = new RecorredorGrafo();

		System.out.println("Elija que desea hacer");
		System.out.println("1-Velocidad m\u00e1xima que puede alcanzar un veh\u00edculo entre una ciudad origen y otra destino.");
		System.out.println("2-Ruta desde una ciudad origen y otra destino donde la distancia transitada sea m\u00ednima.");
		System.out.println("3-Variaci\u00f3n de Alturas entre una ciudad origen y todas las ciudades vecinas.");
		System.out.println("Su opci\u00f3n es:");
		String consulta = sc.nextLine();
		
		
		
		
		
		if (consulta.equals("1")){
			recorredorGrafo.buscar_VelocidadMax(origen, destino, camino, mejorCamino, visitado);
		}
		
		if (consulta.equals("2")){
			recorredorGrafo.buscar_DistanciaMin(origen, destino,caminoList,visitado, distancia, mejorDis,mejorCaminoLis);
		}
		
		if (consulta.equals("3")){
			recorredorGrafo.buscar_VariacionAltura(origen);
		}
	}
}	
    	


	
	
	
	
	