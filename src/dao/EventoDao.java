package dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Dispositivo;
import datos.Evento;

public class EventoDao {
	
	private static Session session;
	private Transaction tx;
	private static EventoDao instancia=null; // Patrón Singleton
	protected EventoDao() {}
	public static EventoDao getInstance(){
		if(instancia==null)
			instancia=new EventoDao();
		return instancia;
	}
	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public Evento traer(Dispositivo dispositivo, LocalDateTime fechaHora){
		Evento objeto = null;
		try {
		iniciaOperacion();
		objeto = (Evento) session.createQuery("from Evento e inner join fetch e.dispositivo d where d.nombre ='"+dispositivo.getNombre()+"'and e.fechaHora='"+fechaHora+"'").uniqueResult();
		} finally {
		session.close();
		}
		return objeto;
		}
	
	public List<Evento> traer(){
		List<Evento> lista = null;
		try {
		iniciaOperacion();
		lista = session.createQuery("from Evento e ").list();
		for(Evento e : lista) {
			Hibernate.initialize(e.getDispositivo());
		}
		} finally {
		session.close();
		}
		return lista;
		}
	
	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta){
		List<Evento> lista = null;
		try {
		iniciaOperacion();
		lista = session.createQuery("from Evento e where e.fechaHora>='"+fechaHoraDesde+"'and e.fechaHora<='"+fechaHoraHasta+"'").list();
		for(Evento e : lista) {
			Hibernate.initialize(e.getDispositivo());
		}
		} finally {
		session.close();
		}
		return lista;
		}
	
	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta, Dispositivo d){
		List<Evento> lista = null;
		try {
		iniciaOperacion();
		lista = session.createQuery("from Evento e inner join fetch e.dispositivo d where e.fechaHora>='"+fechaHoraDesde+"'and e.fechaHora<='"+fechaHoraHasta+"'and d.idDispositivo="+d.getIdDispositivo()).list();
		for(Evento e : lista) {
			Hibernate.initialize(e.getDispositivo());
		}
		} finally {
		session.close();
		}
		return lista;
		}
	
	public int agregar(Evento objeto) {
		int id = 0;
		try {
		iniciaOperacion();
		id = Integer.parseInt(session.save(objeto).toString());
		tx.commit();
		} catch (HibernateException he) {
		manejaExcepcion(he);
		throw he;
		} finally {
		session.close();
		}
		return id;
		}

}
