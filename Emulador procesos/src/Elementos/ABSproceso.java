package Elementos;

public class ABSproceso {
	
	
	protected String nombre;
	protected int T_Entrada;
	protected int Duracion;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getT_Entrada() {
		return T_Entrada;
	}

	public int getDuracion() {
		return Duracion;
	}

	public void setDuracion(int duracion) {
		Duracion = duracion;
	}
	
	public String ToString() {
		if (Duracion!=0) {
		return "proceso: "+ nombre+" duracion restante "+Duracion+"\n";
		} else {
		return "proceso: "+ nombre+" duracion restante "+Duracion+" Proceso finalizado"+"\n";
		}
	}
	
	

}
