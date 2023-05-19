package negocio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.EventoDao;
import datos.Dispositivo;
import datos.Evento;

public class EventoAbm {
	
	private static EventoAbm instancia=null;// Patrón Singleton
	protected EventoAbm() {}
	public static EventoAbm getInstance(){
		
	if(instancia==null)
	instancia=new EventoAbm();
	return instancia;
	}

	public Evento traer(Dispositivo dispositivo, LocalDateTime fechaHora) {
		return EventoDao.getInstance().traer(dispositivo, fechaHora);
	}
	
	public List<Evento> traer() {
		return EventoDao.getInstance().traer();
	}
	
	public int agregar(String descripcion, Dispositivo dispositivo, LocalDateTime fechaHora) throws Exception {
		Evento aux = traer(dispositivo, fechaHora);
		if(aux != null) {
			throw new Exception ("Ya existe un evento para ese dispositivo en la misma fecha y hora");
		}
		return EventoDao.getInstance().agregar(new Evento(descripcion, dispositivo, fechaHora));
	}
	
	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta){
		return EventoDao.getInstance().traer(fechaHoraDesde, fechaHoraHasta);
	}
	
//	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta, Dispositivo dispositivo){
//		List<Evento> aux = EventoDao.getInstance().traer(fechaHoraDesde, fechaHoraHasta);
//		List<Evento> aDevolver = new ArrayList<Evento>();
//		for(Evento e : aux) {
//			if(e.)
//		}
//		return aux;
//	}
	
	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta, Dispositivo d){
		return EventoDao.getInstance().traer(fechaHoraDesde, fechaHoraHasta, d);
	}
}
