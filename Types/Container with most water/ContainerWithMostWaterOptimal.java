import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContainerWithMostWaterOptimal {
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
        int left = 0;
        int right = n - 1;
        long maxWater = 0;

        // Técnica de dos punteros O(n)
        while (left < right) {
            long currentWater = (long) Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(maxWater, currentWater);

            // Mover el puntero de la línea más baja hacia el centro
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(maxWater);
    }

    public static void main(String[] args) {
        ContainerWithMostWaterOptimal solver = new ContainerWithMostWaterOptimal();
        solver.leerDatos();
        solver.resuelve();
    }   
}