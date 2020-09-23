package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CapturarExcecoesServlet
 */
@WebServlet("/CapturarExcecao")
public class CapturarExcecoesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CapturarExcecoesServlet() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	try {
	    Integer.parseInt(request.getParameter("valorParam"));
	    response.setStatus(200); //200 ok!
	    response.getWriter().write("Processado com sucesso"); //setando resposta 
	}catch (NumberFormatException e) {
	    response.setStatus(500); //bad request, erro do servidor
	    response.getWriter().write("Erro ao processar: " + e.getMessage());
	}
    }

}
