import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContainsDuplicateBruteForce {
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
            nums[i] = reader.nextInt(); // Elementos del arreglo
        }
    }

    public void resuelve() {
        boolean duplicado = false;

        // Doble bucle para comparar cada elemento con los demás O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    duplicado = true;
                    break;
                }
            }
            if (duplicado) break;
        }

        // Imprime true o false según los requerimientos del problema
        if (duplicado) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void main(String[] args) {
        ContainsDuplicateBruteForce solver = new ContainsDuplicateBruteForce();
        solver.leerDatos();
        solver.resuelve();
    }   
}