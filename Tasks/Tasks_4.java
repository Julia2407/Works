package Tasks;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tasks_4 {
    public static void main (String [] args) {

        System.out.println("Задание 1");
        int [] array1 = new int [] {3,87,1,6,9,3};
        sevenBoom(array1);

        System.out.println("Задание 2");
        int [] array2 = new int [] {1,4,6,5,2,3,4};
        boolean res = cons(array2);
        if (res == true) {
            System.out.println(array2);
        }
        else {
            System.out.println("false");
        }
        System.out.println("Задание 3");
        unmix("hTsii  s aimex dpus rtni.g");

        System.out.println("Задание 4");
        System.out.println(noYelling("Oh my goodness!!!!"));

        System.out.println("Задание 5");
        String str = "Inside the box was a xylophone";
        System.out.println(xPronounce(str));
       
        System.out.println("Задание 6");
        int [] array12 = new int [] {14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7};
        System.out.println(largestGap(array12));

        System.out.println("Задание 7");
       System.out.println(reverseCode(832));

        System.out.println("Задание 8");
        System.out.println(commonLastVowel("Hello World World  "));

        System.out.println("Задание 9");
        memeSum(244, 37 );

        System.out.println("Задание 10");
        System.out.println(removeDuplicates("hello"));


    }

/* 1.Создайте функцию, которая принимает массив чисел 
и возвращает "Бум!", если в массиве появляется цифра 7.
 В противном случае верните "в массиве нет 7".*/
    public static void sevenBoom (int [] arr) {
        int k = 0;
    for (int i = 0; i < arr.length; i++ )  {
        if ((arr [i] == 7) | (arr [i] % 10 == 7)) {
           k+=1;
        }
        
    }
    if (k == 0){
        System.out.println("В массиве нет 7");
        }
    else {
        System.out.println("Бум!");
    }
  }

  /*2.Создайте функцию, которая определяет, 
  могут ли элементы в массиве быть переупорядочены,
   чтобы сформировать последовательный список чисел, 
   где каждое число появляется ровно один раз */

   public static boolean cons (int [] mas) {
    Arrays.sort(mas);
    
    for (int i = 0; i < mas.length; i++){
        if ((mas[i+1] - mas[i] >=1 ) & (mas[i] != mas[i+1])) {
            return false;
        }
    }
    return true;
   }


   /*3. Поменять пару символов в строке местами*/
   public static void unmix (String s) {
    char[] ch = s.toCharArray();
    for (int i = 0; i < ch.length - 1; i += 2) {
        char tmp = ch[i];
        ch[i] = ch[i + 1];
        ch[i + 1] = tmp;
    }
    System.out.println(new String(ch));
   }

   /* 4.	Создать функцию, которая преобразует предложения,
    заканчивающиеся несколькими вопросительными знаками ?
     или восклицательными знаками ! в предложение, 
     заканчивающееся только одним, без изменения пунктуации 
     в середине предложений. */
      public static String noYelling(String str) {
          int n = str.length();
          char lastChar = str.charAt(n-1);
         
         
          for (int i = 1; i < n-1; i++) {
          while (lastChar == str.charAt(n-i)) {
            String str1 = deleteCharacters(str, n-i-2, n);
            return str1;
             
             
          }
        
        
          }
          
         return str;
         
      } 
      
    
    static String deleteCharacters(String str, int from, int to) {
        return str.substring(0,from)+str.substring(to);
}

/*5.Создайте функцию, которая заменяет все x в строке  */
public static String xPronounce(String  str22) {
   str22 = str22.replaceAll("x","cks");
   str22 = str22.replaceAll("\sx\s"," ecks ");
   str22 = str22.replaceAll("\sx"," z");
   return str22;
}

/* 7. Обратное кодирование */
public static int reverseCode (int c) {
    int num1 = 0;
    int num2 = c;
    List <Integer> nums = new ArrayList <Integer> ();
   while (num2 != 0) {
       int c1 = num2%10;
       nums.add(c1);
       num2 = num2/10;

   }
     Collections.sort(nums);
    for (int i = 0; i < nums.size(); i++) {
       num1 =  num1 * 10 + nums.get(i);
    }
   
    return c - num1;
    
    
} 




/*6.Учитывая массив целых чисел, верните наибольший разрыв между отсортированными элементами массива. */
public static int largestGap(int [] arr) {
    Arrays.sort(arr);
   int max = 0;
   for (int i = 0; i < arr.length -1; i++) {
       if (arr[i+1] - arr [i]> max) max = arr[i+1] - arr[i];
   }
   return max;
}



/*8. Нахождение гласной, которая чаще всего встречается в слове */
public static String  commonLastVowel(String str22) {
    char [] arr = str22.toCharArray();
    char b = 'N';
    for (int i = 0; i < arr.length; i++) {
        if ("AEIOUYaeiouy".indexOf(arr[i]) != -1) b = arr[i];
        
    }
    return String.valueOf(b);
  
    }
    

/*9 Сложение двух чисел */
public static void memeSum (int a, int b) {
    
       int a1 = a % 10;
       int  b1 = b % 10;
        int res1 = a1+b1;
        int a2 = a / 10;
        int b2 = b /10;
         int res2 = a2+b2;
        System.out.println(res2 +""+ res1);
        

    
    
}

/* 10.Удаление символов*/
public static String removeDuplicates(String str1) {
    StringBuilder newS = new StringBuilder();
    for (int i =0; i < str1.length(); i++) {
        if (newS.indexOf(String.valueOf(str1.charAt(i))) == -1)
        newS.append(str1.charAt(i));
    }
    return newS.toString();

    /*if (str1 == null)
        return null;

    char[] str = str1.toCharArray();

    int len = str.length;

    if (len < 2)
        return str1;

    char temp = str[0];

    for (int i = 1; i < len; i++) {

        if (temp != 0)
            for (int j = i; j < len; j++)
                if (temp == str[j])
                    str[j] = 0;
                    temp = str[i];
                }
            
                int i = 0;
            
                char[] str2 = new char[len];
            
                for (char c : str)
                    if (c != 0)
                        str2[i++] = c;
            
                return (new String(str2)).trim();
            } */
}
}
