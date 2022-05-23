package pildoras.es.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pildoras.es.entity.Cliente;

@Repository
public class ClienteDAOClase implements ClienteDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Cliente> getClientes() {
		// Obtener la session
		Session miSession = sessionFactory.getCurrentSession();
		// Crear el query BBDD
		Query<Cliente> miQuery = miSession.createQuery("from cliente", Cliente.class);
		// Ejecutar el query 
		List<Cliente> clientes = miQuery.getResultList();
		// Devolver un resultado
		return clientes;
	}

}
