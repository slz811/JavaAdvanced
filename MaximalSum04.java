import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];


        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }


        int maxSum = Integer.MIN_VALUE;
        int row = 0;
        int col = 0;
        for (int r = 1; r < matrix.length - 1; r++) {
            for (int c = 1; c < matrix[r].length - 1; c++) {
                int sum = getSum(matrix, r, c);

                if (sum > maxSum) {
                    maxSum = sum;
                    row = r;
                    col = c;
                }
            }
        }


        System.out.printf("Sum = %d%n", maxSum);
        row--;
        col--;
        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static int getSum(int[][] matrix, int r, int c) {
        int sum = 0;
        sum += matrix[r][c];

        sum += matrix[r + 1][c];
        sum += matrix[r - 1][c];
        sum += matrix[r][c + 1];
        sum += matrix[r][c - 1];

        sum += matrix[r - 1][c - 1];
        sum += matrix[r - 1][c + 1];
        sum += matrix[r + 1][c - 1];
        sum += matrix[r + 1][c + 1];

        return sum;
    }

    private static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }

    }

    private static int[][] createMatrixFromConsole(int size, Scanner scanner) { // Square matrix
        int[][] matrix = new int[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                matrix[r][c] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
