import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class ThreeSumOptimal {
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
        List<List<Integer>> resultado = new ArrayList<>();
        
        // 1. Ordenar el arreglo es indispensable para usar dos punteros
        Arrays.sort(nums);

        // 2. Iterar fijando un elemento y buscando los otros dos con dos punteros O(n^2)
        for (int i = 0; i < n - 2; i++) {
            // Evitar duplicados para el primer elemento
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int suma = nums[i] + nums[left] + nums[right];

                if (suma == 0) {
                    resultado.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Avanzar y omitir duplicados para el segundo y tercer elemento
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (suma < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        // Imprimir las tripletas encontradas
        for (List<Integer> triplet : resultado) {
            System.out.println(triplet);
        }
    }

    public static void main(String[] args) {
        ThreeSumOptimal solver = new ThreeSumOptimal();
        solver.leerDatos();
        solver.resuelve();
    }   
}