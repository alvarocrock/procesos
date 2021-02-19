package common;

import java.io.Serializable;

public class sale implements Serializable{

	String sale_date;
	int id_pr;
	int id_emple;
	
	public sale(String _date,int _id_pr,int _id_emple) {
		sale_date=_date;
		id_pr=_id_pr;
		id_emple=_id_emple;
	}

	public String getSale_date() {
		return sale_date;
	}

	public void setSale_date(String sale_date) {
		this.sale_date = sale_date;
	}

	public int getId_pr() {
		return id_pr;
	}

	public void setId_pr(int id_pr) {
		this.id_pr = id_pr;
	}

	public int getId_emple() {
		return id_emple;
	}

	public void setId_emple(int id_emple) {
		this.id_emple = id_emple;
	}
	
	public String toString() {
		return "fecha "+sale_date+" product "+id_pr;
	}
	
}
