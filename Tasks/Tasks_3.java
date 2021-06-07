package Tasks;

public class Tasks_3 {
    public static void main (String [] args) {
  
        

      System.out.println("Задание 1");
       Towns Town1 = new Towns ();
       Town1.name = "Nice";
        Town1.pop =  942208;
        Town1.displayInfo();

        Towns Town2 = new Towns ();
        Town2.name = "Abu Dhabi";
         Town2.pop =  1482816;
         Town2.displayInfo();

         Towns Town3 = new Towns ();
         Town3.name = "Naples";
          Town3.pop = 2186853 ;
          Town3.displayInfo();

          Towns Town4 = new Towns ();
          Town4.name = "Vatican City";
           Town4.pop =  572;
           Town4.displayInfo();

      /*String [] Towns = new String [] {"Nice","Abu Dhabi","Naples","Vatican City"};
     
    int [] pop = new int [] {  942208,1482816,
       2186853,
       572};
       millionsRounding(pop, Towns);*/
  
       System.out.println("Задание 2");
        otherSides(5);
      
        System.out.println("Задание 3");
        rps("paper","paper");
        
        System.out.println("Задание 4");
        int [] mass = new int [] {2,8,7,5};
        System.out.println(warOfNumbers(mass));

        System.out.println("Задание 5");
        reverseCase("haLLO world");

        System.out.println("Задание 6");
        inatorInator("EvilClone");

        System.out.println("Задание 7");
        boolean res = doesBrickFit(1,2,1,1,1);
        System.out.println(res);

        System.out.println("Задание 8");
        System.out.println(totalDistance(70.0, 7.0, 0, false));

        System.out.println("Задание 9");
        double [] mass2 = new double [] {2,9,7,5};
        mean(mass2);


        System.out.println("Задание 10");
        boolean res12 = parityAnalysis(26);
        System.out.println(res12);
        

    }


    

 




/*public static void  millionsRounding (int [] ar, String [] ar1) {//1
   int n = ar.length;
   for (int i = 0; i < n; i++){
       
       ar[i] = ((int)Math.round(ar[i]*0.000001))*1000000;

       System.out.println(ar1[i] + ": " +ar[i]);
   }
  } */
  public static void otherSides (double a) { //2
     double c = a*2;
     double b = Math.sqrt(c*c - a*a);
     double b1 = (double) Math.round(b * 100) / 100;
     double [] sides;
     sides = new double [3];
    int i = 0;
sides [i] = c;
sides [i+1] = b1;
System.out.println(sides[i] +", " + sides[i+1]);
     
     
     
  }
 
  public static void rps (String str1, String str2) { //3
      
      if (str1 == str2) {
         System.out.println("Ничья");
        
      }
      if (((str1 == "paper") & (str2 == "rock"))
      | ((str1 == "rock") & (str2 == "scissors")) | ((str1 == "scissors") & (str2 == "paper")))
    {
        System.out.println( "Player 1 wins");
    

    }
    else
     { 
        System.out.println( "Player 2 wins");
    
    }
}
    public static int warOfNumbers (int [] mas) { //4
       int n = mas.length;
       int k1= 0;
       int k2 = 0;
       for (int i =0; i < n; i++){
           if (mas[i]%2 == 0) {
               k1 = k1 + mas[i];
           }
           else {
               k2 = k2+mas[i];
           }

       }
       int razn = Math.abs(k1-k2);
       return razn;

    }

    public static void reverseCase (String s) { //5
        
        
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c)) {
                chars[i] = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                chars[i] = Character.toUpperCase(c);
            }

           
        }
       
        System.out.println(new String(chars));
     
         
    }
       
      public static void inatorInator (String str) { //6
        char[] chars = str.toCharArray();
        int n = chars.length;
        int m = chars [n-1];
        if ((m == 'a') | (m == 'e') | ( m == 'i') | (m =='o') | (m == 'u')) {
            System.out.println(new String(chars) + "-inator" + " " + n*1000);
        }
        else {
            System.out.println(new String(chars) + "inator" + " " + n*1000);
        }
      }
    public static boolean doesBrickFit (int a,int b, int c, int w, int h ) { //7
        if ((a*b*c) <= w*h) {
            return true;
        }
        else {
            return false;
        }
        
    }
    public static double totalDistance (double l, double ras, int pass, boolean kon) { //8
        double ras1 = ras + ras*0.05*pass;
       if (kon == true) {
           ras1 = ras + ras*0.1*pass;
       }
      
       double S = (l/ras1) * 100 ;
       return S;

    }

    public static void mean (double [] array) { //9
        double n = array.length;
        double summ = 0 ;
        for (int i = 0; i< n; i++) {
             summ = array[i] + summ;
        }
        double sred = summ/n;
        System.out.println(sred);
    }

   public static boolean parityAnalysis (int r) {//10
     int summa = 0;
      int r1 = r;
      while (r1 != 0) {
     summa += (r1 % 10);
        r1/=10;
        
      }
      if ((summa %2 == 0) & (r %2 == 0) | ((summa %2 != 0) & (r %2 != 0) )) {
          return true;
      }
      else {
          return false;
      }
     
       
    
       

   }

}


  
   



  


