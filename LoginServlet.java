package filterpack;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String eno=request.getParameter("eno");
		Random r=new Random();
		int t=r.nextInt(1000);
		Database db=new Database();
		HttpSession s=request.getSession();
		try {
			if(db.check(name, eno)) {
				response.setHeader("key",t+"");
				s.setAttribute("key", t+"");
				RequestDispatcher rd=request.getRequestDispatcher("serv1");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
