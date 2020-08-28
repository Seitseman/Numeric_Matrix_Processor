import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String string = scanner.nextLine();
        final int start = scanner.nextInt();
        final int end = scanner.nextInt();
        System.out.println(string.substring(start, end + 1));
    }
}