
package Tasks;

import java.util.Scanner;

public class Tasks_1
 {
    
    public static void main (String [] args) {
        Scanner in = new Scanner (System.in); 
        System.out.println ("Задание 1"); // Задание 1  
        System.out.println ("Введите число минут");
        int minutes = in.nextInt();
       int sekonds = Convert_To_Seconds(minutes);
       System.out.println("Ответ:" + " " + sekonds);

       System.out.println ("Задание 2"); // Задание 2  
       System.out.println ("Введите количество 2-х очков"); 
       int a = in.nextInt();
       System.out.println ("Введите количество 3-х очков"); 
       int b = in.nextInt();
       System.out.println( "Ответ:" + " " + points(a,b));

       System.out.println ("Задание 3"); // Задание 3
       System.out.println ("Введите количество выигрышей"); 
       int w= in.nextInt();
       System.out.println ("Введите количество ничьих"); 
       int d = in.nextInt();
       System.out.println ("Введите количество проигрышей"); 
       int l = in.nextInt();
       System.out.println("Ответ:"+ " " +  footboolPoints(w,d,l)); 

       System.out.println ("Задание 4"); // Задание 4
       System.out.println ("Введите число"); 
       int digit = in.nextInt();
       boolean r = divisibleByFive(digit);
       System.out.println("Ответ:"+ " " + r); 

       System.out.println ("Задание 5"); // Задание 5
       System.out.println ("Введите значение 1"); 
       boolean a1 = in.nextBoolean();
       System.out.println ("Введите значение 2");
       boolean a2 = in.nextBoolean();
       boolean res = and (a1,a2);
       System.out.println("Ответ:"+ " " + res); 

       System.out.println ("Задание 6"); // Задание 6
       System.out.println ("Введите число метров, которое можно покрасить одним ведром "); 
       int metres = in.nextInt();
       System.out.println ("Введите ширину стены "); 
       int weight = in.nextInt();
       System.out.println ("Введите длину стены "); 
       int height = in.nextInt();
       int res1 = howManyWalls (metres, weight, height);
       System.out.println ("Ответ: " + " " + res1); 

       System.out.println ("Задание 7"); // Задание 7
       System.out.println ("Введите число ");
       int dig = in.nextInt();
       System.out.println ("Ответ: " + squaed(dig) ); 

       System.out.println ("Задание 8"); // Задание 8
       System.out.println ("Введите прибыль ");
       double pr = in.nextDouble();
       System.out.println ("Введите цену ");
       double prize = in.nextDouble();
       System.out.println ("Введите расходы ");
       double pay = in.nextDouble();
       boolean s =  profitableGamble (pr,prize, pay);
       System.out.println ("Ответ: " + s ); 

       System.out.println ("Задание 9"); // Задание 9
       System.out.println ("Введите число кадров в секунду ");
       int F = in.nextInt();
       System.out.println ("Введите количество минут ");
       int t = in.nextInt();
       System.out.println ("Ответ: " + frames (F,t)); 

       System.out.println ("Задание 10"); // Задание 10
       System.out.println ("Введите первое число ");
       int a10 = in.nextInt();
       System.out.println ("Введите второе число ");
       int b10 = in.nextInt();
       System.out.println ("Ответ: " + mod (a,b));

    } 

    public static int Convert_To_Seconds(int min) { /* Задание 1: Напишите функцию, 
        которая принимает целое число минут и преобразует его в секунды.*/
            min = min * 60;
    return min;
    }

    public static int  points (int two_S, int three_S) { /* Задание 2: Вы подсчитываете
         очки за баскетбольный матч, учитывая количество забитых 2-х и 3-х очков,
         находите окончательные очки для команды и возвращаете это значение. */
        two_S = two_S *2;
        three_S = three_S *3;
     int summ = two_S +three_S;
     return summ;
   
    }
    public static int footboolPoints(int win, int draw, int los) { /* Задание 3: Создайте функцию,
         которая принимает количество побед, ничьих и поражений 
         и вычисляет количество очков, набранных футбольной командой на данный момент. */
          win = win * 3;
          draw = draw * 1;
          los = los * 0;
          int summ = win + draw +los;
          
          return summ;

    }

    public static boolean divisibleByFive(int n) { /* Задание 4 Создайте функцию,
        которая возвращает true, если целое число равномерно делится на 5, и false в противном случае. */
      if (n % 5 == 0) {
          return true;
      }
      return false;
    }

    public static boolean and (boolean a,boolean b) { /* Задание 5: Создайте функцию с помощью оператора&&. */
      if (a && b == true ) {
          return true;
      }
      return false;
    }

    public static int howManyWalls(int n, int w, int h) {  /* Задание 6: Создайте функцию, которая возвращает количество полных стен, 
        которые можно покрасить (n - это количество квадратных метров, которые можно покрасить.
        w и h-это ширина и высота одной стены в метрах.)  */
       int N = n /(w * h);
      
      return N;
    }
   
    public static int squaed(int b) { /* Задание 7: исправить функцию, возводящую число в квадрат */
      int a = b * b;
      return a;
     
    }

    public static boolean profitableGamble (double prob, double prize, double pay) { /* Задание 8: Создайте функцию, которая принимает три аргумента
         prob, prize, pay и возвращает true, если prob * prize > pay; в противном случае возвращает false. */
     if ((prob * prize) > pay) {
         return true;
     }
     return false;
    }
  
    public static int frames (int FPS, int time) { /* Задание 9: Создайте метод, который возвращает количество кадров,
         показанных за заданное количество минут для определенного FPS.*/
       int kol = FPS * time * 60;
       return kol;

    }

    public static int mod (int a, int b) { /* Задание 10:  Создайте функцию, которая будет работать
         как оператор модуля % без использования оператора модуля. */
         if (a > b) {
             int c = a - ((a/b)* b);
             return c;
         }
         else {
             int c = b - ((b/a)* a);
             return c;
         }
       
    }
    

 }