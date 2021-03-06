package pildoras.es.dao;

import java.util.List;

import pildoras.es.entity.Cliente;

public interface ClienteDAO {

	public List<Cliente> getClientes();

	public void insertarCliente(Cliente elCliente);

	public Cliente getCliente(int id);

	public void eliminaCliente(int id);
}
