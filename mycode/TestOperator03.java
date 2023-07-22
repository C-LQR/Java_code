/**
 * 测试关系运算符、逻辑运算符的用法
*/
public class TestOperator03{
	
	public static void main(String[] args){
		int a = 3;
		int b = 4;
		boolean c = a>b;
		System.out.println(c);
		
		char d = 'h';
		System.out.println(d);
		System.out.println((int)d);  //char值位于0~65535之间，通过(int)强制转型为数字
		boolean e = d>100;
		System.out.println(e);
		
		//逻辑运算符
		boolean b1 = true;
		boolean b2 = false;
		System.out.println(b1&b2);  //与运算：有一个false，结果为false
		System.out.println(b1|b2);  //或运算：有一个true，结果为true
		System.out.println(!b1);    //非运算：取反
		System.out.println(b1^b2);  //异或运算：相同为false，不同为true
		
		//短路与、短路或
		//int b3 = 10/0;  //会报不能除以0的异常
		boolean b3 = 1>2 && (4<3/0);
		System.out.println(b3);
		
	}
}