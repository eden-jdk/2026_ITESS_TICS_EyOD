import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class TopKFrequentOptimal {
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
        // 1. Contar la frecuencia de cada elemento
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 2. Crear las cubetas (Bucket Sort) donde el índice es la frecuencia
        List<Integer>[] buckets = new List[n + 1];
        for (int key : countMap.keySet()) {
            int freq = countMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        // 3. Recoger los k elementos más frecuentes desde la frecuencia más alta
        List<Integer> resultado = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && resultado.size() < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    resultado.add(num);
                    if (resultado.size() == k) break;
                }
            }
        }

        System.out.println(resultado);
    }

    public static void main(String[] args) {
        TopKFrequentOptimal solver = new TopKFrequentOptimal();
        solver.leerDatos();
        solver.resuelve();
    }   
}