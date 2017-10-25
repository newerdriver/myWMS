package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDAO;
import entity.Emp;
import utils.DBUtils;

public class ListEmp extends HttpServlet {
	private EmpDAO empdao=new EmpDAO();
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
//	req.setCharacterEncoding("utf-8");
//	resp.setContentType("text/html;charset=utf-8");//浏览器响应消息头
//	PrintWriter out= resp.getWriter();
//	out.println("<table border='1px solid'><thead><tr><th>id</th><th>姓名"
//			+ "</th><th>薪资</th><th>年龄</th></tr></thead><tbody>");
//	//req.getMethod();//获取浏览器提交方式
//	try {
//		
//		List<Emp>emps=empdao.SelectAll();
//		//遍历员工列表
//		for(Emp emp:emps){
//			out.println("<tr><td>"+emp.getId()
//		+"</td><td>"+emp.getName()
//					+"</td><td>"+emp.getSalary()
//		+"</td><td>"+emp.getAge()
//		+"</td></tr>");
//		}
//		out.println("</tbody></table>");
//		out.close();
//	} catch (SQLException e) {
//	
//		e.printStackTrace();
//	}
//	out.close();
//	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		try {
			List<Emp> emps=empdao.SelectAll() ;
			//绑定员工数据
			req.setAttribute("emps", emps);
			//获得转发器
			RequestDispatcher dispatcher=req.getRequestDispatcher("/list.jsp");
			//转发器转发
			dispatcher.forward(req, resp);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
