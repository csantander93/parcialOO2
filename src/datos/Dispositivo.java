package datos;

import java.util.Objects;

public abstract class Dispositivo {
	
	protected int idDispositivo;
	protected String nombre;
	protected boolean activo;
	
	public Dispositivo() {}

	public Dispositivo(String nombre, boolean activo) {
		super();
		this.nombre = nombre;
		this.activo = activo;
	}

	public int getIdDispositivo() {
		return idDispositivo;
	}

	protected void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDispositivo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dispositivo other = (Dispositivo) obj;
		return idDispositivo == other.idDispositivo;
	}

	@Override
	public String toString() {
		return "Dispositivo [idDispositivo=" + idDispositivo + ", nombre=" + nombre + ", activo=" + activo + "]";
	}
	
	
	

}
