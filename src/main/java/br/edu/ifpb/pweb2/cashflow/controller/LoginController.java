package br.edu.ifpb.pweb2.cashflow.controller;

import java.util.Map;

import javax.persistence.EntityManager;

import br.edu.ifpb.pweb2.cashflow.dao.UsuarioDAO;
import br.edu.ifpb.pweb2.cashflow.model.Usuario;

public class LoginController 
{
	private EntityManager entityManager;
	
	public LoginController(EntityManager entityManager) {
		this.entityManager = entityManager;
		System.out.println("Carregou LoginController."); 
	}
	
	public Resultado isValido(Map<String, String[]> parametros) {
		Resultado r = new Resultado();
		r.setErro(false);
		
		String login = parametros.get("login")[0];
		String senha = parametros.get("senha")[0];
		System.out.println("Carregou os parâmetros em isValido. login: "+login+", senha: "+senha); 
		
		
		UsuarioDAO udao = new UsuarioDAO(entityManager);
		Usuario user = udao.findByLogin(login);
		if (user != null) {
			if (user.getSenha().equals(senha)) {
				r.setModel(user);
			} else {
				r.setErro(true);
				r.addMensagens("Usuário ou senha inválido(a).");
			}
		} else {
			r.setErro(true);
			r.addMensagens("Usuário ou senha inválido(a).");
		}
		return r;
	}
}
