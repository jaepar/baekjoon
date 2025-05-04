import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] alphabet;
    static char[] code;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        code = new char[L];
        alphabet = new char[C];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alphabet);

        makeCode(0, 0);
    }

    static void makeCode(int CIndex, int LIndex) {
        if (LIndex == L) {
            if (checkCode()) {
                System.out.println(code);
            }
            return;
        }

        for (int i = CIndex; i < C; i++) {
            code[LIndex] = alphabet[i];
            makeCode(i + 1, LIndex + 1);
        }
    }

    static boolean checkCode() {
        int mo = 0;
        int ja = 0;

        for (char c : code) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                mo++;
            else
                ja++;

            if (mo >= 1 && ja >= 2) {
                return true;
            }
        }
        return false;
    }
}