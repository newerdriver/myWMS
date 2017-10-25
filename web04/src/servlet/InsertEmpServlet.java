package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDAO;
import entity.Emp;
import utils.DBUtils;

public class InsertEmpServlet extends HttpServlet {
	 private EmpDAO empdao=new EmpDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//设置编码格式，必须写在传参前
		//获取参数
		String name=req.getParameter("name");
		String salary =req.getParameter("salary");
		String age=req.getParameter("age");
		//将请求参数打包成实体
			resp.setContentType("text/html;charset=utf-8");//针对post提交
			resp.sendRedirect(req.getContextPath()+"/list");//重定向
			Emp emp=new Emp();
			emp.setName(name);
			emp.setSalary(Double.parseDouble(salary));
			emp.setAge(Integer.parseInt(age));
			try {
				empdao.InsertEmp(emp);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ServletException(e);//services原方法只定义了IOException，ServletException，
				//因此将SOL异常转包为ServletException。
			}
	}
}
