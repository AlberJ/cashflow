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
	
	public Resultado cadastre(Map<String, String[]> parametros
											/*request.getParameterMap()*/) {
		Resultado resultado = new Resultado();
		
//		EntityManagerFactory emf = 
//				(EntityManagerFactory) request.getServletContext().getAttribute("emf");
		Usuario usuario = null;
		if((usuario = fromParametros(parametros)) != null){
			UsuarioDAO dao = new UsuarioDAO(entityManager);
			dao.beginTransaction();
			dao.insert(usuario);
			System.out.println("Usuario: "+usuario);
			dao.commit();
//			resultado.setErro(false); //FALTA IMPLEMENTAR O setErro()
			String m = "Usuario salvo com sucesso!";
//			resultado.addMensagem(m); // FALTA IMPLEMENTAR O addMensagem()
		}else{
//			FATA IMPLEMENTAR ESTES DOIS METODOS
//			resultado.setErro(true);
//			resultado.setMensagens(this.mensagensErro);
		}
		System.out.println("Resultado: "+resultado);	
		return resultado;
		
	}
	
	private Usuario fromParametros(Map<String, String[]>parametros)
	{
		String[] email = parametros.get("email");
		String[] login = parametros.get("login");
		String[] senha = parametros.get("senha");
	
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

}
