package com.ipartek.formacion.mf0967_3.servicios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import com.ipartek.formacion.mf0967_3.accesodatos.Conexion;
import com.ipartek.formacion.mf0967_3.modelo.Libro;



public class LibrosServicioImpl extends Conexion implements LibrosServicio {

	private static LibrosServicioImpl librosServicioImpl;
	
	public static LibrosServicio getInstance() {
		if (librosServicioImpl == null) {
			librosServicioImpl = new LibrosServicioImpl();
		}
		
		return librosServicioImpl;
	}
	
	private TreeMap<Long, Libro> libros;
	
	
	public ResultSet recorrerbd(){
		ResultSet rs=null;
		Statement s=null;
		try {
			s = super.con.createStatement();
			String sql = "SELECT * FROM libreria_1.libros";
			//String sql = "DELETE FROM libreria_1.libros WHERE id=?";
			//SELECT * FROM libreria_1.libros;
			 rs = s.executeQuery(sql);
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
			return rs;
		
		}
	public void borrarID(long id) {
		 String sql ="DELETE FROM libros WHERE id=?";
		
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setLong(1,id);
			ps.executeUpdate(sql);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		
		
	}
	
	
	
	private LibrosServicioImpl() {
		
			ResultSet rs = recorrerbd();	
		libros = new TreeMap<>();
		
		
		try {
			while(rs.next()) {
				try {
					libros.put(rs.getLong("id"), new Libro(
							rs.getLong("id"),
						rs.getString("imagen"),
						rs.getString("descripcion"), 
						rs.getString("autor"),
						rs.getBigDecimal("precio"), 
						rs.getBigDecimal("descuento")));
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}

//		for (long i = 1; i <= 8; i++) {
//			libros.put(i * 10, new Libro(
//					i * 10,
//					"libro" + ((i - 1) % 3 + 1) + ".png",
//					"Los futbolísimos. El misterio del jugador número " + i + " (T...", 
//					"Roberto Santiago",
//					new BigDecimal("11." + i * 10), 
//					new BigDecimal(i % 2 == 0 ? "0.05" : "0")));
		
	}
	
	@Override
	public Iterable<Libro> getLibros() {
		return libros.values();
	}

	@Override
	public Libro getLibro(Long id) {
		return libros.get(id);
	}

	@Override
	public void insertLibro(Libro libro) {
		Long id = libros.lastKey() + 1;
		libro.setId(id);
		libros.put(id, libro);
		//ResultSet rs = recorrerbd();
		
		
	}

	@Override
	public void updateLibro(Libro libro) {
		libros.put(libro.getId(), libro);
	}

	@Override
	public void deleteLibro(Long id) {
		borrarID(id);
		libros.remove(id);
		
		
	}
	
}
