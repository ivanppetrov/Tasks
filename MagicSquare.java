package main;
/**
 * 
 * @author Ivan Petrov
 *
 */
public class MagicSquare {
	private static int getSum(int[][] matrix) {
		int sum = 0;
		
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				sum += matrix[i][j];
			}
		}
		
		return sum;
	}
	
	private static boolean checkRows(int[][] matrix, int sum) {
		int rowSum = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				rowSum += matrix[i][j];
			}
			if (rowSum != sum) {
				return false;
			} else {
				rowSum = 0;
			}
		}
		return true;
	}
	
	private static boolean checkCols(int[][] matrix, int sum) {
		int colSum = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				colSum += matrix[j][i];
			}
			if (colSum != sum) {
				return false;
			} else {
				colSum = 0;
			}
		}
		return true;
	}
	
	private static boolean checkDiagonals(int[][] matrix, int sum) {
		int mainSum = 0, secondSum = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			mainSum += matrix[i][i];
			secondSum += matrix[i][matrix.length - 1 - i];
		}
		if (mainSum != sum || secondSum != sum) {
			return false;
		}
		
		return true;
	}
	
	public static boolean magic_square(int[][] matrix) {
		int sum = getSum(matrix);
		
		if (checkRows(matrix, sum) && checkCols(matrix, sum) && checkDiagonals(matrix, sum)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{4,9,2},{3,5,7},{8,1,6}};
		int[][] matrix1 = {{4,92,2},{3,5,7},{8,1,6}};

		System.out.println(magic_square(matrix));
		System.out.println(magic_square(matrix1));
	}

}
