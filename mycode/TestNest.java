/**
*测试嵌套循环
*九九乘法表
*/
public class TestNest{
	public static void main(String[] args){
		for(int j = 1;j<=9;j++){
			for(int i = 1;i<=j;i++){
			System.out.print(j+"*"+i+"="+((j*i<10)?(" "+(j*i)):(j*i))+"\t");
			}
			System.out.println();
			
		}
		
	}
}