package models;

public class Dato {
	String nombre,ultimo,diferencial,maximo,minimo,volumen,efectivo,fecha,hora;
	
	public Dato(String nombre,String ultimo,String diferencial,String maximo,String minimo,String volumen,String efectivo,String fecha,String hora) {
	
		this.nombre=nombre;
		this.ultimo=ultimo;
		this.diferencial=diferencial;
		this.maximo=maximo;
		this.minimo=minimo;
		this.volumen=volumen;
		this.efectivo=efectivo;
		this.fecha=fecha;
		this.hora=hora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUltimo() {
		return ultimo;
	}

	public void setUltimo(String ultimo) {
		this.ultimo = ultimo;
	}

	public String getDiferencial() {
		return diferencial;
	}

	public void setDiferencial(String diferencial) {
		this.diferencial = diferencial;
	}

	public String getMaximo() {
		return maximo;
	}

	public void setMaximo(String maximo) {
		this.maximo = maximo;
	}

	public String getMinimo() {
		return minimo;
	}

	public void setMinimo(String minimo) {
		this.minimo = minimo;
	}

	public String getVolumen() {
		return volumen;
	}

	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}

	public String getEfectivo() {
		return efectivo;
	}

	public void setEfectivo(String efectivo) {
		this.efectivo = efectivo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	//nombre,ultimo,diferencial,maximo,minimo,volumen,efectivo,fecha,hora  "\n";
	public String toString() {
		return nombre+" | "+ultimo+" | "+diferencial+" | "+maximo+" | "+minimo+" | "+volumen+" | "+efectivo+" | "+fecha+" | "+hora;
	}
	
}
