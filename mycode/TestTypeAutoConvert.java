/**
 * ���������Զ�ת��
*/
public class TestTypeAutoConvert{
	
	public static void main(String[] args){
		//����С�����Ϳ���ת���������������
		int a = 2345;
		long b = a;
		//int c = b;  //long���Ͳ����Զ�ת����int����
		double d = b;
		float e = b;
		
		//���������ͳ�����int���ͣ����ǿ����Զ�ת���ɣ�byte��short��char
		//ֻҪ��������Ӧ���͵ĵı�����Χ
		byte h1 = 123;
		//byte h2 = 2345;  //2345������byte�ı�����Χ
		
		char h3 = 97;
		System.out.println(h3);
		
	}
}