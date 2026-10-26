import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class TopKFrequentBruteForce {
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
        k = reader.nextInt(); // Cantidad de elementos más frecuentes a buscar
    }

    public void resuelve() {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> resultado = new ArrayList<>();

        // Buscar el elemento con mayor frecuencia k veces O(k * U)
        for (int i = 0; i < k; i++) {
            int maxFreq = -1;
            int maxKey = -1;
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() > maxFreq) {
                    maxFreq = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            resultado.add(maxKey);
            countMap.remove(maxKey); // Removemos para hallar el siguiente en la siguiente iteración
        }

        System.out.println(resultado);
    }

    public static void main(String[] args) {
        TopKFrequentBruteForce solver = new TopKFrequentBruteForce();
        solver.leerDatos();
        solver.resuelve();
    }   
}