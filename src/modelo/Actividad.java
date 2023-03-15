package modelo;

import java.util.Date;

public class Actividad {
	
	int id;
	String nombre;
	Date fecha_inicio;
	String dias_semana;
	int horas;
	int max_participantes;
	double precio;
	
	public Actividad(int id, String nombre, Date fecha_inicio, String dias_semana, int horas, int max_participantes,
			double precio) {
		this.id = id;
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.dias_semana = dias_semana;
		this.horas = horas;
		this.max_participantes = max_participantes;
		this.precio = precio;
	}

	public Actividad() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getDias_semana() {
		return dias_semana;
	}

	public void setDias_semana(String dias_semana) {
		this.dias_semana = dias_semana;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMax_participantes() {
		return max_participantes;
	}

	public void setMax_participantes(int max_participantes) {
		this.max_participantes = max_participantes;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Actividad: id=" + id + ", nombre=" + nombre + ", fecha_inicio=" + fecha_inicio + ", dias_semana="
				+ dias_semana + ", horas=" + horas + ", max_participantes=" + max_participantes + ", precio=" + precio;
	}
	
	
}
