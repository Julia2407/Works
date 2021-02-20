public class Primes {
    public static void main (String[] args){
        for (int k = 2; k <= 100; k++) {
            boolean r1 = isPrime(k);
            if (r1 == true) {
            System.out.print(k + " ");
            }
        }
        
      }
       
        
    
        public static boolean isPrime(int n) { // простые числа меньше 100
for ( int i =2; i < n;i++) { 
    if (n % i == 0) {
        return false;
    }
    

} // делится ли число без остатка на n (является ли простым)
 
    return true;
    
}
}
        
    
        

        
    
        
    
    


