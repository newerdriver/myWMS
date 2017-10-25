package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDAO;
import entity.Emp;

public class ModifyEmpServlet  extends HttpServlet{

		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html charset=utf-8");
			String id=req.getParameter("id");
			String age=req.getParameter("age");
			String salary=req.getParameter("salary");
			String name=req.getParameter("name");
			Emp emp=new Emp();
			emp.setAge(Integer.parseInt(age));
			emp.setId(Integer.parseInt(id));
			emp.setName(name);
			emp.setSalary(Double.parseDouble(salary));
			EmpDAO empDAO=new EmpDAO();
			try {
				empDAO.ModifyEmp(emp);
				resp.sendRedirect(req.getContextPath()+"/list");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
}
