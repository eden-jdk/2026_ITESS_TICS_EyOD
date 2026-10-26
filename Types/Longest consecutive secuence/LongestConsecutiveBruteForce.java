import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestConsecutiveBruteForce {
    int n;
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
    }

    // Método auxiliar de búsqueda lineal O(n)
    boolean contiene(int[] arr, int val) {
        for (int x : arr) {
            if (x == val) return true;
        }
        return false;
    }

    public void resuelve() {
        if (n == 0) {
            System.out.println(0);
            return;
        }

        int maxLen = 0;

        // Fuerza bruta O(n^2): probar cada número como inicio de secuencia
        for (int i = 0; i < n; i++) {
            int currentNum = nums[i];
            int currentStreak = 1;

            while (contiene(nums, currentNum + 1)) {
                currentNum += 1;
                currentStreak += 1;
            }

            maxLen = Math.max(maxLen, currentStreak);
        }

        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        LongestConsecutiveBruteForce solver = new LongestConsecutiveBruteForce();
        solver.leerDatos();
        solver.resuelve();
    }   
}