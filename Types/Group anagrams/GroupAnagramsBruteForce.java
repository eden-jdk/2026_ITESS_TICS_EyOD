import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class GroupAnagramsBruteForce {
    int n;
    String[] strs;
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
        n = reader.nextInt(); // Cantidad de cadenas
        strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = reader.next();
        }
    }

    // Método auxiliar para comprobar si dos palabras son anagramas ordenando sus caracteres
    boolean sonAnagramas(String a, String b) {
        if (a.length() != b.length()) return false;
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        Arrays.sort(ac);
        Arrays.sort(bc);
        return Arrays.equals(ac, bc);
    }

    public void resuelve() {
        boolean[] visitado = new boolean[n];
        List<List<String>> resultado = new ArrayList<>();

        // Doble bucle para agrupar anagramas por fuerza bruta O(n^2 * k log k)
        for (int i = 0; i < n; i++) {
            if (visitado[i]) continue;
            List<String> grupo = new ArrayList<>();
            grupo.add(strs[i]);
            visitado[i] = true;

            for (int j = i + 1; j < n; j++) {
                if (!visitado[j] && sonAnagramas(strs[i], strs[j])) {
                    grupo.add(strs[j]);
                    visitado[j] = true;
                }
            }
            resultado.add(grupo);
        }

        // Imprimir los grupos resultantes
        for (List<String> grupo : resultado) {
            System.out.println(grupo);
        }
    }

    public static void main(String[] args) {
        GroupAnagramsBruteForce solver = new GroupAnagramsBruteForce();
        solver.leerDatos();
        solver.resuelve();
    }   
}