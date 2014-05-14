package main;

import java.util.ArrayList;
/**
 * 
 * @author Ivan Petrov
 *
 */
public class GoldbachConjecture {

	private static ArrayList<Integer> generatePrimeNumbers(int number) {
		ArrayList<Integer> primeNumebers = new ArrayList<Integer>();
		for (int i = 2; i < number / 2 + 1; i++) {
			if (isPrime(i)) {
				primeNumebers.add(i);
			}
		}
		return primeNumebers;
	}
	
	private static boolean isPrime(int number){
        if (number <= 1) {
        	return false;
        } else if (number == 2) {
        	return true;
        } else if (number % 2 == 0) {
        	return false;
        }
        
		for(int i = 3; i < Math.sqrt(number * 1.0); i+=2){
           if(number % i == 0){
               return false;
           }
        }
        return true;
    }
	
	public static void goldbach(int number) {
		ArrayList<Integer> primeNumbers = generatePrimeNumbers(number);
		int prime = 0;
		
		for (int i = 0; i < primeNumbers.size(); i++) {
			prime = number - primeNumbers.get(i);
			if (isPrime(prime)) {
				System.out.printf("(%d, %d)",primeNumbers.get(i), prime);
			}
		}
	}
	
	public static void main(String[] args) {
		goldbach(100);

	}

}
