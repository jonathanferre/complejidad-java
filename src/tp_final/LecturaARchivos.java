package tp_final;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import clase1_Listas.ListaConArreglo;

public class LecturaARchivos {
	
	static Grafo grafoParameter;
	static ArrayList<String> listaCamino = new ArrayList<String>();
	
	public LecturaARchivos(Grafo g){
		LecturaARchivos.grafoParameter = g;
	}
	
	static String separador = (",");
	static String comentario = ("#");
	static String comentDistancia = ("#D");
	static String comentVelocidad = ("#V");
	static String comentPeso = ("#P");
	
	public static Grafo getGrafoParameter() {
		return grafoParameter;
	}
	public static void setGrafoParameter(Grafo grafoParameter) {
		LecturaARchivos.grafoParameter = grafoParameter;
	}
	
	public static void Vertices(String uriVertice) throws FileNotFoundException, IOException { //Se le pasa como param el direccion del archivo a leer

		try{
			int contadorV=0;
			String Ciudades;
			String nombreCiudad = null;
			String STaltura = null;
			String STdistancia = null;
			String STvelocidadMedia = null;


			//Para abrir el Fichero que se le pasa como param al FileReader
			FileReader fr = new FileReader(uriVertice); //Leo el archivo que le paso por parametro
			BufferedReader br = new BufferedReader(fr);
       
			//Recorro ciudad y guardo sus datos en lista
			while((Ciudades = br.readLine())!=null && contadorV<=10 ){  //Guardo en Ciudades cada linea del buffer
        		String comienzo= Ciudades.substring(0,1);     //obtengo el comienzo de cada linea
        		if (comienzo.equals(comentario)){			//Si es un comentario hago salto de linea
            		;
        		}else {
        	        ArrayList<String> lista = new ArrayList<String>();
            		for (String retval: Ciudades.split(separador)){   //obtengo cada valor separado por "," y se lo agrego a lista
                    	lista.add(retval);       	
                    }
                    //Lleno las variable y las parseo
            		nombreCiudad=lista.get(0);
                	STaltura=lista.get(1);
                	int altura = Integer.parseInt(STaltura);
                	STdistancia=lista.get(2);
                	int distancia= Integer.parseInt(STdistancia);
                	STvelocidadMedia=lista.get(3);
                	float velocidadMedia=Float.parseFloat(STvelocidadMedia);
                	
                	
                	//Armo la ciudad con sus datos
                	
                	Ciudad nuevaCiudad = new Ciudad();
                	DatosCiudad datosCiudad = new DatosCiudad(nombreCiudad, altura, distancia, velocidadMedia);
                	nuevaCiudad.setDatoCiudad(datosCiudad);
                	
                	//agregar pos a la ciudades
                	nuevaCiudad.setPosicion(contadorV);
                	
                	grafoParameter.agregar_ciudad(nuevaCiudad);
    				
                	contadorV++;

    				//System.out.println(Ciudad);       			
        		}	
        	}
        br.close(); // cierro el buffer
 
		}catch(Exception e){
			System.err.println("No se encontro el archivo de vertices.txt");
		}
		
	}
	public static void Aristas(String uriArista) throws FileNotFoundException, IOException {
		int contLinea=0;
		String linea = null;
        String distancia;
        String velMaxima;
        String pesoMax;
        
        //Para abrir el Fichero que se le pasa como param al FileReader
        FileReader f = new FileReader(uriArista);    //Leo el archivo que le paso por parametro
        BufferedReader b = new BufferedReader(f);
		
        int cantidad = grafoParameter.getListaDeCiudades().getTamanio();
        //Cada ciudad puede tener hasta 10 rutas, cuando conectamos solo se hace cuando la distancia es > 0 
      
        Costos [][] costos = new Costos [cantidad][];
        for (int i = 0; i < cantidad; i++) {
			costos[i] = new Costos[10];
			for(int j = 0; j<cantidad; j++){
				costos[i][j] = new Costos(0, (float) 0.0, 0);
			}
		}
        


    	for(int x =0; x<2; x++){  //Con este For hacemos que saque la primer linea ya que es un comentario
    		linea = b.readLine();  
    		String comienzo= linea.substring(0,2);
    		if (comienzo.equals(comentDistancia)){  //Si es un comentario pasa a la siguiente linea
    			;
    		}else{
    			for(int i =0; i<cantidad; i++){
    				String[] retval= linea.split(separador);   //guarda cada valor que esta entre "," en la lista de String
    				for (int j=0; j< cantidad; j++){
    					costos[i][j].setDistanciaRuta(Integer.parseInt(retval[j]));//guarda en la matriz el valor en la posicion J
    					//System.out.println(rutas[i][j].getDistancia()+" m");
    				}
    				linea = b.readLine();  //lee la siguiente linea
    			}	
    		}	
    	}
            	
       for (int x=0; x<2; x++){
    	   String comienzo = linea.substring(0,2);
    	   if (comienzo.equals(comentVelocidad)){
    		   linea= b.readLine();
    	   }else{
    		   for(int i =0; i<cantidad; i++){
    			   String[] retval = linea.split(separador);
    			   for (int j=0; j< cantidad; j++){
    				   costos[i][j].setVelocidadMaxCiudades(Float.parseFloat(retval[j]));
    				   //System.out.println(costos[i][j].getVelocidadMaxCiudades()+" m/s2");
    				}
    				linea= b.readLine();
    			}
        	}
        }
        for (int x=0; x<2; x++){
        	String comienzo = linea.substring(0,2);
        	if (comienzo.equals(comentPeso)){
        		linea = b.readLine();
        	}else{
    			for(int i =0; i<cantidad; i++){
    				String[] retval = linea.split(separador);
    				for (int j=0; j< cantidad; j++){
    					costos[i][j].setPesoMaximo(Integer.parseInt(retval[j]));
    					//System.out.println(costos[i][j].getPesoMaximo()+ " Kg");
    				}
    				linea= b.readLine();
    			}
        	}
        }
        
    	for (int i=0; i<cantidad; i++){
    		for(int j = 0; j<cantidad; j++){
    			if (costos[i][j].getDistanciaRuta()>0){
    				grafoParameter.conectar((Ciudad) grafoParameter.getListaDeCiudades().elemento(i), (Ciudad) grafoParameter.getListaDeCiudades().elemento(j), costos[i][j]);
    			}
   			}
   		}
    	
	}	
    	public static void OrigenDestino (String uriOrigDest) throws FileNotFoundException, IOException {
    		
   		 //Para abrir el Fichero que se le pasa como param al FileReader
           FileReader fr = new FileReader(uriOrigDest);    //Leo el archivo que le paso por parametro
           BufferedReader br = new BufferedReader(fr);
           
           String linea;
           while((linea = br.readLine())!=null ){  
        	   listaCamino.add(linea);
           }          
           
       br.close();
   	}
    	
    	public static void menuConsola (ArrayList<String> listaCamino){
    		String origen = null;
    		String destino = null;
    		
    		Scanner sc = new Scanner(System.in);
    		System.out.println(">>>Modulo de Consulta>>>");
    		System.out.println("Elija una de las siguientes opciones");
    		for (int i = 0; i < listaCamino.size(); i++) {
    			System.out.println(i+"- " + listaCamino.get(i));
			}
    		System.out.println("Su opci\u00f3n es:");
    		String  opcion = sc.nextLine();
    		int cant= Integer.parseInt(opcion);
    		
    		String linea =listaCamino.get(cant);
    		String[] origDest = linea.split(separador);
    		for (String letras : origDest){
    			if (origen==null){
    				origen=letras;
    			}else{
    				destino= letras;
    			}
    		}
    		
    		  			
			
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



