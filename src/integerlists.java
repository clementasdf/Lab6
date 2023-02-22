public class integerlists {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int N = io.getInt();
        for (int i = 0; i < N; i++) {
            interpretor(io.getWord(), io.getInt(), io.getWord(), io);
        }
        io.close();
    }

    static void interpretor(String commands, int numCount, String rawList, Kattio io) {
        String[] list = rawList.substring(1, rawList.length() - 1).split(",");
        String[] cmdArray = commands.split("");
        int start = 0;
        int end = numCount;
        int reverseCount = 0;
        for (String dudes : cmdArray) {
            if (dudes.equals("R")) {
                reverseCount++;
            } else if (reverseCount % 2 == 0) {
                start++;
            } else {
                end--;
            }
        }
        if (start > end) {
            io.println("error");
        } else if (start == end) {
            io.println("[]");
        } else if (rawList.equals("[]")) {
            io.println(rawList);
        } else {
            io.print("[");
            if (reverseCount % 2 == 0) {
                for (int i = start; i < end - 1; i++) {
                    io.print(list[i] + ",");
                }
                io.println(list[end - 1] + "]");
            } else {
                for (int i = end - 1; i > start; i--) {
                    io.print(list[i] + ",");
                }
                io.println(list[start] + "]");
            }

        }
    }
}

