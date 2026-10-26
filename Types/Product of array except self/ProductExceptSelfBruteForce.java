import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProductExceptSelfBruteForce {
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

    public void resuelve() {
        int[] answer = new int[n];

        // Fuerza bruta O(n^2): calcular el producto excluyendo el elemento actual
        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    prod *= nums[j];
                }
            }
            answer[i] = prod;
        }

        // Construir la salida formateada
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(i == n - 1 ? "" : " ");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        ProductExceptSelfBruteForce solver = new ProductExceptSelfBruteForce();
        solver.leerDatos();
        solver.resuelve();
    }   
} 