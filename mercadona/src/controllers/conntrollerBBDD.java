package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.Statement;

import common.employee;
import common.product;
import common.sale;
import constants.ConstantsBDD;

public class conntrollerBBDD implements ConstantsBDD{
	
	
	public conntrollerBBDD() {
		
	}
	
	
	/**
	 * comportamiento que establece una conexion con la bbdd
	 * @return
	 */
	public java.sql.Connection conectar() {
    	java.sql.Connection conexion = null;
        try {
            Class.forName(CONTROLADOR);
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            //System.out.println("Conexi�n OK");

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Error en la conexi�n");
            e.printStackTrace();
        }  
        return conexion;
    }
	
	
	/**
	 * comportamiento que busca un employee y lo devuelve dado un  id
	 * @param id
	 * @return
	 */
	public employee searchEmployee(int id) {
		Connection conn = null;
	    Statement stmt = null;
	    employee _employee=null;

	    try {

	      conn = conectar();
	      stmt = (Statement) conn.createStatement();

	      ResultSet rs = stmt.executeQuery ("SELECT id FROM employee where id="+id);
	      
	      while (rs.next())
	      {
	         _employee= new employee(rs.getInt(1));
	      }
	      

	    } catch (SQLException e) {
	      e.printStackTrace();
	    	
	    } finally {
	      try {
	        // Close connection
	        if (stmt != null) {
	          stmt.close();
	        }
	        if (conn != null) {
	          conn.close();
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	    return _employee;
	}
	
	/**
	 * comportamiento que obtiene las ventas de un employee hechas el mismo dia
	 * @param id
	 * @return
	 */
	public ArrayList<sale> getSales(int id){
		ArrayList<sale> sales= new ArrayList<sale>();
		Connection conn = null;
	    Statement stmt = null;
	    sale s=null;
	    java.util.Date fecha = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	    try {

	      conn = conectar();
	      stmt = (Statement) conn.createStatement();

	      String sql="SELECT * FROM mercadona.purchases where id_employee="+id+" && purchase_date='"+dateFormat.format(fecha)+"';";
	      ResultSet rs = stmt.executeQuery (sql);
	      
	      while (rs.next())
	      {
	         s= new sale(rs.getString(2), rs.getInt(3), rs.getInt(4));
	         sales.add(s);
	      }
	      

	    } catch (SQLException e) {
	      e.printStackTrace();
	    	
	    } finally {
	      try {
	        // Close connection
	        if (stmt != null) {
	          stmt.close();
	        }
	        if (conn != null) {
	          conn.close();
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
		
		return sales;
	}
	
	/**
	 * devuelve una lista con todos los productos
	 * @return
	 */
	public ArrayList<product> getProducts(){
		ArrayList<product> products=new ArrayList<product>();
		product pr=null;
		Connection conn = null;
	    Statement stmt = null;

	    try {

	      conn = conectar();
	      stmt = (Statement) conn.createStatement();

	      ResultSet rs = stmt.executeQuery ("SELECT id,product,customer_price FROM mercadona.products;");
	      
	      while (rs.next())
	      {
	         pr= new product(rs.getInt(1), rs.getString(2), rs.getFloat(3));
	         products.add(pr);
	      }
	      

	    } catch (SQLException e) {
	      e.printStackTrace();
	    	
	    } finally {
	      try {
	        // Close connection
	        if (stmt != null) {
	          stmt.close();
	        }
	        if (conn != null) {
	          conn.close();
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
		
		
		return products;
	}
	
	/**
	 * inserta un campo en la taabla de prurchases
	 * @param id_pr
	 * @param id_emple
	 */
	public void insertSales(String id_pr,String id_emple) {
		java.util.Date fecha = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String SQL="INSERT INTO `mercadona`.`purchases` (`purchase_date`, `id_product`, `id_employee`) VALUES ('"+dateFormat.format(fecha)+"', '"+id_pr+"', '"+id_emple+"');";
		Connection conn = null;
	    Statement stmt = null;

	    try {

	      conn = conectar();
	      stmt = (Statement) conn.createStatement();
	      
	      stmt.executeUpdate(SQL);
	      

	    } catch (SQLException e) {
	      e.printStackTrace();
	    	
	    } finally {
	      try {
	        // Close connection
	        if (stmt != null) {
	          stmt.close();
	        }
	        if (conn != null) {
	          conn.close();
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	}
	
	/**
	 * co portamiento que actualiza el stock
	 * @param cantidad
	 * @param id
	 */
	public void updateStock(int cantidad,String id) {
		//UPDATE `mercadona`.`products` SET `stock_amount` = '101' WHERE (`id` = '1');
		String SQL="UPDATE `mercadona`.`products` SET `stock_amount` = '"+cantidad+"' WHERE (`id` = '"+id+"');";
		Connection conn = null;
	    Statement stmt = null;

	    try {

	      conn = conectar();
	      stmt = (Statement) conn.createStatement();
	      
	      stmt.executeUpdate(SQL);
	      

	    } catch (SQLException e) {
	      e.printStackTrace();
	    	
	    } finally {
	      try {
	        // Close connection
	        if (stmt != null) {
	          stmt.close();
	        }
	        if (conn != null) {
	          conn.close();
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	}
	
	
	/**
	 * comportamiento que obtiene el stock d un producto
	 * @param id
	 * @return
	 */
	public int getStock(int id) {
		int stock = 0;
		Connection conn = null;
	    Statement stmt = null;

	    try {

	      conn = conectar();
	      stmt = (Statement) conn.createStatement();
	      
	      
	      ResultSet rs = stmt.executeQuery ("SELECT stock_amount FROM mercadona.products where id="+id+";");
	      
	      while (rs.next())
	      {
	         stock=rs.getInt(1);
	      }
	      

	    } catch (SQLException e) {
	      e.printStackTrace();
	    	
	    } finally {
	      try {
	        // Close connection
	        if (stmt != null) {
	          stmt.close();
	        }
	        if (conn != null) {
	          conn.close();
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
		
		
		return stock;
	}

}
