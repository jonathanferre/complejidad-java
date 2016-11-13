package tp_final;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LecturaARchivos {
	private static Grafo grafo = new Grafo();
	
	static String separador = (",");
	static String comentario = ("#");
	static String comentDistancia = ("#D");
	static String comentVelocidad = ("#V");
	static String comentPeso = ("#P");
	
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

                	
                	grafo.agregar_ciudad(nuevaCiudad);
    				
    				
    				//System.out.println(Ciudad);       			
        		}	
        	}
        br.close(); // cierro el buffer
 
		}catch(Exception e){
			System.err.println("No se encontro el archivo de vertices.txt");
		}
		
	}
	public static void Aristas(String uriArista) throws FileNotFoundException, IOException {
		System.out.println("Método ARTISTAS");
		int contLinea=0;
		String linea = null;
        String distancia;
        String velMaxima;
        String pesoMax;
        
        //Para abrir el Fichero que se le pasa como param al FileReader
        FileReader f = new FileReader(uriArista);    //Leo el archivo que le paso por parametro
        BufferedReader b = new BufferedReader(f);
		
        int cantidad = grafo.getListaDeCiudades().getTamanio();
        //Cada ciudad puede tener hasta 10 rutas, cuando conectamos solo se hace cuando la distancia es > 0 
        Ruta[][] rutas = new Ruta [cantidad][];
        
        //Se crea la matriz de 10 x 10
        for(int i = 0; i<cantidad; i++){
            rutas[i]=new Ruta[10];
            for(int j = 0; j<cantidad; j++){
                rutas[i][j]=new Ruta(0,0.0,0);
            }
        }
        
        while((linea = b.readLine())!=null && contLinea<=11 ){		//obtengo cada linea
        	String comienzo= linea.substring(0,2);
    		if (comienzo.equals(comentDistancia)){				//obtengo el comiendo de cada linea
        		contLinea++;
    		}else{
    			for(int i =0; i<cantidad; i++){     
    				for (String retval: linea.split(separador)) {
    					for (int j=0; j< cantidad; j++){
        					distancia= retval.toString();
        					rutas[i][j].setDistancia(Integer.parseInt(distancia));
        				}	
    				}
    				
    				
    			}
            }
    		
		}
        while ((linea = b.readLine()) !=null && contLinea>11 && contLinea<22){
        	String comienzo = linea.substring(0,2);
        	if (comienzo.equals(comentVelocidad)){
        		contLinea++;
        	}else{
    			for(int i =0; i<cantidad; i++){
    				String[] retval = linea.split(separador);
    				velMaxima= retval.toString();
    				for (int j=0; j< cantidad; j++){
    					rutas[i][j].setVelocidadMaxCiudades(Float.parseFloat(velMaxima));
    				}
    				
    			}
        	}
        }	
        while ((linea = b.readLine()) !=null && contLinea> 23 && contLinea< 34){
        	String comienzo = linea.substring(0,2);
        	if (comienzo.equals(comentPeso)){
        		contLinea++;
        	}else{
    			for(int i =0; i<cantidad; i++){
    				String[] retval = linea.split(separador);
    				pesoMax= retval.toString();
    				for (int j=0; j< cantidad; j++){
    					rutas[i][j].setPesoMaximo(Integer.parseInt(pesoMax));
    				}
    				
    			}
        	}
        }
        
    	for (int i=0; i<cantidad; i++){
    		for(int j = 0; j<cantidad; j++){
    			if (rutas[i][j].getDistancia()>0){
    				grafo.conectar((Ciudad) grafo.getListaDeCiudades().elemento(i), (Ciudad) grafo.getListaDeCiudades().elemento(j), rutas[i][j]);
    			}
   			}
   		}
    			
    			

		

	}
	
	//Método para llamar a los contructores 
	public static void construir(String uriVertice,String uriArista) throws FileNotFoundException, IOException{
		Vertices(uriVertice);
		Aristas(uriArista);
		
	}
	
	public static void main(String[] args) throws IOException {
    	//LecturaTxt("/home/ncavallaro/Escritorio/txt/vertices.txt","/home/ncavallaro/Escritorio/txt/aristas.txt");
		construir("/Users/NicoCav/Documents/vertices.txt","/Users/NicoCav/Documents/aristas.txt"); 
    }
}



