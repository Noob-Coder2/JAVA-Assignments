import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] m = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                m[i][j] = sc.nextInt();

        int r1 = m.length, c1 = m[0].length;

        for (int i = 0; i < r1; i++)
            for (int j = 0; j < c1 / 2; j++) {
                int temp = m[i][j];
                m[i][j] = m[i][c1 - 1 - j];
                m[i][c1 - 1 - j] = temp;
            }

        for (int[] row : m) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}