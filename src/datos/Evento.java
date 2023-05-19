package datos;

import java.time.LocalDateTime;
import java.util.Objects;

public class Evento {
	
	private int idEvento;
	private String descripcion;
	private Dispositivo dispositivo;
	private LocalDateTime fechaHora;
	
	public Evento () {}

	public Evento(String descripcion, Dispositivo dispositivo, LocalDateTime fechaHora) {
		super();
		this.descripcion = descripcion;
		this.dispositivo = dispositivo;
		this.fechaHora = fechaHora;
	}
	
	

	public int getIdEvento() {
		return idEvento;
	}

	protected void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEvento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return idEvento == other.idEvento;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", descripcion=" + descripcion + ", dispositivo=" + dispositivo
				+ ", fechaHora=" + fechaHora + "]\n";
	}

}
