package tp_final;

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
		
		
		ciudadVarela.setDatoCiudad(datoVarela);
		ciudadLaPlata.setDatoCiudad(datoLaPlata);
		
		Ruta ruta = new Ruta();
		ruta.setDestino(ciudadLaPlata);
		ruta.setDistancia(3500);
		ruta.setPesoMaximo(900);
		ruta.setVelocidadMaxCiudades(190);
		
		main.agregar_ciudad(ciudadVarela);
		main.agregar_ciudad(ciudadLaPlata);
		
		//conectar debe tener como parámetro un origen 
		Ciudad pos1 = (Ciudad) main.getListaDeCiudades().elemento(0);
		
		//
		main.conectar(pos1, ruta.getPesoMaximo(), ruta.getVelocidadMaxCiudades(), ruta.getDistancia());
		
	}

}
