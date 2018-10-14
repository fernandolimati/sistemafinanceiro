package br.com.software;

import java.util.ArrayList;
import java.util.List;

import com.fatesg.sistemafinanceiro.dao.ClienteDAO;
import com.fatesg.sistemafinanceiro.entity.Cliente;

public class TestandoJPA {

	public static void main(String[] args) throws Exception {
		
		Cliente cliente = new Cliente();
		
		//Deletar por id
//		ClienteDAO dao = new ClienteDAO();
//		dao.delete(Cliente.class, 3L);
		
		
		//Listar todos
//		List<Cliente> clientes = new ArrayList<Cliente>();
//		clientes = dao.listAll(Cliente.class);
//		
//		for (Cliente listaClientes : clientes) {
//			Long id = listaClientes.getId();
//			String nome = listaClientes.getNome();
//			String email = listaClientes.getEmail();
//			String senha = listaClientes.getSenha();
//			
//			System.out.println("Id: " + id);
//			System.out.println("Nome: " + nome);
//			System.out.println("Email: " + email);
//			System.out.println("Senha: " + senha);
//			System.out.println("=============================================");
//		}
		
	
	}

}
