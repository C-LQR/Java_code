/**
 * ��������ǿ��ת��
 * ���Գ����������
*/
public class TestTypeCast{
	
	public static void main(String[] args){
		double a = 3.1415;
		int b = (int)a;        //���Ϊ3��������ǿתΪ������ֱ����ȥС������
		System.out.println(b);
		
		//ǿ������ת���������˱�����Χ�����ת��һ����ȫ��ͬ��ֵ
		byte e = (byte)300;
		System.out.println(e);
		
		
		//���Գ����������
		
		int money = 1000000000; //10��
		int years = 20;
		//���ص�total�Ǹ�����������int�ķ�Χ
		int total = money*years;
		System.out.println("total="+total);
		//���ص�total��Ȼ�Ǹ�����Ĭ����int����˽����ת��intֵ����ת��long�������Ѿ����������ݶ�ʧ
		long total1 = money*years;
		System.out.println("total1="+total1);
		//���ص�total2��ȷ:�Ƚ�һ�����ӱ��long���������ʽ����������ȫ����long�����㡣
		//long total2 = money*((long)years);
		long total2 = 1L*money*years;
		System.out.println("total2="+total2);

		//int l = 2; //�ֲ�����L����1, long a = 23451l;//����ʹ�ô�дL
		//System.out.println(l+1);
		
	}
}