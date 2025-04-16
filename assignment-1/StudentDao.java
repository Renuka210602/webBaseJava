package practise.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDao implements JDBCdao<Student, Integer> {

	@Override
	public Collection<Student> getAll() {
		Collection<Student> allStudents = new ArrayList<>();
		try(
		Connection dbConnection = jdbcUtil.buildConnection();
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from student")
				){
		while(rs.next()) {
			int rollno = rs.getInt(1);
			String name = rs.getString(2);
			String city = rs.getString(3);
			Student st = new Student(rollno, name, city);
			allStudents.add(st);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return allStudents;
	}
	
	@Override
	public Student getOne(Integer Rollno) {
		Student foundStudent = null;
		String sqlQuery = "select * from student where rollno = ?";
		try(
				Connection dbConnection = jdbcUtil.buildConnection();
				PreparedStatement pstmt =
						dbConnection.prepareStatement(sqlQuery);
				){
			pstmt.setInt(1, Rollno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int rollno = rs.getInt(1);
				String name = rs.getString(2);
				String city = rs.getString(3);
				foundStudent = new Student(rollno,name,city);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			return foundStudent;
		}

	@Override
	public void add(Student st) {
		String sqlQuery = "insert into student values (?,?,?)";
		try(
				Connection dbConnection = jdbcUtil.buildConnection();
				PreparedStatement pstmt =
						dbConnection.prepareStatement(sqlQuery);
				){
			int Rollno = st.getRollno();
			String name = st.getName();
			String city = st.getCity();
			
			pstmt.setInt(1, Rollno);
			pstmt.setString(2, name);
			pstmt.setString(3, city);
			
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount+" record inserted");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
