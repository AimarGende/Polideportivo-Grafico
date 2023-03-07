package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioModelo extends Conector{

	PreparedStatement pt;
	String sentencia;
	
	
	public void insertarUsuario(Usuario usuario)  {
		sentencia="INSERT INTO usuarios (nombre_apellido,dni,codigo) VALUES(?,?,?)";
		getConexion();
		try {
			pt=super.getConexion().prepareStatement(sentencia);
			
			pt.setString(1, usuario.getNombre_apellido());
			pt.setString(2, usuario.getDni());
			pt.setString(3, usuario.getCodigo());
			
			pt.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public Usuario getUsuario(String codigo) {
		sentencia="SELECT * FROM usuarios WHERE codigo=?";
		Usuario usu=new Usuario();
		try {
			pt=getConexion().prepareStatement(sentencia);
			
			pt.setString(1, codigo);
			try {
				ResultSet result=pt.executeQuery();
				result.next();
				usu.setId(result.getInt("id"));
				usu.setNombre_apellido(result.getString("nombre_apellido"));
				usu.setDni(result.getString("dni"));
				usu.setCodigo(result.getString("codigo"));
			}catch(Exception e) {
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return usu;
	}
	
	public Usuario getUsuario(int id) {
		sentencia="SELECT * FROM usuarios WHERE id=?";
		Usuario usu=new Usuario();
		try {
			pt=getConexion().prepareStatement(sentencia);
			
			pt.setInt(1, id);
			try {
				ResultSet result=pt.executeQuery();
				result.next();
				usu.setId(result.getInt("id"));
				usu.setNombre_apellido(result.getString("nombre_apellido"));
				usu.setDni(result.getString("dni"));
				usu.setCodigo(result.getString("codigo"));
			}catch(Exception e) {
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return usu;
	}

	public boolean eliminarUsuario(int id) {
		sentencia="DELETE FROM usuarios WHERE id=?";
		
		try {
			pt=getConexion().prepareStatement(sentencia);
			pt.setInt(1, id);
			
			pt.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
	}
	
	public boolean eliminarUsuario(String codigo) {
		sentencia="DELETE FROM usuarios WHERE codigo=?";
		
		try {
			pt=getConexion().prepareStatement(sentencia);
			pt.setString(1, codigo);
			
			pt.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
	}
	
	public boolean modificarUsuario(Usuario usuario) {
		sentencia="UPDATE usuarios SET nombre_apellido=?, dni=?, codigo=? WHERE id=?";
		
		try {
			pt=getConexion().prepareStatement(sentencia);
			
			pt.setString(1, usuario.getNombre_apellido());
			pt.setString(2, usuario.getDni());
			pt.setString(3, usuario.getCodigo());
			pt.setInt(4, usuario.getId());
			
			pt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
}
