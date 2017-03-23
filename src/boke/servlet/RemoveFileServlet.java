package boke.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveFileServlet
 */
@WebServlet("/RemoveFileServlet")
public class RemoveFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rname=new String(request.getParameter("rname").getBytes("ISO-8859-1"),"UTF-8"); 
		ServletContext context = request.getServletContext();
		String filePath = context.getInitParameter("file-upload");
		System.out.println(filePath+rname);
		File file=new File(filePath+rname);
		if(file.exists()){
			file.delete();
		}else{
			response.getWriter().write("É¾³ýÊ§°Ü");
		}
		System.out.println("zou");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
