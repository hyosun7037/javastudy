package booklist;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;



public class CustomerList 
{
	Connection con; // 멤버변수
	Statement stmt;
	ResultSet rs;

	public CustomerList() 
	{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid =  "c##madang"; //c##추가
		String pwd = "c##madang"; //c##추가
	   
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		}
		catch (ClassNotFoundException e) 
		{
		   e.printStackTrace();
		}
		
		try 
		{
		   System.out.println("데이터베이스 연결 준비 .....");
		   con = DriverManager.getConnection(url,userid,pwd);
		   System.out.println("데이터베이스 연결 성공");
		}
		catch (SQLException e) 
		{
		   e.printStackTrace();
		}
	}

	void printCustomer() //하는 일이 뭐냐?
	{ 
		String query = "SELECT custid, name, address, phone  FROM customer";
		try 
		{
			stmt = con.createStatement(); //2
			rs = stmt.executeQuery(query); //3
			System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \t\t\tPRICE");
			
			while (rs.next ()) 
			{
				System.out.print("\t" + rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t\t\t" + rs.getString(3));
				System.out.println("\t\t\t\t" + rs.getString(4));
			}
			con.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}




	
	





