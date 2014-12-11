package com.javarevolutions.jsps.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javarevolutions.jsps.servlets.vo.VOLogin;

/**
 * Servlet implementation class LoginServlets
 */
@WebServlet("/loginWeb.jr")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario=request.getParameter("usuario");
		String password=request.getParameter("password");
		if(usuario.equals("yamila") && password.equals("yami"))
		{
			System.out.println("welcome.....");
			System.out.println("Usuario:" + usuario + "Password:" + password);
			
			VOLogin vo = new VOLogin();
			vo.setUsuario(usuario);
			vo.setPassword(password);
			vo.setNombre("Yamila JR");
			vo.setEdad(23);
			
			HttpSession session=request.getSession(true);
			ArrayList<VOLogin> lista = new ArrayList<VOLogin>();
			session.setAttribute("usuarioLogueado",vo);
			session.setAttribute("listaUsuario", lista);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
		else
		{
			System.out.println("Error en identificacion....");
			response.sendRedirect("login.html");
		}
	}

} 
