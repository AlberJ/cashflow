package br.edu.ifpb.pweb2.cashflow.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.pweb2.cashflow.controller.Resultado;

public class LogoutComando implements ICommand 
{
	@Override
	public Resultado execute(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("Entrou no LogoutComando.");
		request.getSession().invalidate();
		Resultado resultado = new Resultado();
		resultado.setErro(false);
		resultado.setProximaPagina("login/login.jsp");
		resultado.setRedirect(true);
		return resultado;
	}
}
