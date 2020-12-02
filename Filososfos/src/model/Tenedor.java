package model;

public class Tenedor {
	Boolean estado;
	
	public Tenedor() {
		estado=false;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public void coger() {
		estado=true;
	}
	
	public void soltar() {
		estado=false;
	}

}
