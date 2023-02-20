
public class joinstringsOLD {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int N = io.getInt();
        if (N != 0) {
            numberLink[] numberLinksArray = new numberLink[N + 1];
            for (int i = 0; i < N; i++) {
                numberLinksArray[i + 1] = new numberLink(io.getWord());
            }
            int first = 1;
            for (int i = 0; i < N - 1; i++) {
                first = io.getInt();
                int second = io.getInt();
                numberLinksArray[first].setNextNumber(numberLinksArray[second]);
            }
            numberLink firstDude = numberLinksArray[first];
            while (firstDude != null) {
                io.print(firstDude.word);
                firstDude = firstDude.getNextNumber();
            }
            io.close();
        }
    }
}

class numberLink {
    Kattio io = new Kattio(System.in, System.out);
    String word;
    numberLink nextNumber = null;
    numberLink tailNumber = this;

    public numberLink(String word) {
        this.word = word;
    }

    public numberLink getNextNumber() {
        return nextNumber;
    }

    public void setNextNumber(numberLink nextNumber) {
        numberLink temp = this.tailNumber;
        this.tailNumber = nextNumber.tailNumber;
        temp.nextNumber = nextNumber;
    }
}