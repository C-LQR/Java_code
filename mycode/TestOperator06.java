/**
 * 测试条件运算符的用法
*/
public class TestOperator06{
	
	public static void main(String[] args){
		int score = 90;
		String result = score<60?"不及格":"及格";
		System.out.println(result);
		
		/*
		相当于：
		if(score<60){
			result = "不及格";
		}else{
			result = "及格";
		}
		System.out.println(result);
		*/
	}
}