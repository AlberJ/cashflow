package br.edu.ifpb.pweb2.cashflow.command;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.pweb2.cashflow.controller.Resultado;
import br.edu.ifpb.pweb2.cashflow.controller.UsuarioController;
import br.edu.ifpb.pweb2.cashflow.dao.PersistenceUtil;
import br.edu.ifpb.pweb2.cashflow.model.Usuario;

public class CadastraUsuarioComando implements ICommand {
	
	@Override
	public Resultado execute(HttpServletRequest request, HttpServletResponse response) {
		final String paginaSucesso = "controller.do?op=conusu";
		final String paginaErro = "usuario/cadastro.jsp";
		
		System.out.println("Chegou no CadastroUsuarioComando, dentro do metodo execute.");
		
		// Recupera a fábrica de entitymanagers e produz uma EM para o controller
		EntityManagerFactory emf = (EntityManagerFactory)
		request.getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		UsuarioController usuarioCtrl =  new UsuarioController(em);
		
//		UsuarioController usuarioCtrl = 
//				new UsuarioController(PersistenceUtil.getCurrentEntityManager());
		
//		HttpSession session = request.getSession();
//		Usuario usuario = (Usuario) session.getAttribute("email"); //ESSA LINHA "EQUIVALE" A DE PEGAR A SESSÃO PARA CADASTRAR O CONTATO AO USUARIO LOGADO
//		System.out.println("Usuario em cadastro de usuario: "+email);
		
//		MANDA APENAS O REQUEST POIS O USUARIO ERA O USUARIO DA SESSÃO PARA CADASTRAR O CONTATO A ELE
		Resultado resultado = usuarioCtrl.cadastre(request.getParameterMap());
		if (!resultado.isErro()) {
			resultado.setProximaPagina(paginaSucesso);
			resultado.setRedirect(true);
		} else {
			request.setAttribute("usuario", (Usuario) resultado.getModel());
			request.setAttribute("_msg", resultado.getMensagens());
			resultado.setProximaPagina(paginaErro);
		}
		return resultado;
	}
}