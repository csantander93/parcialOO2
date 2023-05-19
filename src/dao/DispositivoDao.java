package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Dispositivo;

public class DispositivoDao {

	private static Session session;
	private Transaction tx;
	private static DispositivoDao instancia=null; // Patrón Singleton
	protected DispositivoDao() {}
	public static DispositivoDao getInstance(){
		if(instancia==null)
			instancia=new DispositivoDao();
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
	
	public Dispositivo traer(String nombre){
		Dispositivo objeto = null;
		try {
		iniciaOperacion();
		objeto = (Dispositivo) session.createQuery("from Dispositivo d where d.nombre ='"+nombre+"'").uniqueResult();
		} finally {
		session.close();
		}
		return objeto;
		}
	
	public List<Dispositivo> traer(){
		List<Dispositivo>  lista = null;
		try {
		iniciaOperacion();
		lista = session.createQuery("from Dispositivo d").list();
		} finally {
		session.close();
		}
		return lista;
		}
	
	public List<Dispositivo> traerTodosLosDispositivosSensorCortinaVentana(){
		List<Dispositivo>  lista = null;
		try {
		iniciaOperacion();
		lista = session.createQuery("from SensorCortinaVentana").list();
		} finally {
		session.close();
		}
		return lista;
		}

}
