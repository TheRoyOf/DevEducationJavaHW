package Main;



public class Main 
{

	enum EAction
	{
		Sum,
		Sub,
		Mult,
		Dev;
	}

	public static void main(String[] args) 
	{
		
		RunTest();
		
		System.out.println("Hello world. Hello DevEducation!");
		System.out.println("Rezul for Sum 2+2 : " + MathAction(EAction.Sum,2,2));
		System.out.println("Rezul for Sum -2+2 : " + MathAction(EAction.Sum,-2,2));
		System.out.println("Rezul for Sum 2.5+2.5 : " + MathAction(EAction.Sum,2.5,2.5));
		System.out.println("Rezul for Sum 2 000 000 000 + 200 000 000 : " + String.format("%.1f", MathAction(EAction.Sum,2000000000,200000000)));
	}

	

	public static double MathAction(EAction action, double operand_A, double operand_B)
	{
		
		switch (action)
		{
		case Sum:
			return operand_A + operand_B;
		case Dev:
			return operand_A - operand_B;
		case Mult:
			return operand_A * operand_B;
		case Sub:
			return operand_A / operand_B;
		}
		return 0;
		
	}
	
	
	
	public static void RunTest()
	{
		System.out.println(TEST_MathAction());
	}
	
	
	
	
	private static String TEST_MathAction()
	{
		double expected_Sum = 10;
		double expected_Dev = -2;
		double expected_Mult = 24;
		double expected_Sub = 1;
		
		double operand_A = 4;
		double operand_B = 6;
		
		
		int tests = 0;
		int success_Test = 0;
		int failed_Test = 0;

		
		if(MathAction(EAction.Sum, operand_A, operand_B)==expected_Sum) 
		{
			tests++;
			success_Test++;
		}
		else
		{
			tests++;
			failed_Test++;
			
			System.out.println("Test for action Sum FAILED");
		}
		
		if(MathAction(EAction.Dev, operand_A, operand_B)==expected_Dev) 
		{
			tests++;
			success_Test++;
		}
		else
		{
			tests++;
			failed_Test++;
			
			System.out.println("Test for action Dev FAILED");
		}
		
		if(MathAction(EAction.Mult, operand_A, operand_B)==expected_Mult) 
		{
			tests++;
			success_Test++;
		}
		else
		{
			tests++;
			failed_Test++;
			
			System.out.println("Test for action Mult FAILED");
		}
		
		if(MathAction(EAction.Sub, operand_A, operand_B)==expected_Sub) 
		{
			tests++;
			success_Test++;
		}
		else
		{
			tests++;
			failed_Test++;
			
			System.out.println("Test for action Sub FAILED");
		}
		
		return "Tests: " + tests + ", Success: " + success_Test + ", Failed: " + failed_Test;
	}

}
