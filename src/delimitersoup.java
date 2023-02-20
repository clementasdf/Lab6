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
        Boolean enteredFlag = false;
        String result = null;
        int i = 0;
        while (!enteredFlag && i < N) {
            String input = brakarray[i];
            if (Objects.equals(input, "(") || Objects.equals(input, "{") || Objects.equals(input, "[")) {
                brakstak.push(input);
            } else if (!input.equals(" ")) {
                if (brakstak.isEmpty()) {
                    result = (input + " " + i);
                    enteredFlag = true;
                } else {
                    switch (input) {
                        case ")":
                            if (!brakstak.pop().equals("(")) {
                                result = (input + " " + i);
                                enteredFlag = true;
                            }
                            break;
                        case "}":
                            if (!brakstak.pop().equals("{")) {
                                result = (input + " " + i);
                                enteredFlag = true;
                            }
                            break;
                        case "]":
                            if (!brakstak.pop().equals("[")) {
                                result = (input + " " + i);
                                enteredFlag = true;
                            }
                            break;
                    }
                }

            }
            i++;
        }
        if (!enteredFlag) {
            System.out.println("ok so far");
        } else {
            System.out.println(result);
        }

    }
}