import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class GroupAnagramsOptimal {
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

    public void resuelve() {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Ordenamos los caracteres de la cadena para usarlos como llave única
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Si la llave no existe, inicializamos una nueva lista
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // Agregamos la cadena original a su respectivo grupo
            map.get(key).add(s);
        }

        // Imprimir los grupos de anagramas almacenados en el mapa
        for (List<String> grupo : map.values()) {
            System.out.println(grupo);
        }
    }

    public static void main(String[] args) {
        GroupAnagramsOptimal solver = new GroupAnagramsOptimal();
        solver.leerDatos();
        solver.resuelve();
    }   
}