package entity;
/**
 * 员工实体类
 * 一个表对应一个实体
 * 映射table_first
 * @author 1234
 *
 */
public class Emp {
	private int  id;//映射test_first表id字段
	private String name;//映射name字段
	private double salary;//映射salary字段 
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
