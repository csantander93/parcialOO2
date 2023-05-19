package Funciones;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Funciones {
	
	public static boolean esDiaHabil(LocalDate fecha) {//DIA HABIL
		boolean valido = false;
		int n = fecha.getDayOfWeek().getValue();
		if((n>=1)&&(n<=5)) {
			valido = true;
		}
		return valido;
	}

	public static boolean esBisiesto(int anio) {//ES BISIESTO
		boolean esBisiesto = false;
		if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
			esBisiesto = true;
		}
		return esBisiesto;
	}
	public static boolean esFechaValida(int dia, int mes, int anio){//ES FECHA VALIDA
		boolean valido = false;
		int cdias = 0;
		if (0 < anio && anio < 3000) {
			if (1 <= mes && mes <= 12) {
				if (mes == 1 || mes == 3 | mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
					cdias = 31;
				}
				if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
					cdias = 30;
				}
				if (mes == 2) {
					if (esBisiesto(anio) == true) {
						cdias = 29;
					} else {
						cdias = 28;
					}
				}
				if (1 <= dia && dia <= cdias) {
					valido = true;
				}
			}
		}
		return valido;
	}
	public static String traerFechaCorta(LocalDate fecha) {//FECHA CORTA
		String mes = String.valueOf(fecha.getMonthValue());
		String anio = String.valueOf(fecha.getYear());
		String dia = String.valueOf(fecha.getDayOfMonth());
		return dia + "/"  + mes + "/" + anio;
	}
	public static String traerHoraCorta(LocalTime hora) {
		String horas = String.valueOf(hora.getHour());
		String minutos = String.valueOf(hora.getMinute());
		return horas + ":" + minutos;
	}
	public static String traerDiaDeLaSemana(LocalDate fecha) {
		return String.valueOf(fecha.getDayOfWeek().getValue());
	}
	public static String traerMesEnLetras(LocalDate fecha) {
		return fecha.getMonth().name();
	}
	public static String traerFechaLarga(LocalDate fecha) {
		String diaNom = fecha.getDayOfWeek().name();
		int diaNum = fecha.getDayOfWeek().getValue();
		String mes = fecha.getMonth().name();
		String anio = String.valueOf(fecha.getYear());
		return diaNom+" "+diaNum+" de "+mes+" de "+anio;
	}
	public static int traerCantDiasDeUnMes(int anio, int mes) {
		int dias=0;
		if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			dias =31; 
		}
		
		if ((mes == 4 || mes == 6 || mes == 9 || mes == 11)) {
			dias=30;
		}
		
		if (esBisiesto(anio) && mes == 2) {
			dias=29;}
		
		if (esBisiesto(anio)== false && mes == 2) {
			dias=28;
		}
		return dias;
	}
	public static double aproximar2Decimal(double valor) {
		BigDecimal decimal = new BigDecimal(valor);
		decimal = decimal.setScale(2, RoundingMode.HALF_UP);
		
		return decimal.doubleValue();
	}
	public static boolean esNumero(char c) {
		boolean es = false;
		if(!esLetra(c)) {
			es = true; 
		}
		
		return es;
	}
	public static boolean esLetra(char c) {
		return Character.isLetter(c);
	}
	public static boolean esCadenaNros(String cadena) {
		return (cadena.matches("[0-9]+"));
	}
	public static boolean esCadenaLetras(String cadena) {
		return (cadena.matches("[a-zA-Z]+"));
	}
	public static boolean esPrimo(int numero) {
		int aux =0;
		for(int i=1;i<=numero;i++) {
			 if(numero % i == 0) {
				 aux++;
			 }
		}
		return aux == 2;	
	}
	public static boolean esPrimoMellizo(int n1, int n2) {
		boolean mellizo = false;
		if(esPrimo(n1) && esPrimo(n2)) {
			if((n1 > n2) && (n1 - n2 == 2)) {
				mellizo = true;
				
			}else if(n2 > n1 && n2 - n1 == 2) {
				mellizo = true;
			}
		}
		return mellizo;
	}

}
