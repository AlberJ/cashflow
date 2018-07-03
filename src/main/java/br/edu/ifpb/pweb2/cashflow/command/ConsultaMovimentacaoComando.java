package br.edu.ifpb.pweb2.cashflow.command;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.pweb2.cashflow.controller.MovimentacaoController;
import br.edu.ifpb.pweb2.cashflow.controller.Resultado;
import br.edu.ifpb.pweb2.cashflow.dao.PersistenceUtil;
import br.edu.ifpb.pweb2.cashflow.model.Movimentacao;
import br.edu.ifpb.pweb2.cashflow.model.Usuario;

public class ConsultaMovimentacaoComando implements ICommand {

	@Override
	public Resultado execute(HttpServletRequest request, HttpServletResponse response) {
		EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		// MovimentacaoController movimentacaoCtrl = new MovimentacaoController(PersistenceUtil.getCurrentEntityManager());
		MovimentacaoController movimentacaoCtrl = new MovimentacaoController(em);
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		List<Movimentacao> movimentacoes = movimentacaoCtrl.consulte(usuario);

		Resultado resultado = new Resultado();
		request.setAttribute("movimentacoes", movimentacoes);
		request.setAttribute("saldo", usuario.getSaldo());

//		resultado.setProximaPagina("usuario/home.jsp");
		resultado.setProximaPagina("movimentacao/lista.jsp");
		return resultado;
	}

}