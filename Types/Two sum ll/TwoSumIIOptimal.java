import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoSumIIOptimal {
    int n, target;
    int[] numbers;
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
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = reader.nextInt();
        }
        target = reader.nextInt(); // Valor objetivo
    }

    public void resuelve() {
        int left = 0;
        int right = n - 1;
        int index1 = -1, index2 = -1;

        // Técnica de dos punteros O(n)
        while (left < right) {
            int suma = numbers[left] + numbers[right];

            if (suma == target) {
                // Como es 1-indexed, sumamos 1 a los índices reales
                index1 = left + 1;
                index2 = right + 1;
                break;
            } else if (suma < target) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(index1 + " " + index2);
    }

    public static void main(String[] args) {
        TwoSumIIOptimal solver = new TwoSumIIOptimal();
        solver.leerDatos();
        solver.resuelve();
    }   
}