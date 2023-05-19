package datos;

import java.time.LocalTime;

public class SensorCortinaVentana extends Dispositivo{
	
	private LocalTime aperturaDesde;
	private LocalTime aperturaHasta;
	
	public SensorCortinaVentana () {}

	public SensorCortinaVentana(String nombre, boolean activo, LocalTime aperturaDesde, LocalTime aperturaHasta) {
		super(nombre, activo);
		this.aperturaDesde = aperturaDesde;
		this.aperturaHasta = aperturaHasta;
	}

	public LocalTime getAperturaDesde() {
		return aperturaDesde;
	}

	public void setAperturaDesde(LocalTime aperturaDesde) {
		this.aperturaDesde = aperturaDesde;
	}

	public LocalTime getAperturaHasta() {
		return aperturaHasta;
	}

	public void setAperturaHasta(LocalTime aperturaHasta) {
		this.aperturaHasta = aperturaHasta;
	}

	@Override
	public String toString() {
		return super.toString()+"SensorCortinaVentana [aperturaDesde=" + aperturaDesde + ", aperturaHasta=" + aperturaHasta + "]\n";
	}
	
	

}
