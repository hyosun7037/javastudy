package booklist;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;



public class CustomerList 
{
	Connection con; // �������
	Statement stmt;
	ResultSet rs;

	public CustomerList() 
	{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid =  "c##madang"; //c##�߰�
		String pwd = "c##madang"; //c##�߰�
	   
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
		}
		catch (ClassNotFoundException e) 
		{
		   e.printStackTrace();
		}
		
		try 
		{
		   System.out.println("�����ͺ��̽� ���� �غ� .....");
		   con = DriverManager.getConnection(url,userid,pwd);
		   System.out.println("�����ͺ��̽� ���� ����");
		}
		catch (SQLException e) 
		{
		   e.printStackTrace();
		}
	}

	void printCustomer() //�ϴ� ���� ����?
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




	
	





