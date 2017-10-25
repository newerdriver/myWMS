package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDAO;

public class DeleteEmp extends HttpServlet{

	 private EmpDAO empDAO=new EmpDAO();//频繁调用该资源，放在全局位置
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html charset=utf-8");//浏览器打开方式
		String id=req.getParameter("id");//从request获得参数类型都为String类型
		try {
			empDAO.DeleteEmp(Integer.parseInt(id));
			resp.sendRedirect(req.getContextPath()+"/list");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new ServletException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
