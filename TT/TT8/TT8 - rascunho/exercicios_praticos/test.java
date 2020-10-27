/**
 * test
 */
public class test {

    public static void main(String[] arg) {
        int i = 0, j = 0, b = 0, n = 1024;
        for (i = 0; i < n; i++) {
            for (j = 1; j <= n; j *= 2) {
                b++;
                System.out.println("b: " + b );
            }
            System.out.println("=================== i: " + b + " ==================");
        }
        System.out.println("b: " + b + "  J: " + j);
    }
}