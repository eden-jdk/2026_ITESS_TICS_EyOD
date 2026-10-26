import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ValidPalindromeOptimal {
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

        int left = 0;
        int right = s.length() - 1;
        boolean esPalindromo = true;

        // Recorrer con dos punteros hacia el centro O(n)
        while (left < right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);

            // Si el carácter de la izquierda no es alfanumérico, avanzar
            if (!Character.isLetterOrDigit(cLeft)) {
                left++;
            } 
            // Si el carácter de la derecha no es alfanumérico, retroceder
            else if (!Character.isLetterOrDigit(cRight)) {
                right--;
            } 
            // Ambos son alfanuméricos, comparar ignorando mayúsculas/minúsculas
            else {
                if (Character.toLowerCase(cLeft) != Character.toLowerCase(cRight)) {
                    esPalindromo = false;
                    break;
                }
                left++;
                right--;
            }
        }

        System.out.println(esPalindromo ? "true" : "false");
    }

    public static void main(String[] args) {
        ValidPalindromeOptimal solver = new ValidPalindromeOptimal();
        solver.leerDatos();
        solver.resuelve();
    }   
}