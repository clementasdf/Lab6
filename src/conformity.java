import java.util.HashMap;

public class conformity {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        HashMap<Integer, Integer> combiMap = new HashMap<>();
        int highestCombiCount = 0;
        int inputCount = io.getInt();
        for (int i = 0; i < inputCount; i++) {
            int currenthash = 0;
            for (int j = 0; j < 5; j++) {
                currenthash += io.getWord().hashCode();
            }
            if (combiMap.get(currenthash) == null) {
                combiMap.put(currenthash, 1);
            } else {
                combiMap.put(currenthash, combiMap.get(currenthash) + 1);
            }
            if (highestCombiCount < combiMap.get(currenthash)) {
                highestCombiCount = combiMap.get(currenthash);
            }
        }
        io.println(highestCombiCount);
        io.close();

    }
}
