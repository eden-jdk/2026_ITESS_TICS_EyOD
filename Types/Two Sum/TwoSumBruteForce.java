import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoSumBruteForce {
    int n;
    int[] nums;
    int target;
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
        n = reader.nextInt(); // Cantidad de elementos
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = reader.nextInt(); // Elementos del arreglo
        }
        target = reader.nextInt(); // Valor objetivo
    }

    public void resuelve() {
        int index1 = -1, index2 = -1;
        boolean encontrado = false;

        // Doble ciclo para evaluar todas las combinaciones posibles O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    index1 = i;
                    index2 = j;
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) break;
        }

        System.out.println(index1 + " " + index2);
    }

    public static void main(String[] args) {
        TwoSumBruteForce solver = new TwoSumBruteForce();
        solver.leerDatos();
        solver.resuelve();
    }   
}