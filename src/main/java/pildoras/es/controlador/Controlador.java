package pildoras.es.controlador; import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pildoras.es.dao.ClienteDAO;
import pildoras.es.entity.Cliente;

@Controller
@RequestMapping("/cliente")
public class Controlador {
	
	@Autowired
	private ClienteDAO clienteDAO;

	@RequestMapping("/lista")
	public String listaClientes(Model elModelo) {
		// Obtener los clientes desde el DAO
		List<Cliente> losClientes = clienteDAO.getClientes();
		elModelo.addAttribute("clientes", losClientes);
		
		// Agregar los clientes al modelo
		return "lista-clientes";
	}
	
	@RequestMapping("/muestraFormularioAgregar")
	public String muestraFormulario(Model elModelo) {

		// Bind de Cliente
		Cliente elCliente = new Cliente();
		elModelo.addAttribute("cliente", elCliente);
		
		return "formularioClientes";
	}
	
	@PostMapping("/insertarCliente")
	public String insertarCliente(@ModelAttribute("cliente") Cliente elCliente) {
		// Insertar cliente en BBDD
		clienteDAO.insertarCliente(elCliente);
		 

		return "redirect:/cliente/lista";
	}
	
	@GetMapping("/muestraFormularioActualizar")
	public String muestraFormularioActualizar(@RequestParam("clienteId") int Id, Model elModelo) {
		// Obtener el cliente
		Cliente elCliente = clienteDAO.getCliente(Id); 
		
		// Establecer el cliente como atributo del modelo
		elModelo.addAttribute("cliente", elCliente);

		// Enviar al formulario
		return "formularioCliente";
	}

	@GetMapping("/eliminar")
	public String eliminaCliente(@RequestParam("clienteId") int Id, Model elModelo) {
		// eliminar el cliente
		clienteDAO.eliminaCliente(Id); 
		

		// Redireccion a lista cliente
		return "redirect:/cliente/lista";
	}
}
