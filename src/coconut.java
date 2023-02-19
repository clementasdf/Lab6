import java.util.LinkedList;
import java.util.Queue;

public class coconut {
    public static void main(String[] args) {
        KattioinSlow io = new KattioinSlow(System.in, System.out);
        int syllables = io.getInt();
        int people = io.getInt();
        Queue<int[]> peopleQueue = new LinkedList<>();
        for (int i = 0; i < people ; i++) {
            int[] input1 = {3, i + 1, 1};
            peopleQueue.offer(input1);
            int[] input2 = {3, i + 1, 2};
            peopleQueue.offer(input2);
        }
        int[] dude = peopleQueue.remove();
        int[] dude2;
        while (peopleQueue.size() != 0) {
            int syllableCount = 1;
            while (syllableCount != syllables) {
                if (dude[0] == 3) {
                    syllableCount++;
                    peopleQueue.offer(dude);
                    dude = peopleQueue.remove();
                } else {
                    syllableCount += (dude[0] + 2) / 3;
                }
                if (dude[0] != 0) {
                    peopleQueue.offer(dude);
                }
                dude = peopleQueue.remove();
                while (dude[0] == 0) {
                    dude = peopleQueue.remove();
                }
            }

            if (dude[0] == 3) {
                dude[0]--;
                dude2 = peopleQueue.peek();
                assert dude2 != null;
                dude2[0]--;
            } else if (dude[0] > 1) {
                dude[0]--;
                peopleQueue.offer(dude);
                dude = peopleQueue.remove();
            } else {
                dude[0]--;
                dude= peopleQueue.remove();
            }
        }
        System.out.println(dude[1]);
    }
}
