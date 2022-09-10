package jdbc5_Movies;

public class splitTest {
	
	public static void main(String[] args) {
	
		String str = "2022-03-23";
		String[] strSplit = str.split("-");
		
		System.out.println("str : " + str);
		System.out.println("strSplit[0] : " + strSplit[0]);
		System.out.println("strSplit[1] : " + strSplit[1]);
		System.out.println("strSplit[2] : " + strSplit[2]);		
		System.out.println("배열의 크기 : " + strSplit.length);
	}
}
