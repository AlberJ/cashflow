package br.edu.ifpb.pweb2.cashflow.command;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.pweb2.cashflow.controller.Resultado;
import br.edu.ifpb.pweb2.cashflow.controller.UsuarioController;
import br.edu.ifpb.pweb2.cashflow.model.Usuario;

public class CadastraUsuarioComando implements ICommand {

	@Override
	public Resultado execute(HttpServletRequest request, HttpServletResponse response) {
		final String paginaSucesso = "usuario/home.jsp"; //"controller.do?op=login";
		final String paginaErro = "usuario/cadastro.jsp";
		HttpSession session = request.getSession();
		
		EntityManagerFactory emf = (EntityManagerFactory)
		request.getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		UsuarioController usuarioCtrl = new UsuarioController(em);
		
		Resultado resultado = usuarioCtrl.cadastre(request.getParameterMap());

		if (!resultado.isErro()) {
			resultado.setProximaPagina(paginaSucesso);
			resultado.setRedirect(true);
			
//			 COLOCA O USUARIO NA SESSÃO
			System.out.println("Usuario para sessao: "+resultado.getModel());
			session.setAttribute("usuario", resultado.getModel());
			resultado.setProximaPagina(paginaSucesso);
		} else {
			request.setAttribute("usuario", (Usuario) resultado.getModel());
			request.setAttribute("_msg", resultado.getMensagens());
			resultado.setProximaPagina(paginaErro);
		}
		return resultado;
	}
}