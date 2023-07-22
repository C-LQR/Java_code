public class TestConstant{
	
	public static void main(String[] args){
			
			//声明符号常量PI,命名规则：全部用大学字母，单词之间用下划线分隔
			final double PI = 3.14;
			int r  = 4;
			double area = PI*r*r;
			double circle = 2*PI*r;
			
			System.out.println("面积是："+area);
			System.out.println("周长是："+circle);
	}
}