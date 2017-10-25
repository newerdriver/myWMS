package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDAO;
import entity.Emp;

public class ActionEmp extends HttpServlet{

	EmpDAO empDAO=new EmpDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String uri=req.getRequestURI();
		uri=uri.substring(uri.lastIndexOf('/')+1,uri.lastIndexOf('.'));
		
		try{
			if("del".equals(uri)){
				int id=Integer.parseInt(req.getParameter("id"));
				empDAO.DeleteEmp(id);
				resp.sendRedirect(req.getContextPath()+"/list.do");
			}else if("add".equals(uri)){
				Emp emp=new Emp();
				emp.setAge(Integer.parseInt(req.getParameter("age")));
				emp.setName(req.getParameter("name"));
				emp.setSalary(Double.parseDouble(req.getParameter("salary")));
				empDAO.InsertEmp(emp);
				resp.sendRedirect(req.getContextPath()+"/list.do");
			}else if("list".equals(uri)){
				List<Emp> emps= empDAO.SelectAll();
				req.setAttribute("emps", emps);
				req.getRequestDispatcher("WEB-INF/list.jsp").forward(req, resp);
			}else if("modify".equals(uri)){
				Emp emp=new Emp();
				emp.setId(Integer.parseInt(req.getParameter("id").trim()));
				emp.setSalary(Double.parseDouble(req.getParameter("salary")));
				emp.setAge(Integer.parseInt(req.getParameter("age")));
				emp.setName(req.getParameter("name"));
				empDAO.ModifyEmp(emp);
				resp.sendRedirect(req.getContextPath()+"/list.do");
			}else if("find".equals(uri)){
				int id=Integer.parseInt(req.getParameter("id"));
				Emp emp=empDAO.findByid(id);
				req.setAttribute("emp", emp);
				req.getRequestDispatcher("/ModifyEmp.jsp").forward(req, resp);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}
}
