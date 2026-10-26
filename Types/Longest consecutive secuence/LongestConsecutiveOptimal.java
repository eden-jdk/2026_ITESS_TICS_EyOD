import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class LongestConsecutiveOptimal {
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
        if (n == 0) {
            System.out.println(0);
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;

        for (int num : set) {
            // Evaluamos únicamente si es el inicio de una secuencia
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Contamos cuántos números consecutivos le siguen en el set
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                maxLen = Math.max(maxLen, currentStreak);
            }
        }

        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        LongestConsecutiveOptimal solver = new LongestConsecutiveOptimal();
        solver.leerDatos();
        solver.resuelve();
    }   
}