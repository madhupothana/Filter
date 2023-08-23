package filterpack;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Filter1
 */
@WebFilter("/serv1")
public class Filter1 extends HttpFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hr=(HttpServletRequest)request;
		HttpSession s= hr.getSession();
		HttpServletResponse hs=(HttpServletResponse)response;
		String key2=hs.getHeader("key");
		String key1=(String) hr.getAttribute("key");
		System.out.println(key1+"     "+key2);
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		if(!key1.equals(key2)) {
			rd.forward(request, response);
		}
		else {
			chain.doFilter(request, response);
		}
		
	}

}
