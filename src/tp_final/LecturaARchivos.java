package tp_final;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LecturaARchivos {
	
	public static void LecturaTxt(String uriVertice, String uriArtista) throws FileNotFoundException, IOException { //Se le pasa como param el direccion del archivo a leer
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
                    //Lleno las variable
            		nombreCiudad=lista.get(0);
            		listaCiudades.add(nombreCiudad);
                	STaltura=lista.get(1);
                	int altura = Integer.parseInt(STaltura);
                	STdistancia=lista.get(2);
                	int distancia= Integer.parseInt(STdistancia);
                	STvelocidadMedia=lista.get(3);
                	float velocidadMedia=Float.parseFloat(STvelocidadMedia);
                	contadorV++;
                	     	
    				//Ciudad Ciudad = new Ciudad (nombreCiudad,altura,distancia,velocidadMedia,adyacentes);  //Constructor de ciudad
    				
    				//System.out.println(Ciudad);       			
        		}	
        	}
        br.close(); // cierro el buffer
        
		int contadorA=0;
		String Aristas = null;
        String STdistanciaA;
        String STvelMaxima;
        String STpesoMaxi;
        
        //Para abrir el Fichero que se le pasa como param al FileReader
        FileReader f = new FileReader(uriArtista);    //Leo el archivo que le paso por parametro
        BufferedReader b = new BufferedReader(f);
        
        
        while((Aristas = b.readLine())!=null && contadorA<=10 ){		//obtengo cada linea
        	String comienzo= Aristas.substring(0,2);
    		if (comienzo.equals("#D")){				//obtengo el comiendo de cada linea
        		;
    		}else{
    			//int posInicial = 0;
    			int pos=0;
    			ArrayList<String> listaArista = new ArrayList<String>();
        		for (String retval: Aristas.split(",")){
        			if (retval.equals("0")){
        				pos = pos + 1;
        			}else{
        				listaArista.add(listaCiudades.get(contadorA)+" es adyasente a "+ listaCiudades.get(pos)+" con una distancia de: "+retval+"m");
        				pos=pos + 1;
                		System.out.println(listaArista);
        			}
                	
        		} contadorA++;

    		} 
    	
        
		
        }b.close();
        
        
        
     
    }catch(Exception e){
        System.err.println("No se encontro algun archivo");
    }
}   
             
	
	
		
    public static void main(String[] args) throws IOException {
    	//LecturaTxt("/home/ncavallaro/Escritorio/txt/vertices.txt","/home/ncavallaro/Escritorio/txt/aristas.txt");
    	LecturaTxt("/Users/NicoCav/Documents/vertices.txt","/Users/NicoCav/Documents/aristas.txt"); 
    }


}




