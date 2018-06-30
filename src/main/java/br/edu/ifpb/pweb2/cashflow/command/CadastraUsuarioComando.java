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
		
		// Recupera a fábrica de entitymanagers e produz uma EM para o controller
		EntityManagerFactory emf = (EntityManagerFactory)
		request.getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		UsuarioController usuarioCtrl =  new UsuarioController(em);
		
//		MANDA APENAS O REQUEST POIS O USUARIO ERA O USUARIO DA SESSÃO PARA CADASTRAR O CONTATO A ELE
		Resultado resultado = usuarioCtrl.cadastre(request.getParameterMap());
		System.out.println("Resultado: "+resultado);
		if (!resultado.isErro()) {
			System.out.println("Entrou em Não Erro de Resultado");
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