/**
 * ����λ��������÷�
*/
public class TestOperator04{
	
	public static void main(String[] args){
		int a = 7;
		int b = 8;
		System.out.println(a&b); //���Ϊ0
		System.out.println(a|b); //���Ϊ15
		System.out.println(a^b); //���Ϊ15
		System.out.println(~b);  //���Ϊ-9
		
		//��λ
		//����2������2��ʹ����λ��������죡
		System.out.println(5<<1);  //�൱�ڣ�5*2
		System.out.println(40>>3); //�൱�ڣ�40/8
		
	}
}