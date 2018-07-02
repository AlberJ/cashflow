package br.edu.ifpb.pweb2.cashflow.command;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.pweb2.cashflow.controller.MovimentacaoController;
import br.edu.ifpb.pweb2.cashflow.controller.Resultado;
import br.edu.ifpb.pweb2.cashflow.model.Movimentacao;
import br.edu.ifpb.pweb2.cashflow.model.Usuario;

public class CadastraMovimentacaoComando implements ICommand {

	@Override
	public Resultado execute(HttpServletRequest request, HttpServletResponse response) {
		final String paginaSucesso = "usuario/home.jsp";
		final String paginaErro = "controller.do?op=conmov";
		
		EntityManagerFactory emf = (EntityManagerFactory)
		request.getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		MovimentacaoController movimentacaoCtrl = new MovimentacaoController(em);
		
//		PEGA O USUARIO DA SESSAÃO
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		Resultado resultado = movimentacaoCtrl.cadastre(usuario, request.getParameterMap());
		if (!resultado.isErro()) {
			resultado.setProximaPagina(paginaSucesso);
			resultado.setRedirect(true);
			request.setAttribute("usuario", usuario); // TENTATIVA VÃ DE Q OS VALORES FOSSE ATUALIZADOS
		} else {
			request.setAttribute("movimentacao", (Movimentacao) resultado.getModel());
			request.setAttribute("_msg", resultado.getMensagens());
			resultado.setProximaPagina(paginaErro);
		}
		return resultado;
	}

}