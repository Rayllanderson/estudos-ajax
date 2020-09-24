package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.User;

@WebFilter(urlPatterns = {"/acesso-liberado.jsp"})
public class Autenticacao implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }
    
    //intercepta todas as requisições
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
	//executa as ações d request e response
	
	
	HttpServletRequest req = (HttpServletRequest) request; //convertendo o request 
	HttpSession session = req.getSession(); //pegando a seção
	User user = (User) session.getAttribute("usuario");
	if(user == null) {
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
	    dispatcher.forward(request, response);
	    return;
	}
	
	chain.doFilter(request, response);
//	System.out.println("interceptando");
    }
    
    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
