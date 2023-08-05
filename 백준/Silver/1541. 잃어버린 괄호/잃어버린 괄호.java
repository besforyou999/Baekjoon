import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        LinkedList<String> numberList = new LinkedList<>();
        LinkedList<String> symbolList = new LinkedList<>();

        String tmp = "";

        for (int i = 0 ; i < line.length() ; i++) {
            String buff = line.substring(i, i + 1);
            if (buff.equals("+") || buff.equals("-")) {
                numberList.add(tmp);
                symbolList.add(buff);
                tmp = "";
            } else {
                tmp += buff;
            }
        }

        numberList.add(tmp);

        for (int i = 0 ; i < symbolList.size() ; i++) {
            String sym = symbolList.get(i);
            if (sym.equals("-"))
                continue;
            else {
                int num1 = Integer.parseInt(numberList.get(i));
                int num2 = Integer.parseInt(numberList.get(i + 1));
                numberList.remove(i);
                numberList.remove(i);
                numberList.add(i, Integer.toString(num1 + num2));
                symbolList.remove(i);
                i--;
            }
        }

        //printlists(numberList, symbolList);

        for (int i = 0 ; i < symbolList.size() ; i++) {
            String sym = symbolList.get(i);
            int num1 = Integer.parseInt(numberList.get(i));
            int num2 = Integer.parseInt(numberList.get(i + 1));
            numberList.remove(i);
            numberList.remove(i);
            numberList.add(i, Integer.toString(num1 - num2));
            symbolList.remove(i);
            i--;
        }

        System.out.println(numberList.get(0));
    }

    static void printlists(LinkedList<String> numberList, LinkedList<String> symbolList) {
        for (String s : numberList) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : symbolList) {
            System.out.println(s + " ");
        }
        System.out.println();

    }
}