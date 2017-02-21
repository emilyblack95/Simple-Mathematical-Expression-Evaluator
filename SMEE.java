import java.util.Scanner;

/*
 * Author: Emily Black
 * Version: 1.0 
 * 2/19/17
 */

public class SMEE
{
	public static double calculateExpr(String dataInput)
	{		
		String num1 = ""; //Leftmost number from operator
		String num2 = ""; //Rightmost number from operator
		String expr = ""; //Holds full dataInput
		double x = 0; //Holds num1 parsed into an int
		double y = 0; //Holds num2 parsed into an int
		double result = 0;
		
		//If the label is empty OR ends with operator
		if(dataInput.isEmpty() || dataInput.endsWith("*") || dataInput.endsWith("/") || dataInput.endsWith("+") || dataInput.endsWith("-") || dataInput.endsWith("."))
		{
			Exception e = new Exception("ERROR: Cannot compute: " + "'" + dataInput + "'" + ". " + "Cannot end dataInput in operator or null value.");
			e.printStackTrace();
		}
		//If the label is NOT empty
		else 
		{	
			while(dataInput.contains("*"))
			{
				int index = dataInput.indexOf("*");
				//Look left of operator
				for(int j = index-1; j >= 0; j--)
				{
					//While we haven't reached another operator
					if(dataInput.charAt(j) != '*' && dataInput.charAt(j) != '/' && dataInput.charAt(j) != '+' && dataInput.charAt(j) != '-')
					{
						num1 += dataInput.charAt(j);
					}
					else if(dataInput.charAt(j) == '*' || dataInput.charAt(j) == '/' || dataInput.charAt(j) == '+' || dataInput.charAt(j) == '-')
					{
						break;
					}
				}
				//Look right of operator
				for(int k = index+1; k < dataInput.length(); k++)
				{
					//While we haven't reached another operator
					if(dataInput.charAt(k) != '*' && dataInput.charAt(k) != '/' && dataInput.charAt(k) != '+' && dataInput.charAt(k) != '-')
					{
						num2 += dataInput.charAt(k);
					}
					else if(dataInput.charAt(k) == '*' || dataInput.charAt(k) == '/' || dataInput.charAt(k) == '+' || dataInput.charAt(k) == '-')
					{
						break;
					}
				}
				num1 = new StringBuilder(num1).reverse().toString();  //We reverse num1 because we read it left to right, not right to left
				x = Double.parseDouble(num1);
				y = Double.parseDouble(num2);
				result = x*y; //result contains result of operator
				expr = num1 + "*" + num2;
				dataInput = dataInput.replace(expr, Double.toString(result));
				num1 = "";
				num2 = "";
			}
			while(dataInput.contains("/"))
			{
				int index = dataInput.indexOf("/");
				//Look left of operator
				for(int j = index-1; j >= 0; j--)
				{
					//While we haven't reached another operator
					if(dataInput.charAt(j) != '*' && dataInput.charAt(j) != '/' && dataInput.charAt(j) != '+' && dataInput.charAt(j) != '-')
					{
						num1 += dataInput.charAt(j);
					}
					else if(dataInput.charAt(j) == '*' || dataInput.charAt(j) == '/' || dataInput.charAt(j) == '+' || dataInput.charAt(j) == '-')
					{
						break;
					}
				}
				//Look right of operator
				for(int k = index+1; k < dataInput.length(); k++)
				{
					//While we haven't reached another operator
					if(dataInput.charAt(k) != '*' && dataInput.charAt(k) != '/' && dataInput.charAt(k) != '+' && dataInput.charAt(k) != '-')
					{
						num2 += dataInput.charAt(k);
					}
					else if(dataInput.charAt(k) == '*' || dataInput.charAt(k) == '/' || dataInput.charAt(k) == '+' || dataInput.charAt(k) == '-')
					{
						break;
					}
				}
				num1 = new StringBuilder(num1).reverse().toString();  //We reverse num1 because we read it left to right, not right to left
				x = Double.parseDouble(num1);
				y = Double.parseDouble(num2);
				result = x/y; //result contains result of operator
				expr = num1 + "/" + num2;
				dataInput = dataInput.replace(expr, Double.toString(result));
				num1 = "";
				num2 = "";
			}
			while(dataInput.contains("+"))
			{
				int index = dataInput.indexOf("+");
				//Look left of operator
				for(int j = index-1; j >= 0; j--)
				{
					//While we haven't reached another operator
					if(dataInput.charAt(j) != '*' && dataInput.charAt(j) != '/' && dataInput.charAt(j) != '+' && dataInput.charAt(j) != '-')
					{
						num1 += dataInput.charAt(j);
					}
					else if(dataInput.charAt(j) == '*' || dataInput.charAt(j) == '/' || dataInput.charAt(j) == '+' || dataInput.charAt(j) == '-')
					{
						break;
					}
				}
				//Look right of operator
				for(int k = index+1; k < dataInput.length(); k++)
				{
					//While we haven't reached another operator
					if(dataInput.charAt(k) != '*' && dataInput.charAt(k) != '/' && dataInput.charAt(k) != '+' && dataInput.charAt(k) != '-')
					{
						num2 += dataInput.charAt(k);
					}
					else if(dataInput.charAt(k) == '*' || dataInput.charAt(k) == '/' || dataInput.charAt(k) == '+' || dataInput.charAt(k) == '-')
					{
						break;
					}
				}
				num1 = new StringBuilder(num1).reverse().toString();  //We reverse num1 because we read it left to right, not right to left
				x = Double.parseDouble(num1);
				y = Double.parseDouble(num2);
				result = x+y; //result contains result of operator
				expr = num1 + "+" + num2;
				dataInput = dataInput.replace(expr, Double.toString(result));
				num1 = "";
				num2 = "";
			}
			//While it does not start with - and contains atleast one -
			while(dataInput.contains("-") && !dataInput.startsWith("-"))
			{
				int index = dataInput.lastIndexOf("-");
				//Look left of operator
				for(int j = index-1; j >= 0; j--)
				{
					//While we haven't reached another operator
					if(dataInput.charAt(j) != '*' && dataInput.charAt(j) != '/' && dataInput.charAt(j) != '+' && dataInput.charAt(j) != '-')
					{
						num1 += dataInput.charAt(j);
					}
					else if(dataInput.charAt(j) == '*' || dataInput.charAt(j) == '/' || dataInput.charAt(j) == '+' || dataInput.charAt(j) == '-')
					{
						break;
					}
				}
				//Look right of operator
				for(int k = index+1; k < dataInput.length(); k++)
				{
					//While we haven't reached another operator
					if(dataInput.charAt(k) != '*' && dataInput.charAt(k) != '/' && dataInput.charAt(k) != '+' && dataInput.charAt(k) != '-')
					{
						num2 += dataInput.charAt(k);
					}
					else if(dataInput.charAt(k) == '*' || dataInput.charAt(k) == '/' || dataInput.charAt(k) == '+' || dataInput.charAt(k) == '-')
					{
						break;
					}
				}
				num1 = new StringBuilder(num1).reverse().toString();  //We reverse num1 because we read it left to right, not right to left
				x = Double.parseDouble(num1);
				y = Double.parseDouble(num2);
				result = x-y; //result contains result of operator
				expr = num1 + "-" + num2;
				dataInput = dataInput.replace(expr, Double.toString(result));
				num1 = "";
				num2 = "";
			}
			//If it contains more than one - and starts with -
			while(dataInput.indexOf("-") != dataInput.lastIndexOf("-") && dataInput.startsWith("-"))
			{
				int index = dataInput.lastIndexOf("-");
				//Look left of operator
				for(int j = index-1; j >= 0; j--)
				{
					//While we haven't reached another operator
					if(dataInput.charAt(j) != '*' && dataInput.charAt(j) != '/' && dataInput.charAt(j) != '+' && dataInput.charAt(j) != '-')
					{
						num1 += dataInput.charAt(j);
					}
					else if(dataInput.charAt(j) == '*' || dataInput.charAt(j) == '/' || dataInput.charAt(j) == '+' || dataInput.charAt(j) == '-')
					{
						break;
					}
				}
				//Look right of operator
				for(int k = index+1; k < dataInput.length(); k++)
				{
					//While we haven't reached another operator
					if(dataInput.charAt(k) != '*' && dataInput.charAt(k) != '/' && dataInput.charAt(k) != '+' && dataInput.charAt(k) != '-')
					{
						num2 += dataInput.charAt(k);
					}
					else if(dataInput.charAt(k) == '*' || dataInput.charAt(k) == '/' || dataInput.charAt(k) == '+' || dataInput.charAt(k) == '-')
					{
						break;
					}
				}
				num1 = new StringBuilder(num1).reverse().toString();  //We reverse num1 because we read it left to right, not right to left
				x = -x;
				x = Double.parseDouble(num1);
				y = Double.parseDouble(num2);
				result = x-y; //result contains result of operator
				expr = num1 + "-" + num2;
				dataInput = dataInput.replace(expr, Double.toString(result));
				num1 = "";
				num2 = "";
			}
			//If the user just enters a random number, give them back that random number
			if((dataInput.startsWith("-") || !dataInput.contains("-")) && !(dataInput.contains("*") && dataInput.contains("/") && dataInput.contains("+")))
			{
				result = Double.parseDouble(dataInput);
			}
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your mathematical dataInput (using only *, /, +, -):");
		String input = in.nextLine();
		System.out.println("Result: " + calculateExpr(input));
		in.close();
	}
}
