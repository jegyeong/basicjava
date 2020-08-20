package g_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Finally {

	public static void main(String[] args) {
		/*
		 * << finally >>
		 * - 필요에 따라 try-catch 뒤에 finally를 추가할 수 있다.
		 * - finally는 예외의 발생여부와 상관없이 가장 마지막에 수행된다.
		 * 
		 * << 자동 자원 반환(try-with-resources) >>
		 * - try(변수 선언;변수 선언){} catch(Exception e){}
		 * - 사용 후 반환이 필요한 객체를 try의 ()안에서 선언하면 try 블럭 종료시 자동으로 반환된다.
		 */
		
		FileInputStream fis = null; //파일 읽기
		
		try {
			fis = new FileInputStream("file.txt"); //사용 후 닫아줘야 하는 객체
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			//예외 발생과 상관없이 반드시 처리해야 하는 내용을 넣어준다.
			try {
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 예외 발생 : try -> catch -> finally
		// 예외 미발생 : try -> finally
		
		//자동 자원 반환(JDK1.7)
		try(FileOutputStream fos = new FileOutputStream("d:/file.txt")){ //파일 쓰기
			String str = "아무내용이 써보자...";
			byte[] bytes = str.getBytes();
			for(int i = 0; i < bytes.length; i++){
				fos.write(bytes[i]);
			}
			fos.write(65);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}










