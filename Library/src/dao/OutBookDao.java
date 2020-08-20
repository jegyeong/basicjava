package dao;

import java.util.ArrayList;

import vo.BookVO;
import vo.OutBookVO;
import vo.UserVO;
import data.Database;

public class OutBookDao {	
	
	private static OutBookDao instance;

	private OutBookDao() {
	}

	public static OutBookDao getInstance() {
		if (instance == null) {
			instance = new OutBookDao();
		}
		return instance;
	}

	Database database = Database.getInstance();

	//가장 최근 대여된 도서 반환 없으면 널
	public OutBookVO selectOutBook(BookVO param) {
		OutBookVO rtnBook = new OutBookVO();
		for (int i = database.tb_outBook.size() - 1; i >= 0; i--) {
			OutBookVO dBook = database.tb_outBook.get(i);
			if (param.getCode() == dBook.getOutCode()) {
				rtnBook = dBook;
				break;
			}
		}
		return rtnBook;
	}

	//반납 안한 책 2권 배열로 반환
	public ArrayList<OutBookVO> checkOutBook(UserVO param) {
		ArrayList<OutBookVO> rtnBook = new ArrayList<>();
		for (int i = database.tb_outBook.size() - 1; i >= 0; i--) {
			OutBookVO dBook = database.tb_outBook.get(i);
			if (param.getUserID().equals(dBook.getRenter())
					&& dBook.getReturnDate() == null) {
				rtnBook.add(dBook);
				dBook = new OutBookVO();
			}
			if (rtnBook != null && rtnBook.size() == 2)
				break;
		}
		return rtnBook;
	}
	
	
	// 빌렸던 모든 책 반환
	public ArrayList<OutBookVO> checkOutBookall(UserVO param) {
		ArrayList<OutBookVO> rtnBook = new ArrayList<>();
		for (int i = database.tb_outBook.size() - 1; i >= 0; i--) {
			OutBookVO dBook = database.tb_outBook.get(i);
			if (param.getUserID().equals(dBook.getRenter())) {
				rtnBook.add(dBook);
				dBook = new OutBookVO();
			}
		}
		return rtnBook;
	}
	
	

	public void insertOutBook(OutBookVO outBook) {
		database.tb_outBook.add(outBook);
	}

	public ArrayList<OutBookVO> selectOutBookList() {
		return database.tb_outBook;
	}

}
