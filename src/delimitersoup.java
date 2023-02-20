import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Scanner;

public class delimitersoup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String rawinput = scanner.nextLine();
        ArrayDeque<String> brakstak = new ArrayDeque<>(N);
        String[] brakarray = rawinput.split("");
        int i;
        boolean enteredflag = false;
        for (i = 0; i < N; i++) {
            if (!enteredflag) {
                String input = brakarray[i];
                if (Objects.equals(input, "(") || Objects.equals(input, "{") || Objects.equals(input, "[")) {
                    brakstak.push(input);
                } else {
                    try {
                        switch (input) {
                            case "}":
                                if (!brakstak.pop().equals("{")) {
                                    System.out.println(brakarray[i] + " " + i);
                                    enteredflag = true;
                                }
                                break;
                            case "]":
                                if (!brakstak.pop().equals("[")) {
                                    System.out.println(brakarray[i] + " " + i);
                                    enteredflag = true;
                                }
                                break;
                            case ")":
                                if (!brakstak.pop().equals("(")) {
                                    System.out.println(brakarray[i] + " " + i);
                                    enteredflag = true;
                                }
                                break;
                        }
                    } catch (Exception E) {
                        System.out.println(brakarray[i] + " " + i);
                        enteredflag = true;
                        break;
                    }
                }
            }
        }
        if (brakstak.isEmpty() && !enteredflag) {
            System.out.println("ok so far");
        } else if (!brakstak.isEmpty()) {
            System.out.println(brakstak.pop() + " " + i);
        }

    }
}
