package classes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Authservlet
 */
@WebServlet("/Authservlet")
public class Authservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String login=request.getParameter("login");
		String mdp=request.getParameter("mdp");
		HttpSession session=request.getSession();
		session.setAttribute("erreur",null);
		User u=new User(login, mdp);
		if(u.authentifier()==null)
		{
			session.setAttribute("erreur","compte non reconnu");
			response.sendRedirect("index.jsp");
			
			
		}
		else
		{
			User result=u.authentifier();
			session.setAttribute("login",result.getLogin());
			session.setAttribute("id",result.getId());
			session.setAttribute("nom",result.getNom());
			response.sendRedirect("Profile.jsp");

		}
	}

}
