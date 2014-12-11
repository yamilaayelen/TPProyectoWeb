package com.javarevolutions.jsps.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javarevolutions.jsps.servlets.vo.VOLogin;

/**
 * Servlet implementation class UsuariosServlet
 */
@WebServlet("/usuarios/adminUsuarios.servlet")
public class UsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuariosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		System.out.println("Accion: " + accion);
		List<VOLogin> lista = (List<VOLogin>)request.getSession().getAttribute("listaUsuario");
		VOLogin vo = new VOLogin();
		vo.setUsuario(request.getParameter("usuario"));
		vo.setPassword(request.getParameter("password"));
		vo.setNombre(request.getParameter("nombre"));
		vo.setEdad(Integer.parseInt(request.getParameter("edad")));
		if(accion.equals("guardar"))
		{
			lista.add(vo);
		}
		else if (accion.equals("actualizar"))
		{
			for(VOLogin obj: lista)
			{
				if(obj.getUsuario().equals(vo.getUsuario()))
						{
							obj.setPassword(vo.getPassword());
							obj.setEdad(vo.getEdad());
							obj.setNombre(vo.getNombre());
						}
			}
		}
		else if (accion.equals("borrar"))
		{
			for(VOLogin obj: lista)
			{
				if(obj.getUsuario().equals(vo.getUsuario()))
						{
							lista.remove(obj);
						}
			}
		}
		response.sendRedirect("usuarios.jsp");
		
	}
	
}
