package tp_final;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import clase1_Listas.Recorredor;

public class Main {

	public static void main(String uriVertice) throws FileNotFoundException, IOException { //Se le pasa como param el direccion del archivo a leer
		// TODO Auto-generated method stub
		Grafo main = new Grafo();
		try{
	        int contadorV=0;
	        String Ciudades;
	        String nombreCiudad = null;
	    	String STaltura = null;
	    	String STdistancia = null;
	    	String STvelocidadMedia = null;
	    	ArrayList<Object> adyacentes = null;
			ArrayList<String> listaCiudades = new ArrayList<String>();

	        //Para abrir el Fichero que se le pasa como param al FileReader
	        FileReader fr = new FileReader(uriVertice); //Leo el archivo que le paso por parametro
	        BufferedReader br = new BufferedReader(fr);
	       
	        //Recorro ciudad y guardo sus datos en lista
	        	while((Ciudades = br.readLine())!=null && contadorV<=10 ){  //Guardo en Ciudades cada linea del buffer
	        		String comienzo= Ciudades.substring(0,1);     //obtengo el comienzo de cada linea
	        		if (comienzo.equals("#")){			//Si es un comentario hago salto de linea
	            		;
	        		}else {
	        	        ArrayList<String> lista = new ArrayList<String>();
	            		for (String retval: Ciudades.split(",")){   //obtengo cada valor separado por "," y se lo agrego a lista
	                    	lista.add(retval);       	
	                    }
	                    //Lleno las variable y las parseo
	            		nombreCiudad=lista.get(0);
	            		listaCiudades.add(nombreCiudad);
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
	                	
	                	main.agregar_ciudad(nuevaCiudad);
	    				
	    				
	    				//System.out.println(Ciudad);       			
	        		}	
	        	}
	        br.close(); // cierro el buffer
		}catch(Exception e){
	        System.err.println("No se encontraron archivos");
	    }
		/*Ciudad ciudadVarela = new Ciudad();
		DatosCiudad datoVarela = new DatosCiudad();
		datoVarela.setAltura(100);
		datoVarela.setDistanciaCiudad(25);
		datoVarela.setNombreCiudad("Florencio Varela");
		datoVarela.setVelocidadMedia((float) 25.2);
		
		Ciudad ciudadLaPlata = new Ciudad();
		DatosCiudad datoLaPlata = new DatosCiudad();
		datoLaPlata.setAltura(50);
		datoLaPlata.setDistanciaCiudad(49);
		datoLaPlata.setNombreCiudad("La Plata");
		datoLaPlata.setVelocidadMedia((float) 20.2);
		
		Ciudad ciudadAvellaneda = new Ciudad();
		DatosCiudad datoAvellaneda = new DatosCiudad();
		datoAvellaneda.setAltura(20);
		datoAvellaneda.setDistanciaCiudad(35);
		datoAvellaneda.setNombreCiudad("Avellaneda");
		datoAvellaneda.setVelocidadMedia((float) 30.3); 
		
		//Seteo los datos a las ciudades
		ciudadVarela.setDatoCiudad(datoVarela);
		ciudadLaPlata.setDatoCiudad(datoLaPlata);
		ciudadAvellaneda.setDatoCiudad(datoAvellaneda);*/
		
		//ruta de Varela a La Plata
		Ruta rutaLP = new Ruta();
		rutaLP.setOrigen(ciudadVarela);
		rutaLP.setDestino(ciudadLaPlata);
		rutaLP.setDistancia(3500);
		rutaLP.setPesoMaximo(900);
		rutaLP.setVelocidadMaxCiudades(190);
		
		//Ruta de Varela a Avellaneda ----- Crear constructor de Ruta
		Ruta rutaAvellaneda = new Ruta();
		rutaAvellaneda.setOrigen(ciudadVarela);
		rutaAvellaneda.setDestino(ciudadAvellaneda);
		rutaAvellaneda.setDistancia(35);
		rutaAvellaneda.setPesoMaximo(22);
		rutaAvellaneda.setVelocidadMaxCiudades((float)134.45);
		
		
		/*main.agregar_ciudad(ciudadVarela);
		main.agregar_ciudad(ciudadLaPlata);
		main.agregar_ciudad(ciudadAvellaneda);*/
		
		//conectar debe tener como parámetro un origen 
		
		//Ciudad pos1 = (Ciudad) main.getListaDeCiudades().elemento(0);
		main.conectar(ciudadVarela, ciudadLaPlata, rutaLP);
		main.conectar(ciudadVarela, ciudadAvellaneda, rutaAvellaneda);
		
		
		//Recorre la lista de ciudades
		Recorredor rec = main.getListaDeCiudades().recorredor();
		rec.comenzar();
		while(!rec.fin()){
			Ciudad ciudad = (Ciudad) rec.elemento();
			ciudad.printNombreCiudad();
			rec.proximo();
		}
		
		//verificar las rutas que conecta Varela con las 2 ciudades (LP y Avellaneda)
		Ciudad varela =  (Ciudad) main.getListaDeCiudades().elemento(0);
		Ruta rutaVarela = varela.getAdyacentes().get(0);
		//
		System.out.println(rutaVarela.getDestino());
		
		//FileReader
		
	}	
	
    	//main("/home/ncavallaro/Escritorio/txt/vertices.txt","/home/ncavallaro/Escritorio/txt/aristas.txt");
    	//main("/Users/NicoCav/Documents/vertices.txt","/Users/NicoCav/Documents/aristas.txt"); 
    }

}
	main("/home/ncavallaro/Escritorio/txt/vertices.txt");
	
	
	
	