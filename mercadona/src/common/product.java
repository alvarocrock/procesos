package common;

import java.io.Serializable;

public class product implements Serializable{
	
	int id;
	String producto;
	float price;
	int amount;
	
	public product(int _id,String _producto, float _price) {
		id=_id;
		producto=_producto;
		price=_price;
		amount=0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	

}
