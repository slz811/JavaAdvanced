import java.util.Scanner;

public class MatrixOfPalindromes02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] charTrix = createStringTrix(rows, cols);

        printMatrix(charTrix, rows, cols);
    }

    private static String[][] createStringTrix(int rows, int cols) {
        String[][] stringTrix = new String[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                StringBuilder builder = new StringBuilder();
                builder.append((char) ('a' + r)).append((char) ('a' + r + c)).append((char) ('a' + r));
                stringTrix[r][c] = builder.toString();
            }
        }
        return stringTrix;
    }

    private static void printMatrix(String[][] mtrx, int rows, int cols) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(mtrx[r][c] + " ");
            }
            System.out.println();
        }
    }
}