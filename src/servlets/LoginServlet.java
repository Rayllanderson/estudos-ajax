package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String login = request.getParameter("login");
	String password = request.getParameter("password");
	RequestDispatcher dispatcher = null;
	// verificação fake, sem banco de dados
	if (login.equals("ray") && password.equals("123")) {
	    dispatcher = request.getRequestDispatcher("acesso-liberado.jsp");
	    HttpSession httpSession= request.getSession();
	    httpSession.setAttribute("usuario", new entity.User(login, password));
	} else {
	    dispatcher = request.getRequestDispatcher("login.jsp");
	    request.setAttribute("error", "Login ou senha inválidos");
	}
	dispatcher.forward(request, response);
    }
}
