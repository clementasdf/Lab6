import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;

public class teque {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int lines = io.getInt();
        if (lines != 0) {
            String operation = io.getWord();
            int number = io.getInt();
            tequeObj tequeIni = new tequeObj(number, lines);
            for (int i = 1; i < lines; i++) {
                operation = io.getWord();
                number = io.getInt();
                if (Objects.equals(operation, "get") || Objects.equals(operation, "g") ) {
                    io.println(tequeIni.get(number));
                } else {
                    tequeIni.omniOperator(operation, number);
                }
            }
        }
        io.close();

    }
}


class tequeObj {
    int[] leftArray;
    int[] rightArray;
    int leftMidAdj; // the first index in leftarray that' closest to "mid" that's also empty
    int leftLeft; //empty index furhtest from mid.
    int rightMidAdj;
    int rightRight; //empty index furhtest from mid.
    int leftSize;
    int rightSize;

    public tequeObj(int number, int size) {
        this.leftArray = new int[size * 2 + 1];

        leftArray[size] = number;
        this.leftMidAdj = size + 1;
        this.leftLeft = size - 1;
        this.leftSize = 1;

        this.rightArray = new int[size * 2 + 1];

        this.rightMidAdj = size;
        this.rightRight = size + 1;
        this.rightSize = 0;
    }

    public void omniOperator(String operator, int number) {
        switch (operator) {
            case "push_back":
            case "b":
                push_back(number);
                break;
            case "push_front":
            case "f":
                push_front(number);
                break;
            case "push_middle":
            case "m":
                push_middle(number);
                break;
//            case "get": case "g":
//                get(number);
//                break;
        }
    }


    public void push_front(int number) {
        if (leftSize == rightSize) {
            leftArray[leftLeft] = number;
            leftLeft--;
            leftSize++;
        } else {
            leftArray[leftLeft] = number;
            rightArray[rightMidAdj] = leftArray[leftMidAdj - 1];
            leftArray[leftMidAdj - 1] = Integer.MIN_VALUE;
            leftLeft--;
            leftMidAdj--;
            rightMidAdj--;
            rightSize++;

        }
    }

    public void push_back(int number) {
        if (rightSize + 1 == leftSize) {
            rightArray[rightRight] = number;
            rightRight++;
            rightSize++;
        } else {
            rightArray[rightRight] = number;
            leftArray[leftMidAdj] = rightArray[rightMidAdj + 1];
            rightArray[rightMidAdj + 1] = Integer.MIN_VALUE;
            rightRight++;
            rightMidAdj++;
            leftMidAdj++;
            leftSize++;
        }
    }

    private void push_middle(int number) {
        if (rightSize + 1 == leftSize) {
            rightArray[rightMidAdj] = number;
            rightMidAdj--;
            rightSize++;
        } else {
            leftArray[leftMidAdj] = number;
            leftMidAdj++;
            leftSize++;

        }
    }

    public int get(int desiredIndex) {
        int result;
        if (desiredIndex < leftSize) {
            result = leftArray[leftLeft + 1 + desiredIndex];
        } else {
            result = rightArray[rightMidAdj + 1 + (desiredIndex - leftSize)];
        }
        return result;
    }

}
