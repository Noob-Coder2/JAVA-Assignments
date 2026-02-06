import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                m[i][j] = sc.nextInt();

        // Transpose
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++) {
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }

        // Reverse rows
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n / 2; j++) {
                int temp = m[i][j];
                m[i][j] = m[i][n - 1 - j];
                m[i][n - 1 - j] = temp;
            }

        for (int[] row : m) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}