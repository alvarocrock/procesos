package common;

import java.io.Serializable;

public class employee implements Serializable{

	Integer id;
	
	public employee() {
		id=null;
	}
	
	public employee(Integer _id) {
		id = _id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
