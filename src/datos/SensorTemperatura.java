package datos;

public class SensorTemperatura extends Dispositivo {
	
	private double valorMinimo;
	private double valorMaximo;
	
	public SensorTemperatura() {}

	public SensorTemperatura(String nombre, boolean activo, double valorMinimo, double valorMaximo) {
		super(nombre, activo);
		this.valorMinimo = valorMinimo;
		this.valorMaximo = valorMaximo;
	}

	public double getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public double getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(double valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	@Override
	public String toString() {
		return super.toString()+"SensorTemperatura [valorMinimo=" + valorMinimo + ", valorMaximo=" + valorMaximo + "]\n";
	}
	
	

}
