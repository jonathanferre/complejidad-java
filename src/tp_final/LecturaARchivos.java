package tp_final;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LecturaARchivos {
	
	static Grafo grafoParameter;
	
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
                	contadorV++;
                	
                	//Armo la ciudad con sus datos
                	
                	Ciudad nuevaCiudad = new Ciudad();
                	DatosCiudad datosCiudad = new DatosCiudad(nombreCiudad, altura, distancia, velocidadMedia);
                	nuevaCiudad.setDatoCiudad(datosCiudad);

                	
                	grafoParameter.agregar_ciudad(nuevaCiudad);
    				
    				
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
        Ruta[][] rutas = new Ruta [cantidad][];
        
        //Se crea la matriz de 10 x 10
        for(int i = 0; i<cantidad; i++){
            rutas[i]=new Ruta[10];
            for(int j = 0; j<cantidad; j++){
                rutas[i][j]=new Ruta(0,(float) 0.0,0);
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
    					rutas[i][j].setDistancia(Integer.parseInt(retval[j]));  //guarda en la matriz el valor en la posicion J
    					System.out.println(rutas[i][j].getDistancia()+" m");
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
    				   rutas[i][j].setVelocidadMaxCiudades(Float.parseFloat(retval[j]));
    				   System.out.println(rutas[i][j].getVelocidadMaxCiudades()+" m/s2");
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
    					rutas[i][j].setPesoMaximo(Integer.parseInt(retval[j]));
    					System.out.println(rutas[i][j].getPesoMaximo()+ " Kg");
    				}
    			}
        	}
        }
        
    	for (int i=0; i<cantidad; i++){
    		for(int j = 0; j<cantidad; j++){
    			if (rutas[i][j].getDistancia()>0){
    				grafoParameter.conectar((Ciudad) grafoParameter.getListaDeCiudades().elemento(i), (Ciudad) grafoParameter.getListaDeCiudades().elemento(j), rutas[i][j]);
    			}
   			}
   		}
    	
	}	
    	public static void OrigenDestino (String uriOrigDest) throws FileNotFoundException, IOException {
    		
   		 ArrayList<String> caminos = new ArrayList<String>();
   		 //Para abrir el Fichero que se le pasa como param al FileReader
           FileReader fr = new FileReader(uriOrigDest);    //Leo el archivo que le paso por parametro
           BufferedReader br = new BufferedReader(fr);
           
           String linea;
           while((linea = br.readLine())!=null ){  
           	caminos.add(linea);
           }
           System.out.println(caminos);
       br.close();
   	}		

		

	
	
	//Metodo para llamar a los contructores 
	public static void construir(String uriVertice,String uriArista, String uriOrigDest) throws FileNotFoundException, IOException{
		Vertices(uriVertice);
		Aristas(uriArista);
		OrigenDestino(uriOrigDest);
		
	}
}



