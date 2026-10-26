import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoSumIIBruteForce {
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
        int index1 = -1, index2 = -1;
        boolean encontrado = false;

        // Fuerza bruta O(n^2): evaluar todos los pares posibles
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    // Como es 1-indexed, sumamos 1 a los índices
                    index1 = i + 1;
                    index2 = j + 1;
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) break;
        }

        System.out.println(index1 + " " + index2);
    }

    public static void main(String[] args) {
        TwoSumIIBruteForce solver = new TwoSumIIBruteForce();
        solver.leerDatos();
        solver.resuelve();
    }   
}