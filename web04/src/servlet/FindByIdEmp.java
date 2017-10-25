package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDAO;
import entity.Emp;

public class FindByIdEmp  extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html charset=utf-8");
		EmpDAO empDAO=new EmpDAO();
		try {
			Emp emp=empDAO.findByid(Integer.parseInt(id));
			req.setAttribute("emp", emp); 
			req.getRequestDispatcher("/ModifyEmp.jsp").forward(req, resp);
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
			throw new ServletException(e);
		} catch (SQLException e) {
		
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
