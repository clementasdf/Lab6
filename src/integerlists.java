public class integerlists {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int N = io.getInt();
        for (int i = 0; i < N; i++) {
            interpretor(io.getWord(),io.getInt(),io.getWord(),io);
        }
        io.close();
    }

    static void interpretor(String commands, int numCount,String rawList, Kattio io) {
        String[] list = rawList.substring(1,rawList.length()-1).split(",");
        String[] cmdArray = commands.split("");
        int start = 0;
        int end = list.length;
        int reverseCount = 0;
        for (String dudes: cmdArray) {
            if (dudes.equals("R")) {
                reverseCount++;
            } else if (reverseCount%2 == 0) {
                start++;
            } else {
                end--;
            }
        }
        if (start > list.length || end < 0 || numCount == 0) {
            io.println("error");
        } else {
            io.print("[");
            if (reverseCount%2 == 0) {
                for (int i = start; i < end; i++) {
                    io.print(list[i] + ",");
                }
                io.println("]");
            } else {
                for (int i = end-1; i > start; i--) {
                    io.print(list[i] + ",");
                }
                io.println(list[start] + "]");
            }

        }
    }
}
