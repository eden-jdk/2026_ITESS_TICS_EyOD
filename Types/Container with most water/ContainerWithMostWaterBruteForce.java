import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContainerWithMostWaterBruteForce {
    int n;
    int[] height;
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
        height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = reader.nextInt();
        }
    }

    public void resuelve() {
        long maxWater = 0;

        // Fuerza bruta O(n^2): probar cada par de líneas
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long currentWater = (long) Math.min(height[i], height[j]) * (j - i);
                maxWater = Math.max(maxWater, currentWater);
            }
        }

        System.out.println(maxWater);
    }

    public static void main(String[] args) {
        ContainerWithMostWaterBruteForce solver = new ContainerWithMostWaterBruteForce();
        solver.leerDatos();
        solver.resuelve();
    }   
}