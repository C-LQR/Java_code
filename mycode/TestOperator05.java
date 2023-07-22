/**
 * 测试字符串连接符的用法
*/
public class TestOperator05{
	
	public static void main(String[] args){
		int a = 3;
		int b = 4;
		System.out.println(a+b); //加法运算符
		
		String c = "3";
		System.out.println(c+b); //字符串连接符
		
		char c1 = 'h';
		char c2 = 'i';
		System.out.println(c1+c2);//加法运算符
		System.out.println(""+c1+c2);//字符串连接符
		
	}
}