interface Person{
	public int getName(int a, int b);
}


public class LambdaExpression_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Person p = (a,b) -> {
		 * 
		 * System.out.println(a+b); return (a+b);}; p.getName(3,4);
		 */
		
		Runnable runnable = () -> {
			System.out.println("execute run method");
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}

}
