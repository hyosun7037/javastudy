package booklist;

public class BookStore {
	//������� Ŭ������ ����ϴ� �κ�
//	BookStore()
	void run()
	{
		BookList bl = new BookList();//
		bl.getConnection();// ���� open
		bl.getBookDB();	   // ���� close
		bl.printBook_Obj_array();

		//		so.printBookArr();
		
//		CustomerList cl = new CustomerList();
		//...
	}
	

}

