/**
 * 测试类型自动转换
*/
public class TestTypeAutoConvert{
	
	public static void main(String[] args){
		//容量小的类型可以转换成容量大的类型
		int a = 2345;
		long b = a;
		//int c = b;  //long类型不能自动转换成int类型
		double d = b;
		float e = b;
		
		//特例：整型常量是int类型，但是可以自动转换成：byte，short，char
		//只要不超过对应类型的的表数范围
		byte h1 = 123;
		//byte h2 = 2345;  //2345超过了byte的表数范围
		
		char h3 = 97;
		System.out.println(h3);
		
	}
}