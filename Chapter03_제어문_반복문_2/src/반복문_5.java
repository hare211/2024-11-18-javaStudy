
import java.io.*;
public class 반복문_5 {
	public static void main(String[] args) throws Exception{
		FileReader fileReader = new FileReader("C:\\javaDev\\javaStudy\\Chapter03_제어문_반복문_2\\src\\반복문_4.java");
		
		int i = 0; // => 한 글자씩 => 문자(X) => 정수로 읽는다
		
		while ((i = fileReader.read()) != -1) {
			System.out.print((char)i);
		}
	}

}
