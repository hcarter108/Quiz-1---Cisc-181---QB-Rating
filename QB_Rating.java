import java.util.Scanner;

public class QB_Rating {

	public static void main(String[] args) {
		
		// Create Scanner instance
		Scanner input = new Scanner(System.in);
		
		// Create input variables, 5 total
		double numTDs=0;
		System.out.println("Enter the total number of touchdown passes: ");
		numTDs=input.nextDouble();
		
		double completions=0;
		System.out.println("Enter the total number of completions: ");
		completions=input.nextDouble();
		
		double numAttempts=0;
		System.out.println("Enter the total number of passing attempts: ");
		numAttempts=input.nextDouble();
		
		double passYds=0;
		System.out.println("Enter the total number of passing yards: ");
		passYds=input.nextDouble();
		
		double intercepts=0;
		System.out.println("Enter the total number of interceptions: ");
		intercepts=input.nextDouble();
		
		// From NFL/CFL formula, where a, b, c, and d are calculation factors given by Wikipedia
		double a=(completions/numAttempts - .3)*5;
		double b=(passYds/numAttempts-3)*.25;
		double c=(numTDs/numAttempts)*20;
		double d=2.375-((intercepts/numAttempts)*25);
		
		//Final formula for Passer Rating
		double qbRating=((a+b+c+d)/6)*100;
		//Return value within accepted range, or less than 158.3
		double finalVal=Math.min(qbRating, 158.3);
		//Rounded to one decimal, as it appears to be in practice
		System.out.printf("This individual's QB Rating is %.1f", finalVal);
		//Close input
		input.close();
	}

}