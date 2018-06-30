package br.edu.ifpb.pweb2.cashflow.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.edu.ifpb.pweb2.cashflow.dao.UsuarioDAO;
import br.edu.ifpb.pweb2.cashflow.model.Movimentacao;
import br.edu.ifpb.pweb2.cashflow.model.Usuario;

public class UsuarioController {
	private List<String> mensagensErro;
	private EntityManager entityManager;
	
	public UsuarioController(EntityManager em) {
		this.entityManager = em;
	}
	
	public Resultado cadastre(Map<String, String[]> parametros) {
		Resultado resultado = new Resultado();
		
//		EntityManagerFactory emf = 
//				(EntityManagerFactory) request.getServletContext().getAttribute("emf");
		Usuario usuario = null;
		if((usuario = fromParametros(parametros)) != null){
			UsuarioDAO dao = new UsuarioDAO(entityManager);			
			dao.beginTransaction(); //ATÉ AQUI ESTÁ OK!
			System.out.println("Antes do INSERT no UsuarioControll");
			dao.insert(usuario);
			System.out.println("Usuario depois da persistencia no UsuarioControll: "+usuario);
			dao.commit();
			System.out.println("Depois do commit.");
			resultado.setErro(false); 
			String m = "Usuario salvo com sucesso!";
			resultado.addMensagens(m);
		}else{
			resultado.setErro(true);
			resultado.setMensagens(this.mensagensErro);
		}
		System.out.println("Resultado: "+resultado);	
		return resultado;
		
	}
	
	private Usuario fromParametros(Map<String, String[]>parametros) 
	{
		String[] email = parametros.get("email");
		String[] login = parametros.get("login");
		String[] senha = parametros.get("password");
		
		Usuario u = new Usuario();
		
		if (email == null || email.length == 0 || email[0].isEmpty()) {
			this.mensagensErro.add("Email é campo obrigatório!");
		} else {
			u.setEmail(email[0]);
		}
		
		if (login == null || login.length == 0 || login[0].isEmpty()) {
			this.mensagensErro.add("Login é campo obrigatório!");
		} else {
			u.setLoginl(login[0]);
		}
		
		if (senha == null || senha.length == 0 || senha[0].isEmpty()) {
			this.mensagensErro.add("Senha é campo obrigatório!");
		} else {
			u.setSenha(senha[0]);
		}
		
		return u;
	}

	public Resultado setUsuarioSessao(Usuario u)
	{
		Resultado resultado = new Resultado();
		
		if (u != null){
			
		}
		
		return resultado;
	}
	
}
