import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ContainsDuplicateOptimal {
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
        HashSet<Integer> vistos = new HashSet<>();
        boolean duplicado = false;

        for (int i = 0; i < n; i++) {
            // Si el número ya está en el conjunto, encontramos un duplicado
            if (vistos.contains(nums[i])) {
                duplicado = true;
                break;
            }
            // Si no está, lo agregamos al conjunto
            vistos.add(nums[i]);
        }

        if (duplicado) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void main(String[] args) {
        ContainsDuplicateOptimal solver = new ContainsDuplicateOptimal();
        solver.leerDatos();
        solver.resuelve();
    }   
}