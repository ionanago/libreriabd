package com.ipartek.formacion.mf0967_3.accesodatos;
import java.sql.*;

public class Conexion {
	
	
	private String user="root";
	private String passwd="admin";
	protected Connection con =null;
	 public  Conexion(){
		 
		 try {
			 new com.mysql.cj.jdbc.Driver();
			 String uri = "jdbc:mysql://localhost:3307/libreria_1?serverTimezone=UTC";
			 con = DriverManager.getConnection(uri, user , passwd);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 
	 }
	 
	
	
	
	
	 
		

//		try {
//			// Class.forName("com.mysql.cj.jdbc.Driver");
//			// new com.mysql.cj.jdbc.Driver();
//
//			String uri = "jdbc:mysql://localhost:3307/libreria_1?serverTimezone=UTC";
//
//			try (Connection con = DriverManager.getConnection(uri, "root", "admin")) {
//
//				System.out.println("Conectado");
//
//				try (Statement s = con.createStatement()) {
//
//					// String sql = "SELECT titulo, autor FROM libros";
//					 String sql = "SELECT * FROM libros";
//
//					try (ResultSet rs = s.executeQuery(sql)) {
//
//
//
//						while (rs.next()) {
//							System.out.println(rs.getString("titulo") + ", " + rs.getString("autor"));
//
//						}
//					}
//				}
//
//				int id = 1;
//
//				String sql = "SELECT * FROM libros WHERE id=?";
//
//				try (PreparedStatement ps = con.prepareStatement(sql)) {
//
//					ps.setInt(1, id);
//
//					try (ResultSet rs = ps.executeQuery()) {
//						while (rs.next()) {
//							System.out.println(rs.getString("autor"));
//						}
//					}
//				}
//
//				String descripcion = "Modificada";
//				id = 1;
//				
//				sql = "UPDATE libros SET descripcion=? WHERE id=?";
//				
//				try (PreparedStatement ps = con.prepareStatement(sql)) {
//
//					ps.setString(1, descripcion);
//					ps.setInt(2, id);
//					
//					ps.executeUpdate();
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

}

