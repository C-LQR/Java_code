public class TestInt{
	
	public static void main(String[] args){
		byte a = 50;
		short b = 300;
		
		int c = 100;//十进制
		int d = 015;//八进制
		int e = 0xff;//十六进制
		int f = 0b10010101;//二进制
		
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		
		int salary = 300000000;//整型常量默认类型是int
		long yearsalary = 3000000000L;//把整型常量定义为long型
		
		float f1 = 3.14f;
		
		System.out.println(salary);
		System.out.println(yearsalary);
	}
}