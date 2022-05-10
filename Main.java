import java.io.*;

public class Main {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();
        Integer word_len = word.length();
        Integer index = 0, answer = 0;
        for (; index <= document.length() - word_len ; index++) {
            String doc_piece = document.substring(index, index + word_len);
            if (doc_piece.equals(word)) {
                answer += 1;
                index += ( word_len - 1 );
            }
        }

        System.out.print(answer);
    }
}

