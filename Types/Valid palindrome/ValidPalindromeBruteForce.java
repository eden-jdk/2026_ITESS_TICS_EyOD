import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ValidPalindromeBruteForce {
    String s;
    FastReader reader = new FastReader();

    static class FastReader {
        BufferedReader b;
        StringTokenizer st; 

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace(); 
                }
            }
            return st.nextToken();
        }

        // Método para leer líneas completas con espacios
        String nextLine() {
            String str = "";
            try {
                if (st != null && st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = b.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace(); 
            }
            return str;
        }
    }

    public void leerDatos() {
        s = reader.nextLine(); // Lee la cadena de texto completa
    }

    public void resuelve() {
        if (s == null) {
            System.out.println("true");
            return;
        }

        // Limpiar la cadena: conservar solo letras y dígitos, pasarlos a minúsculas
        StringBuilder limpio = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                limpio.append(Character.toLowerCase(c));
            }
        }

        String original = limpio.toString();
        String reverso = limpio.reverse().toString();

        // Comparar la cadena limpia con su versión invertida
        if (original.equals(reverso)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void main(String[] args) {
        ValidPalindromeBruteForce solver = new ValidPalindromeBruteForce();
        solver.leerDatos();
        solver.resuelve();
    }   
}