package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import negocio.DispositivoAbm;
import negocio.EventoAbm;

public class TestGeneral {

	public static void main(String[] args) {
		System.out.println("TEST1");
		System.out.println(DispositivoAbm.getInstance().traer());
		System.out.println("TEST2");
		//System.out.println(DispositivoAbm.getInstance().traer("cortina pieza"));
		LocalDate fecha = LocalDate.of(2023, 4, 3);
		LocalTime hora = LocalTime.of(9, 10);
		LocalDateTime fechaHora = LocalDateTime.of(fecha, hora);
		try {
			int ultimoId = EventoAbm.getInstance().agregar("Apertura de la cortina", DispositivoAbm.getInstance().traer("cortina pieza"), fechaHora);
		}catch(Exception e) {
			System.out.println(e);	
		}
		fecha = LocalDate.of(2023, 4, 3);
		hora = LocalTime.of(19, 05);
		fechaHora = LocalDateTime.of(fecha, hora);
		try {
			int ultimoId = EventoAbm.getInstance().agregar("Cierre de la cortina", DispositivoAbm.getInstance().traer("cortina pieza"), fechaHora);
		}catch(Exception e) {
			System.out.println(e);	
		}
		fecha = LocalDate.of(2023, 4, 4);
		hora = LocalTime.of(9, 00);
		fechaHora = LocalDateTime.of(fecha, hora);
		try {
			int ultimoId = EventoAbm.getInstance().agregar("Apertura de la cortina", DispositivoAbm.getInstance().traer("cortina pieza"), fechaHora);
		}catch(Exception e) {
			System.out.println(e);	
		}
		fecha = LocalDate.of(2023, 4, 4);
		hora = LocalTime.of(19, 01);
		fechaHora = LocalDateTime.of(fecha, hora);
		try {
			int ultimoId = EventoAbm.getInstance().agregar("Cierre de la cortina", DispositivoAbm.getInstance().traer("cortina pieza"), fechaHora);
		}catch(Exception e) {
			System.out.println(e);	
		}
		
		fecha = LocalDate.of(2023, 4, 4);
		hora = LocalTime.of(11, 30);
		fechaHora = LocalDateTime.of(fecha, hora);
		try {
			int ultimoId = EventoAbm.getInstance().agregar("23 grados. Prender aire acondicionado", DispositivoAbm.getInstance().traer("temp pieza"), fechaHora);
		}catch(Exception e) {
			System.out.println(e);	
		}
		fecha = LocalDate.of(2023, 4, 4);
		hora = LocalTime.of(12, 00);
		fechaHora = LocalDateTime.of(fecha, hora);
		try {
			int ultimoId = EventoAbm.getInstance().agregar("20 grados. Apagar aire acondicionado", DispositivoAbm.getInstance().traer("temp pieza"), fechaHora);
		}catch(Exception e) {
			System.out.println(e);	
		}
		fecha = LocalDate.of(2023, 4, 5);
		hora = LocalTime.of(9, 05);
		fechaHora = LocalDateTime.of(fecha, hora);
		try {
			int ultimoId = EventoAbm.getInstance().agregar("Apertura de la cortina", DispositivoAbm.getInstance().traer("cortina pieza"), fechaHora);
		}catch(Exception e) {
			System.out.println(e);	
		}
		fecha = LocalDate.of(2023, 4, 5);
		hora = LocalTime.of(19, 05);
		fechaHora = LocalDateTime.of(fecha, hora);
		try {
			int ultimoId = EventoAbm.getInstance().agregar("Cierre de la cortina", DispositivoAbm.getInstance().traer("cortina pieza"), fechaHora);
		}catch(Exception e) {
			System.out.println(e);	
		}
		//A medida que fui agregando Eventos me di cuenta que cuando pide cerrar cortina se envia el dispositivo temp pieza por lo que lo cambie por el que correspondia 
		//segun la profe me dijo que probablemente era un error que lo cambie pero que lo deje comentado.
		LocalDate fechaDesde = LocalDate.of(2023, 4, 3);
		LocalTime horaDesde = LocalTime.of(12, 00);
		LocalDateTime fechaHoraDesde = LocalDateTime.of(fechaDesde, horaDesde);
		
		LocalDate fechaHasta = LocalDate.of(2023, 4, 5);
		LocalTime horaHasta = LocalTime.of(12, 00);
		LocalDateTime fechaHoraHasta = LocalDateTime.of(fechaHasta, horaHasta);
		
		System.out.println("CU3");
		System.out.println(EventoAbm.getInstance().traer(fechaHoraDesde, fechaHoraHasta));
		System.out.println("CU4");
		System.out.println(EventoAbm.getInstance().traer(fechaHoraDesde, fechaHoraHasta, DispositivoAbm.getInstance().traer("cortina pieza")));
		System.out.println("CU5");
		System.out.println(DispositivoAbm.getInstance().traerTodosLosDispositivosSensorCortinaVentana());
	}

}
