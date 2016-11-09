package tp_final;

import clase1_Listas.Recorredor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grafo main = new Grafo();
		
		Ciudad ciudadVarela = new Ciudad();
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
		ciudadAvellaneda.setDatoCiudad(datoAvellaneda);
		
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
		
		
		main.agregar_ciudad(ciudadVarela);
		main.agregar_ciudad(ciudadLaPlata);
		main.agregar_ciudad(ciudadAvellaneda);
		
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

}
