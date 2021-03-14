package Tasks;


import java.util.Arrays;
import java.util.*;
//import java.util.HashMap;
//import java.util.Map;
//import java.io.*;

public class Tasks_2 {
    public static void main (String [] args) {

        System.out.println ("Задание 1");
        System.out.println(opposite_house(2,3));
       
        System.out.println ("Задание 2");
        System.out.println(nameShuffle(" World hello"));

        System.out.println ("Задание 3");
        System.out.println(discount(100,10));

        System.out.println ("Задание 4");
        int [] array = new int [] {3,78,1,6,9,3};
        System.out.println(differenceMaxMin(array));
        
        System.out.println ("Задание 5");
        System.out.println(equal(3,3,3));

        System.out.println ("Задание 6");
        System.out.println(reverse("dlroW olleH"));

        System.out.println ("Задание 7");
        int [] array5 = new int [] {20,18,9};
        System.out.println(programmers(array5));

        System.out.println ("Задание 8");
        String  ar4 =  "xoooo";
        boolean result = getXO(ar4);
        System.out.println(result);

        System.out.println ("Задание 9");
        String s6 = " There is a BOMB";
        System.out.println (bomb(s6));

        System.out.println ("Задание 10");
        boolean result1 =  sameAscii("we","WE");
        System.out.println(result1);
    }

    public static int opposite_house (int house, int N_street) {
        return (N_street*2 +1) - house;
        }
        
        
     

           
           public static String nameShuffle (String str) {
               
            List Words = Arrays.asList(str.split(" "));
            Collections.reverse(Words);
            return String.join(" ", Words );

            } 
            
        public static double discount (double price, double sale) {
           double p = price - ((sale/100)*price);
            return p;
        }
        
        public static int differenceMaxMin (int [] arr) {
            int n = arr.length;
            int i = 0;
            Arrays.sort(arr);
            int r = arr[n-1] - arr[i];
            return r;

        }

        public static int equal (int a1, int a2, int a3) {
            if ((a1 ==a3) & (a1 == a2) & (a3 ==a2)) {
                int k = 3;
                return k;
            }
            if( (a1 == a2) | (a1==a3) | (a2 == a3))
            {
                int k = 2;
                return k;
            }
           
            else{
                return 0;
            }
           
            
            

          
            
        }

        public static String reverse(String string) 
        {
          
            int stringLength = string.length(); 
            String n = "";
            for (int i = 0; i < stringLength; i++) {
                n = string.charAt(i) + n; 
            }
            return n;
        
    
        }

        public static int programmers (int [] a) {
            int n = a.length;
            int i = 0;
            Arrays.sort(a);
            int r1 = a[n-1] - a[i];
            return r1;
        }
        
           public static boolean getXO (String  string) {
               
               int indexX = string.indexOf("x");
               int indexO = string.indexOf("o");
               if((indexX >=-1) &( indexO>= -1) & (indexX == indexO))  {
                   return true;
               }
            return false;
               
              
               
            }
           
        
           
           

           public static boolean bomb (String  s) {
          
            int indexBomb = s.indexOf("bomb"); // Нахождение слова в строке
            int indexBOMB = s.indexOf("BOMB");
            if((indexBomb == - 1) & (indexBOMB == -1)) {
                System.out.println("Relax, there's no bomb.");
             } else {
                System.out.println("DUCK!");
             }
            return true;
              
               
           }
          
           public static boolean sameAscii (String st1, String st2) {
            int length = st1.length();
            byte[] bytes = st1.getBytes(); 
            int sum = 0;
            for (int i = 0; i < length; i++) {
                sum += bytes[i];
            }
           
           
           
            int length1 = st2.length();
            byte[] bytes2 = st2.getBytes(); 
            int sum1 = 0;
            for (int i = 0; i < length; i++) {
                sum1 += bytes2[i];
            }
           
            if (sum == sum1){
                return true;
            }
            return false;



           }
        
       

    

}
