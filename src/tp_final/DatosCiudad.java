package tp_final;

public class DatosCiudad {

	private String nombreCiudad;
	private int altura;
	private int distanciaCiudad;
	private float velocidadMedia;

	public String getNombreCiudad() {
		return nombreCiudad;
	}
	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getDistanciaCiudad() {
		return distanciaCiudad;
	}
	public void setDistanciaCiudad(int distanciaCiudad) {
		this.distanciaCiudad = distanciaCiudad;
	}
	public float getVelocidadMedia() {
		return velocidadMedia;
	}
	public void setVelocidadMedia(float velocidadMedia) {
		this.velocidadMedia = velocidadMedia;
	}
	public DatosCiudad(String nombreCiudad2, int altura2, int distancia,float velocidadMedia2) {
		this.nombreCiudad = nombreCiudad2;
		this.altura = altura2;
		this.velocidadMedia = velocidadMedia2;
		this.distanciaCiudad = distancia;
	}
	
	public String toString (){
		String c="Ciudad "+nombreCiudad;
		String h = "Altura "+altura;
		String vm = "VelocidadMedia " +velocidadMedia;
		String d = "Distancia ciudad "+ distanciaCiudad;
		return c +" "+ h +" "+vm+" "+ d;
	}
	
	
}
