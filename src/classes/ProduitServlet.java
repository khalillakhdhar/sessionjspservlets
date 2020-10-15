package classes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet("/ProduitServlet")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Produit pr=new Produit();
		pr.setId(Integer.parseInt(request.getParameter("id")));
		pr.delete();
		response.sendRedirect("Produits.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		String titre=request.getParameter("t");
		String methode=request.getParameter("methode");
		String description=request.getParameter("d");
		double prix=Double.parseDouble(request.getParameter("p"));
		int quantite=Integer.parseInt(request.getParameter("q"));
		Produit pr=new Produit(quantite, titre, description, prix);
		
		if(methode.equals("inserer"))
		pr.create();
		else
		{
			pr.setId(Integer.parseInt(request.getParameter("id")));
			pr.update();
		}
	
		response.sendRedirect("Produits.jsp");
		


	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("put successfull ");
	}

}
