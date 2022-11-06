import java.util.Random;
public class Main {
    public static int nThreads = 1;
    //修改nThreads改变使用的线程数
    public static int length = 1000;
    public static int indexFrom = 0;
    public static int[][] array1 = new int[length][length];
    public static int[][] array2 = new int[length][length];
    public static int[][] result = new int[length][length];
    public static long startTime;
    public static long endTime = 0;
    public static void main(String[] args) {
        Matrix.getValue(array1);
        Matrix.getValue(array2);
        MatrixMultiplicationThread thread = new MatrixMultiplicationThread();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < nThreads; i++) {
            new Thread(thread).start();
        }
    }
}
class Matrix {
    private final static Random rand = new Random();
    public static void getValue(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = rand.nextInt(1000); //值不要太大，防止溢出（虽然好像还是有溢出的可能（雾
            }
        }
    }
    public static void MatrixMultiplication(int[][] array1, int[][] array2, int[][] result, int indexFrom, int indexEnd) {
        int sum;
        for (int i = 0; i < Main.length; i++) {
            for (int j = indexFrom; j < indexEnd; j++) { //方阵，行列长度相同
                sum = 0;
                for (int k = 0; k < Main.length; k++) {
                    sum += array1[i][k] * array2[k][j];
                }
                result[i][j] = sum;
            }
        }
    }
}
class MatrixMultiplicationThread implements Runnable {
    public void run()
    {
        int indexFrom = Main.indexFrom;
        int indexEnd = Main.indexFrom + Main.length / Main.nThreads - 1 == Main.length - 1 ? Main.length - 1 : Main.indexFrom + Main.length / Main.nThreads - 1;
        //防止当Main.length无法整除nThreads时少计算一个值
        Main.indexFrom += Main.length / Main.nThreads;
        Matrix.MatrixMultiplication(Main.array1, Main.array2, Main.result, indexFrom, indexEnd);
        Main.endTime = Math.max(System.currentTimeMillis(), Main.endTime);
        System.out.println("花费时间：" + (Main.endTime - Main.startTime) + "ms");
    }
}