/**
 * 测试位运算符的用法
*/
public class TestOperator04{
	
	public static void main(String[] args){
		int a = 7;
		int b = 8;
		System.out.println(a&b); //结果为0
		System.out.println(a|b); //结果为15
		System.out.println(a^b); //结果为15
		System.out.println(~b);  //结果为-9
		
		//移位
		//乘以2，除以2，使用移位操作，最快！
		System.out.println(5<<1);  //相当于：5*2
		System.out.println(40>>3); //相当于：40/8
		
	}
}