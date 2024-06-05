package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component

public class Carrera {
	private String codigo;
	private String nombre;
	private Integer anos;
	private Boolean estado;
	
	public Carrera() {
		// TODO Auto-generated constructor stub
	}

	public Carrera(String codigo, String nombre, Integer anos, Boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.anos = anos;
		this.estado = estado;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAnos() {
		return anos;
	}

	public void setAnos(Integer anos) {
		this.anos = anos;
	}
 
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	
	
}
