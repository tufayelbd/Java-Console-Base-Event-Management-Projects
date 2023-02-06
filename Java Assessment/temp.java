import java.util.Scanner;
import java.util.InputMismatchException;
public class temp{
	public static void main(String [] args){
		
		System.out.println("Hello Exception..");
		Scanner sc = new Scanner(System.in); // this is for taking String input

		try{
		
		System.out.println("Input A..");
		
        int a = sc.nextInt();
		try{
        
		System.out.println("Input B.");
		int b  = sc.nextInt();
		
		
		}catch(InputMismatchException e){
			System.out.println("Exception Inner");
		}
		
		}catch(InputMismatchException e){
			System.out.println("Exception Last");
		}
		
}
	
	
}