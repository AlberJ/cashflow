package br.edu.ifpb.pweb2.cashflow.command;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.pweb2.cashflow.controller.LoginController;
import br.edu.ifpb.pweb2.cashflow.controller.Resultado;
import br.edu.ifpb.pweb2.cashflow.controller.UsuarioController;
import br.edu.ifpb.pweb2.cashflow.dao.PersistenceUtil;
import br.edu.ifpb.pweb2.cashflow.model.Usuario;

public class LoginComando implements ICommand {
	@Override
	public Resultado execute(HttpServletRequest request, HttpServletResponse response) 
	{
		final String paginaSucesso = "usuario/lista.jsp"; // "controller.do?op=conusu";
		final String paginaErro = "login/login.jsp";
		HttpSession session = request.getSession();

		// Recupera a fábrica de entitymanagers e produz uma EM para o
		// controller
		EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
//		UsuarioController usuarioCtrl = new UsuarioController(em);
		
//		LoginController loginCtrl = new LoginController(PersistenceUtil.getCurrentEntityManager());
		LoginController loginCtrl = new LoginController(em);
		
		Resultado resultado = loginCtrl.isValido(request.getParameterMap());
		Usuario usuarioLogado = (Usuario) resultado.getModel();

		if (resultado.isErro()) {
			request.setAttribute("msgs", resultado.getMensagens());
			resultado.setProximaPagina(paginaErro);
			System.out.println("Erro: "+ resultado.getMensagens());
		} else {
			System.out.println("Usuario logado: "+usuarioLogado);
			session.setAttribute("usuario", usuarioLogado);
			resultado.setProximaPagina(paginaSucesso);

			// trata o lembrar
			String lembrar = request.getParameter("lembrar");
			if (lembrar != null) {
				Cookie c = new Cookie("loginCookie", usuarioLogado.getEmail());
				c.setMaxAge(-1); // REVER ESSE COMANDO Q DE CABEÇA NÃO LEMBRO,
									// APENAS DEDUZO
				response.addCookie(c);
			} else { // VERIFICA SE HÁ COOKIE E NULLA SEU VALOR
				for (Cookie cookie : request.getCookies()) {
					if (cookie.getName().equals("loginCookie")) {
						cookie.setValue(null);
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
			}
		}

		return resultado;
	}
}
