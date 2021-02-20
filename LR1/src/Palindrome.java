import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a word:");
        String num = in.nextLine();
      
        System.out.println(  num + "-" +"Палиндром?" + " " + isPalindrome(num));
    /*String s = "java Palindrome madam racecar apple kayak song noon";
    String[] words = s.split("\\s");
    for (String sString: words) {
  boolean s4 = isPalindrome(sString);
  System.out.println( sString + "-" +"Палиндром?" + " " + s4); */
    }

   

    public static String reverseString(String input) // метод изменения символов в строке
    {
      
        int stringLength = input.length(); // Находим длину строки с помощью метода length()
        String n = "";
        for (int i = 0; i < stringLength; i++) {
            n = input.charAt(i) + n; // с помощью метода charAt() для сохранения строки с обратным порядком
        }
        return n;
    

    }
    public static boolean isPalindrome(String s) //получает на вход строку и преобразовывает ее в обратном порядке, а затем сравнивает
    {
       String s1 = new String ();
       s1 = reverseString(s);
        if (s.equals(s1)) 
            return true;
        else 
        return false;
        
    }

}


       
      
    
