package br.edu.ifpb.pweb2.cashflow.command;

import java.util.List;

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
		MovimentacaoController movimentacaoCtrl = new MovimentacaoController(PersistenceUtil.getCurrentEntityManager());
		
		HttpSession session = request.getSession();
		Movimentacao movimentacao = (Movimentacao) session.getAttribute("movimentacao");
		List<Movimentacao> movimentacoes = movimentacaoCtrl.consulte(movimentacao);
		
		Usuario u = (Usuario) session.getAttribute("usuario");
		u.setMovimentacoes(movimentacaoCtrl.getMovimentacoes(u));
		
		Resultado resultado = new Resultado();
		request.setAttribute("usuario", u);
		request.setAttribute("movimentacao", movimentacoes);
		resultado.setProximaPagina("movimentacao/lista.jsp");
		return resultado;
	}

}