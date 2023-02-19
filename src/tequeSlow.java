import java.io.*;
import java.util.StringTokenizer;

public class tequeSlow {
    public static void main(String[] args) {
        System.out.println("tequeSlow");
        KattioinSlow io = new KattioinSlow(System.in, System.out);
        int lines = io.getInt();
        String operation = io.getWord();
        int number = io.getInt();
        tequeObjSlow tequeIni = new tequeObjSlow(number, lines);
        for (int i = 1; i < lines; i++) {
            operation = io.getWord();
            number = io.getInt();
            tequeIni.omniOperator(operation, number);
//            System.out.println(tequeIni);
        }

    }
}


class tequeObjSlow {
    int[] bigboiArray;
    int front;
    int back;
    int mid;
    int absoluteMid;

    public tequeObjSlow(int number, int size) {
        this.absoluteMid = size;  //no need to add 1 because indexes start at zero you idiot
        this.bigboiArray = new int[2 * size + 1];
        this.front = absoluteMid - 1;
        this.back = absoluteMid + 1;
        this.mid = absoluteMid;

        bigboiArray[absoluteMid] = number;
    }

    public void omniOperator(String operator, int number) {
        switch (operator) {
            case "push_back": case "b":
                push_back(number);
                break;
            case "push_front": case "f":
                push_front(number);
                break;
            case "push_middle": case "m":
                push_middle(number);
                break;
            case "get": case "g":
                get(number);
                break;

        }
    }

    public void push_front(int number) {
        bigboiArray[front] = number;
        front--;
        mid = (front + back) / 2;
    }

    public void push_back(int number) {
        bigboiArray[back] = number;
        back++;
        mid = (front + back) / 2;
    }

    public void push_middle(int number) {
        for (int i = back; i != mid; i--) {
            bigboiArray[i] = bigboiArray[i - 1];
        }
        bigboiArray[mid + 1] = number;
        back++;
        mid = (front + back) / 2;
    }

    public void get(int position) {
        position = position + front + 1;
        System.out.println(bigboiArray[position]);
    }

    @Override
    public String toString() {
        for (int i = front+1; i < back; i++) {
            System.out.print(i-front + ": " + bigboiArray[i]+ " |");
        }
        System.out.println(" ");
        return "";
    }
}


class KattioinSlow extends PrintWriter {
    public KattioinSlow(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public KattioinSlow(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }


    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) {
            }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}