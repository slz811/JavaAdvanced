import java.util.Scanner;

public class DiagonalDifference03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = createMatrixFromConsole(size, scanner);
        System.out.println(Math.abs(sumOfMainDiagonal(matrix) - sumOfSecondaryDiagonal(matrix)));

    }

    private static int sumOfSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (c == matrix.length - 1 - r) {
                    sum += matrix[r][c];
                }
            }
        }

        return sum;
    }

    private static int sumOfMainDiagonal(int[][] matrix) {
        int sum = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (r == c) {
                    sum += matrix[r][c];
                }
            }
        }

        return sum;
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
