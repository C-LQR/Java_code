
/**
 *����������������÷�
*/
public class TestOperator01{
	
	public static void main(String[] args){
		int a = 3;
		long b = 4;
		long c = a+b;
		
		double d = 3+3.14;
		int d2 = 31/3;      //�������������ֱ�ӱ���������������֣�û��������·
		
		int e = 10%3;
		System.out.println(e);   //ȡ������������������߲�����������ͬ
		
		int g = 30;
		g++;         //�൱�ڣ�g = g + 1
		g--;         //�൱�ڣ�g = g - 1
		
		g = 10;
		int h = g++;    //g++�ȸ�ֵ��������
		g = 10;
		int i = ++g;    //++g����������ֵ
		
		System.out.println(h);
		System.out.println(i);
	}
}