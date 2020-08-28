package processor;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Main {
    private static void add(Scanner scanner) {
        System.out.print("Enter size of first matrix: ");
        final int rows = scanner.nextInt();
        final int cols = scanner.nextInt();
        System.out.println("Enter first matrix: ");

        double[][] matA = new double[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; j++) {
                matA[i][j] = scanner.nextDouble();
            }
        }

        final int rowsB = scanner.nextInt();
        final int colsB = scanner.nextInt();

        double [][] matB = new double[rowsB][colsB];

        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matB[i][j] = scanner.nextDouble();
            }
        }

        if (rows != rowsB || cols != colsB) {
            System.out.println("ERROR");
            return;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print((matA[i][j] + matB[i][j]) + " ");
            }
            System.out.println();
        }
    }
    private static void scale(Scanner scanner) {
        System.out.print("Enter size of first matrix: ");
        final int rows = scanner.nextInt();
        final int cols = scanner.nextInt();
        System.out.println("Enter first matrix: ");

        int[][] matA = new int[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; j++) {
                matA[i][j] = scanner.nextInt();
            }
        }

        final int c = scanner.nextInt();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print((matA[i][j] * c) + " ");
            }
            System.out.println();
        }
    }
    private static void scaled(double detInverted, double[][] cT) {
        for (int i = 0; i < cT.length; i++) {
            for (int j = 0; j < cT[i].length; j++) {
                System.out.print( detInverted * cT[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void multiply(@NotNull Scanner scanner) {
        System.out.print("Enter size of first matrix: ");
        final int rows = scanner.nextInt();
        final int cols = scanner.nextInt();
        System.out.println("Enter first matrix: ");

        double[][] matA = new double[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; j++) {
                matA[i][j] = scanner.nextDouble();
            }
        }

        System.out.print("Enter size of second matrix: ");
        final int rowsB = scanner.nextInt();
        final int colsB = scanner.nextInt();
        System.out.println("Enter second matrix: ");

        double [][] matB = new double[rowsB][colsB];

        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matB[i][j] = scanner.nextDouble();
            }
        }

        if (cols != rowsB) {
            System.out.println("ERROR");
            return;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colsB; j++) {
                double sum = 0;
                for (int k = 0; k < cols; k++) {
                    sum += matA[i][k]*matB[k][j];
                }
                System.out.print(sum + " ");
            }
            System.out.println();
        }

    }
    private static void transpose(@NotNull Scanner scanner) {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");

        System.out.print("Your choice: ");
        final int type = scanner.nextInt();
        System.out.println();

        System.out.print("Enter matrix size: ");
        final int rows = scanner.nextInt();
        final int cols = scanner.nextInt();
        System.out.println();

        double[][] matA = new double[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; j++) {
                matA[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("The result is:");
        if (type == 1) {
            transposeMain(matA, rows, cols);
        } else if (type == 2) {
            transposeSide(matA, rows, cols);
        } else if (type == 3) {
            transposeVertical(matA, rows, cols);
        } else if (type == 4) {
            transposeHorizontal(matA, rows, cols);
        }
    }

    private static void transposed(double[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = i + 1; j < mat[i].length; j++) {
                final double temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;

            }
        }
    }
    private static void transposeMain(double[][] matA, int rows, int cols) {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(matA[j][i] + " ");
            }
            System.out.println();
        }
    }
    private static void transposeSide(double[][] matA, int rows, int cols) {
        for (int i = cols - 1; i >= 0; i--) {
            for (int j = rows - 1; j >= 0; j--) {
                System.out.print(matA[j][i] + " ");
            }
            System.out.println();
        }
    }
    private static void transposeVertical(double[][] matA, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = cols - 1; j >= 0; j--) {
                System.out.print(matA[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void transposeHorizontal(double[][] matA, int rows, int cols) {
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matA[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void calcDeterminant(@NotNull Scanner scanner) {
        System.out.print("Enter matrix size: ");
        final int rows = scanner.nextInt();
        final int cols = scanner.nextInt();
        System.out.println("Enter matrix: ");

        double[][] matA = new double[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; j++) {
                matA[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("The result is: ");
        System.out.println(doDet(matA));
    }

    private static double doDet(double[][] matA) {
        if (matA.length == 2) {
            return matA[0][0] * matA[1][1] - matA[0][1]*matA[1][0];
        }
        double res = 0;
        for (int i = 0; i < matA.length; i++) {
            res += matA[0][i] * doDet(makeMinor(matA,0, i)) * Math.pow(-1, i);
        }

        return res;
    }

    private static double[][] makeMinor(double [][]mat, int row, int col) {
        double[][] matMinor = new double[mat.length - 1][mat.length - 1];
        for (int i = 0; i < matMinor.length; i++) {
            for (int j = 0; j < matMinor[i].length; j++) {
                matMinor[i][j] = mat[row > i ? i : i + 1][col > j ? j : j + 1];
            }
        }

        return matMinor;
    }

    private static void inverseMatrix(Scanner scanner) {
        System.out.print("Enter matrix size: ");
        final int rows = scanner.nextInt();
        final int cols = scanner.nextInt();
        System.out.println("Enter matrix: ");

        double[][] matA = new double[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; j++) {
                matA[i][j] = scanner.nextDouble();
            }
        }

        double[][] cT = new double[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; j++) {
                cT[i][j] = Math.pow(-1, i + j) * doDet(makeMinor(matA, i, j));
            }
        }

        transposed(cT);

        final double detInverted = 1.0/doDet(matA);

        System.out.println("The result is: ");
        scaled(detInverted, cT);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix to a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("5. Calculate a determinant");
        System.out.println("6. Inverse a matrix");
        System.out.println("0. Exit");

        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        while (choice != 0) {
            switch (choice) {
                case 1:
                    add(scanner);
                    break;
                case 2:
                    scale(scanner);
                    break;
                case 3:
                    multiply(scanner);
                    break;
                case 4:
                    transpose(scanner);
                    break;
                case 5:
                    calcDeterminant(scanner);
                    break;
                case 6:
                    inverseMatrix(scanner);
                    break;
                default:
                    break;
            }

            System.out.print("Your choice: ");
            choice = scanner.nextInt();
        }

    }
}
