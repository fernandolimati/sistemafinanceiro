package com.fatesg.sistemafinanceiro.bean;


import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import com.fatesg.sistemafinanceiro.dao.ClienteDAO;
import com.fatesg.sistemafinanceiro.entity.Cliente;
import com.fatesg.sistemafinanceiro.util.HashGenerator;

@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteBean {
	
	public static List<Cliente> clientes = new ArrayList<>();
	private Cliente cliente = new Cliente();
	private Cliente selectedCliente;
	
	public ClienteBean() {
		try {
			this.listAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void save(ActionEvent actionEvent) throws Exception {
		if (cliente.getNome().isEmpty() || cliente.getSenha().isEmpty()
				|| cliente.getSenha().isEmpty()) {
			addMessage("Todos os campos devem ser preenchidos!!");
		}else {
			String hash = HashGenerator.hashGenerator(cliente.getSenha(), "SHA-256");
			cliente.setSenha(hash);
			ClienteDAO dao = new ClienteDAO();
			dao.save(cliente);
			addMessage("Cadastrado com sucesso!!");
			this.listAll();
			System.out.println("SENHA HASH: "+HashGenerator.hashGenerator(cliente.getSenha(), "MD5"));
			
		}
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public void listAll() throws Exception {
		ClienteDAO dao = new ClienteDAO();
		clientes = dao.listAll(Cliente.class);
	}
	
	public void findById() throws Exception {
		ClienteDAO dao = new ClienteDAO();
		cliente = dao.findById(Cliente.class, this.selectedCliente.getId());
	}
	
	public void delete() throws Exception {
		ClienteDAO dao = new ClienteDAO();
		dao.delete(Cliente.class, this.selectedCliente.getId());
		this.listAll();
	}
	
	public void edit() throws Exception {
		
	}
	
	public void onRowSelect(SelectEvent event) throws Exception {
		this.selectedCliente = ((Cliente) event.getObject());
		cliente.setNome(this.selectedCliente.getNome());
	}
	
	
	
	
	public Cliente getSelectedCliente() {
		return selectedCliente;
	}
	public void setSelectedCliente(Cliente selectedCliente) {
		this.selectedCliente = selectedCliente;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
