import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxAverageSubarrayOptimal {
    int n, k;
    int[] nums;
    FastReader reader = new FastReader();

    static class FastReader {
        BufferedReader b;
        StringTokenizer s; 

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace(); 
                }
            }
            return s.nextToken();
        }

        int nextInt() { 
            return Integer.parseInt(next()); 
        }
    }

    public void leerDatos() {
        n = reader.nextInt(); // Tamaño del arreglo
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = reader.nextInt();
        }
        k = reader.nextInt(); // Longitud del subarreglo
    }

    public void resuelve() {
        // 1. Calcular la suma de la primera ventana de tamaño k
        long windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        long maxSum = windowSum;

        // 2. Deslizar la ventana a través del arreglo O(n)
        for (int i = k; i < n; i++) {
            windowSum = windowSum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, windowSum);
        }

        // 3. Obtener el promedio máximo dividiendo entre k
        double maxAverage = (double) maxSum / k;
        System.out.printf("%.5f\n", maxAverage);
    }

    public static void main(String[] args) {
        MaxAverageSubarrayOptimal solver = new MaxAverageSubarrayOptimal();
        solver.leerDatos();
        solver.resuelve();
    }   
}