package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActividadModelo extends Conector{
	
	
		PreparedStatement pt;
		String sentencia;
		
		
		public boolean insertarActividad(Actividad actividad)  {
			sentencia="INSERT INTO actividades (nombre,fecha_inicio,dias_semana,horas,max_participantes,precio) VALUES(?,?,?,?,?,?)";
			getConexion();
			try {
				pt=super.getConexion().prepareStatement(sentencia);
				
				pt.setString(1, actividad.getNombre());
				pt.setDate(2, new Date(actividad.getFecha_inicio().getTime()));
				pt.setString(3, actividad.getDias_semana());
				pt.setInt(4, actividad.getHoras());
				pt.setInt(5, actividad.getMax_participantes());
				pt.setDouble(6, actividad.getPrecio());
				
				pt.execute();
				return true;
			} catch (SQLException e) {
				
				e.printStackTrace();
				return false;
			}
		}
		
		public boolean eliminarActividad(Actividad actividad) {
			sentencia="DELETE FROM actividades WHERE id=?";
			
			try {
				pt=getConexion().prepareStatement(sentencia);
				pt.setInt(1, actividad.getId());
				
				pt.execute();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}		
		}
		
		
		public boolean modificarActividad(Actividad actividad) {
			sentencia="UPDATE actividades SET nombre=?,fecha_inicio=?,dias_semana=?,horas=?,max_participantes=?,precio=?";
			
			try {
				pt=getConexion().prepareStatement(sentencia);
				
				pt.setString(1, actividad.getNombre());
				pt.setDate(2, new Date (actividad.getFecha_inicio().getTime()));
				pt.setString(3, actividad.getDias_semana());
				pt.setInt(4, actividad.getHoras());
				pt.setInt(5, actividad.getMax_participantes());
				pt.setDouble(6, actividad.getPrecio());
				
				pt.executeUpdate();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
		
		public Actividad getActividad(int id) {
			sentencia="SELECT * FROM actividades WHERE id=?";
			Actividad actividad = new Actividad();
			try {
				pt=getConexion().prepareStatement(sentencia);
				
				pt.setInt(1, id);
				try {
					ResultSet result=pt.executeQuery();
					result.next();
					
					actividad.setId(result.getInt("id"));
					actividad.setNombre(result.getString("nombre"));
					actividad.setFecha_inicio((result.getDate("fecha_inicio")));
					actividad.setDias_semana(result.getString("dias_semana"));
					actividad.setHoras(result.getInt("horas"));
					actividad.setMax_participantes(result.getInt("max_participantes"));
					actividad.setPrecio(result.getDouble("precio"));
					
				}catch(Exception e) {
					
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
			return actividad;
		}
				
		public ArrayList<Actividad> getActividades(){
			ArrayList<Actividad> actividades=new ArrayList<Actividad>();
			sentencia="SELECT * FROM actividades";
			
			try {
				pt=getConexion().prepareStatement(sentencia);
				
				ResultSet result=pt.executeQuery();
				
				while(result.next()) {
					Actividad actividad = new Actividad();
					
					actividad.setId(result.getInt("id"));
					actividad.setNombre(result.getString("nombre"));
					actividad.setFecha_inicio(result.getDate("fecha_inicio"));
					actividad.setDias_semana(result.getString("dias_semana"));
					actividad.setHoras(result.getInt("horas"));
					actividad.setMax_participantes(result.getInt("max_participantes"));
					actividad.setPrecio(result.getDouble("precio"));
					
					actividades.add(actividad);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return actividades;
		}
		


	}


