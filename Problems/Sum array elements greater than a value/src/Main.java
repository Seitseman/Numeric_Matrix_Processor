import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int sz = scanner.nextInt();
        int arr[] = new int[sz];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        final int n = scanner.nextInt();

        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > n) {
                res += arr[i];
            }
        }

        System.out.println(res);
    }
}