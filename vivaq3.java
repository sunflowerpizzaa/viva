package helloworld; 

import java.util.Scanner;

public class vivaq3 {
    public static void main (String[] args){
     Scanner input = new Scanner(System.in);
     
     //This section ask for the starting value using scanner
     System.out.println("Enter the starting value: ");
     int start = input.nextInt();
     
     //This section ask for the ending value using scanner
     System.out.println("Enter the ending value: ");
     int end = input.nextInt();
     
     //this is a for loop statement
     //the i is initialized with the starting value 
     //and it will end when it reaches the ending value
     for (int i=start; i<=end; i++){
         if (i%3==0 && i%5==0){ //this checks if the value is divisible by both 5 and 3
            System.out.println("LuluLala"); 
         }
         else if (i%5==0){ //this checks if the value is divisible by 5 only
            System.out.println("Lala"); 
         }
         else if (i%3==0){ //this checks if the value is divisible by 3 only
             System.out.println("Lulu");
         }
         else //if all 3 conditions are not met, it will print only the number as is
         System.out.println(i);
     } //this will repeat until it reaches the ending value, where it does not fulfill the loop conditions anymore
    }
}