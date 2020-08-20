package dao;

import java.util.ArrayList;

import vo.BookVO;
import vo.OutBookVO;
import data.Database;

public class BookDao {

	private static BookDao instance;
	
	private BookDao(){}
	
	public static BookDao getInstance(){
		if(instance == null){
			instance = new BookDao();
		}
		return instance;
	}

	Database database = Database.getInstance();
	
	public BookVO selectBook(OutBookVO param) {
		BookVO rtnBook = null;
		for (int i = 0; i < database.tb_book.size(); i++) {
			BookVO dBook = database.tb_book.get(i);
			if (param.getOutCode() == dBook.getCode()) {
				rtnBook = dBook;
				break;
			}
		}
		return rtnBook;
	} 
	
	public void insertBook(BookVO book) {
		database.tb_book.add(book);
	}

	public ArrayList<BookVO> selectbooklist() {
		return database.tb_book;
	}
	
	public void delbook(BookVO book){
		database.tb_book.remove(book); //도서제거 
	}


	public BookVO selectbook(BookVO book) {
		for(int i = 0; i < database.tb_book.size(); i++){
			if(book.getCode() == database.tb_book.get(i).getCode()){
				return database.tb_book.get(i);
			}
		}
		return null;
		
		
	}

}






	
