/**
 * ���Թ�ϵ��������߼���������÷�
*/
public class TestOperator03{
	
	public static void main(String[] args){
		int a = 3;
		int b = 4;
		boolean c = a>b;
		System.out.println(c);
		
		char d = 'h';
		System.out.println(d);
		System.out.println((int)d);  //charֵλ��0~65535֮�䣬ͨ��(int)ǿ��ת��Ϊ����
		boolean e = d>100;
		System.out.println(e);
		
		//�߼������
		boolean b1 = true;
		boolean b2 = false;
		System.out.println(b1&b2);  //�����㣺��һ��false�����Ϊfalse
		System.out.println(b1|b2);  //�����㣺��һ��true�����Ϊtrue
		System.out.println(!b1);    //�����㣺ȡ��
		System.out.println(b1^b2);  //������㣺��ͬΪfalse����ͬΪtrue
		
		//��·�롢��·��
		//int b3 = 10/0;  //�ᱨ���ܳ���0���쳣
		boolean b3 = 1>2 && (4<3/0);
		System.out.println(b3);
		
	}
}