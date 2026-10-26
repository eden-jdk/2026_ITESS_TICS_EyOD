import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TwoSumOptimal {
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
        HashMap<Integer, Integer> map = new HashMap<>();
        int index1 = -1, index2 = -1;

        for (int i = 0; i < n; i++) {
            int complemento = target - nums[i];
            
            // Si el complemento ya está en el mapa, hemos encontrado la solución
            if (map.containsKey(complemento)) {
                index1 = map.get(complemento);
                index2 = i;
                break;
            }
            
            // Guardamos el número actual y su índice en el mapa
            map.put(nums[i], i);
        }

        System.out.println(index1 + " " + index2);
    }

    public static void main(String[] args) {
        TwoSumOptimal solver = new TwoSumOptimal();
        solver.leerDatos();
        solver.resuelve();
    }   
}