package ch5;

public class String_Ex5_1_tmp {

	public static void main(String[] args) {
		//			  01234
		String str = "ABCDE";
		char ch = str.charAt(2);
		System.out.println(ch);

		String str2 = str.substring(1,4);
		String str3 = str.substring(1); // (1, str.length())
		System.out.println(str3);
	}

}
