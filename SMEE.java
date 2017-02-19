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
		String data = dataInput;
		String num1 = ""; //Leftmost number from operator
		String num2 = ""; //Rightmost number from operator
		String expr = "";
		double x = 0;
		double y = 0;
		double result = 0;
		
		
		//If the input is empty OR ends with operator
		if(dataInput.isEmpty() || dataInput.endsWith("*") || dataInput.endsWith("/") || dataInput.endsWith("+") || dataInput.endsWith("-") || dataInput.endsWith("."))
		{
			Exception e = new Exception("ERROR: Cannot compute: " + "'" + dataInput + "'" + ". " + "Cannot end expression in operator or null value.");
			e.printStackTrace();
		}
		//If the input is NOT empty
		else 
		{
			while(data.contains("*"))
			{
				int index = data.indexOf("*");
				//Look left of operator
				for(int j = index-1; j >= 0; j--)
				{
					//While we haven't reached another operator
					if(data.charAt(j) != '*' && data.charAt(j) != '/' && data.charAt(j) != '+')
					{
						num1 += data.charAt(j);
					}
					else if(data.charAt(j) != '*' || data.charAt(j) != '/' || data.charAt(j) != '+' || data.charAt(j) != '-')
					{
						break;
					}
				}
				//Look right of operator
				for(int k = index+1; k < data.length(); k++)
				{
					//While we haven't reached another operator
					if(data.charAt(k) != '*' && data.charAt(k) != '/' && data.charAt(k) != '+' && data.charAt(k) != '-')
					{
						num2 += data.charAt(k);
					}
					else if(data.charAt(k) != '*' || data.charAt(k) != '/' || data.charAt(k) != '+' || data.charAt(k) != '-')
					{
						break;
					}
				}
				num1 = new StringBuilder(num1).reverse().toString();  //We reverse num1 because we read it left to right, not right to left
				x = Double.parseDouble(num1);
				y = Double.parseDouble(num2);
				result = x*y; //result contains result of operator
				expr = num1 + "*" + num2;
				data = data.replace(expr, Double.toString(result));
				num1 = "";
				num2 = "";
			}
			while(data.contains("/"))
			{
				int index = data.indexOf("/");
				//Look left of operator
				for(int j = index-1; j >= 0; j--)
				{
					//While we haven't reached another operator
					if(data.charAt(j) != '*' && data.charAt(j) != '/' && data.charAt(j) != '+')
					{
						num1 += data.charAt(j);
					}
					else if(data.charAt(j) != '*' || data.charAt(j) != '/' || data.charAt(j) != '+' || data.charAt(j) != '-')
					{
						break;
					}
				}
				//Look right of operator
				for(int k = index+1; k < data.length(); k++)
				{
					//While we haven't reached another operator
					if(data.charAt(k) != '*' && data.charAt(k) != '/' && data.charAt(k) != '+' && data.charAt(k) != '-')
					{
						num2 += data.charAt(k);
					}
					else if(data.charAt(k) != '*' || data.charAt(k) != '/' || data.charAt(k) != '+' || data.charAt(k) != '-')
					{
						break;
					}
				}
				num1 = new StringBuilder(num1).reverse().toString();  //We reverse num1 because we read it left to right, not right to left
				x = Double.parseDouble(num1);
				y = Double.parseDouble(num2);
				result = x/y; //result contains result of operator
				expr = num1 + "/" + num2;
				data = data.replace(expr, Double.toString(result));
				num1 = "";
				num2 = "";
			}
			while(data.contains("+"))
			{
				int index = data.indexOf("+");
				//Look left of operator
				for(int j = index-1; j >= 0; j--)
				{
					//While we haven't reached another operator
					if(data.charAt(j) != '*' && data.charAt(j) != '/' && data.charAt(j) != '+')
					{
						num1 += data.charAt(j);
					}
					else if(data.charAt(j) != '*' || data.charAt(j) != '/' || data.charAt(j) != '+' || data.charAt(j) != '-')
					{
						break;
					}
				}
				//Look right of operator
				for(int k = index+1; k < data.length(); k++)
				{
					//While we haven't reached another operator
					if(data.charAt(k) != '*' && data.charAt(k) != '/' && data.charAt(k) != '+' && data.charAt(k) != '-')
					{
						num2 += data.charAt(k);
					}
					else if(data.charAt(k) != '*' || data.charAt(k) != '/' || data.charAt(k) != '+' || data.charAt(k) != '-')
					{
						break;
					}
				}
				num1 = new StringBuilder(num1).reverse().toString();  //We reverse num1 because we read it left to right, not right to left
				x = Double.parseDouble(num1);
				y = Double.parseDouble(num2);
				result = x+y; //result contains result of operator
				expr = num1 + "+" + num2;
				data = data.replace(expr, Double.toString(result));
				num1 = "";
				num2 = "";
			}
			while(data.contains("-") && !data.startsWith("-"))
			{
				int index = data.lastIndexOf("-");
				//Look left of operator
				for(int j = index-1; j >= 0; j--)
				{
					//While we haven't reached another operator
					if(data.charAt(j) != '*' && data.charAt(j) != '/' && data.charAt(j) != '+')
					{
						num1 += data.charAt(j);
					}
					else if(data.charAt(j) != '*' || data.charAt(j) != '/' || data.charAt(j) != '+' || data.charAt(j) != '-')
					{
						break;
					}
				}
				//Look right of operator
				for(int k = index+1; k < data.length(); k++)
				{
					//While we haven't reached another operator
					if(data.charAt(k) != '*' && data.charAt(k) != '/' && data.charAt(k) != '+' && data.charAt(k) != '-')
					{
						num2 += data.charAt(k);
					}
					else if(data.charAt(k) != '*' || data.charAt(k) != '/' || data.charAt(k) != '+' || data.charAt(k) != '-')
					{
						break;
					}
				}
				num1 = new StringBuilder(num1).reverse().toString();  //We reverse num1 because we read it left to right, not right to left
				x = Double.parseDouble(num1);
				y = Double.parseDouble(num2);
				result = x-y; //result contains result of operator
				expr = num1 + "-" + num2;
				data = data.replace(expr, Double.toString(result));
				num1 = "";
				num2 = "";
			}
		}
		return result;
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your mathematical expression (using only *, /, +, -):");
		String input = in.nextLine();
		System.out.println("Result: " + calculateExpr(input));
		in.close();
	}
}
