package dao;
//sql分页查询 sql数据从0开始计数
//limit 0,2 从0开始，两条记录。
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Emp;
import utils.DBUtils;

/**
 * 封装emp表的操作
 * @author 1234
 *
 */
public class EmpDAO {
		/**
		 * 列出所有员工
		 * @return
		 * @throws SQLException 
		 */
		public List<Emp> SelectAll() throws SQLException{
			try {
				List<Emp> emps=new ArrayList<Emp>(); 			
				Connection conn=DBUtils.getConnection();
				PreparedStatement ps=conn.prepareStatement("SELECT id, name,age,salary FROM test_first");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Emp emp=new Emp();
					emp.setId(rs.getInt("id"));
					emp.setAge(rs.getInt("age"));
					emp.setName(rs.getString("name"));
					emp.setSalary(rs.getDouble("salary"));
					//将emp对象放入emps中
					emps.add(emp);
					
				}
				conn.close();
				return emps;
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
	
		
		}
		
		/**
		 * 插入数据库
		 * 参数由实体类传入：
		 * @throws SQLException 
		 */
		public void InsertEmp(Emp emp) throws SQLException{
			try{
				Connection conn=DBUtils.getConnection();
				PreparedStatement ps=conn.prepareStatement("INSERT INTO test_first(name,age,salary) VALUES(?,?,?)");
				ps.setString(1, emp.getName());
				ps.setDouble(3, emp.getSalary());
				ps.setInt(2, emp.getAge());
				ps.executeUpdate();
				conn.close();
			}catch(SQLException e){
				//通常先捕获异常，再往外抛；
				//捕获的作用记录异常日志，抛出作用为通知调用者代码执行有问题
				e.printStackTrace();
				throw e;
			}
		}
		/**'
		 * 通过id删除emp记录
		 * @throws SQLException 
		 */
		public void DeleteEmp(int id) throws SQLException{
			try {
				Connection conn= DBUtils.getConnection();
				PreparedStatement stmt=conn.prepareStatement("DELETE  FROM test_first WHERE id=?");
				stmt.setInt(1,id );
				stmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw e;
			}
		}
		
		/**'
		 * 修改数据
		 * @param emp
		 * @throws SQLException
		 */
		public void ModifyEmp(Emp emp) throws SQLException{
			try {
				Connection conn= DBUtils.getConnection();
				PreparedStatement stmt=conn.prepareStatement("UPDATE test_first SET name=?,age=?,salary=? WHERE id=?");
				stmt.setString(1, emp.getName());
				stmt.setInt(2, emp.getAge());
				stmt.setDouble(3, emp.getSalary());
				stmt.setInt(4, emp.getId());
				stmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw e;
			}
			
		}
		
		
		/**
		 * 根据id查找数据
		 * @param id
		 * @return
		 * @throws SQLException
		 */
		public Emp findByid(int id) throws SQLException{
			try {
				Connection conn=DBUtils.getConnection();
				PreparedStatement stmt=conn.prepareStatement("SELECT *FROM test_first where id=?");
				stmt.setInt(1, id);
				ResultSet rs=stmt.executeQuery();
				Emp emp=null;
				if(rs.next()){//判断结果集中是否存在一条记录
					emp=new Emp();//存在记录才创建emp对象。
					emp.setId(rs.getInt("id"));
					emp.setAge(rs.getInt("age"));
					emp.setSalary(rs.getDouble("salary"));
					emp.setName(rs.getString("name"));
				}
				conn.close();
				return emp;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}
			
		}
}
