
public class joinstrings {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int N = io.getInt();
        numberLink[] numberLinksArray = new numberLink[N + 1];
        for (int i = 0; i < N; i++) {
            numberLinksArray[i + 1] = new numberLink(io.getWord());
        }
        int first = 1;
        for (int i = 0; i < N - 1; i++) {
            first = io.getInt();
            numberLinksArray[first].setNextNumber(numberLinksArray[io.getInt()]);
        }
        System.out.println(numberLinksArray[first].getWordOmni());
    }
}

class numberLink {
    String word;
    numberLink nextNumber = null;
    tailFlag tailnumber = new tailFlag(this);

    public numberLink(String word) {
        this.word = word;
    }

    public numberLink getNextNumber() {
        return nextNumber;
    }

    public void setNextNumber(numberLink nextNumber) {
        numberLink temp = this.tailnumber.getTailNumber();
        this.tailnumber.setTailNumber(nextNumber);
        temp.forceNextNumber(nextNumber);
    }

    public void forceNextNumber(numberLink nextNumber) {
        this.nextNumber = nextNumber;
    }

    public String getWord() {
        return word;
    }

    public String getWordOmni() {
        if (this.getNextNumber() == null) {
            return this.getWord();
        } else {
            return this.getWord() + this.getNextNumber().getWordOmni();
        }
    }
}

class tailFlag {
    numberLink tailNumber = null;

    public tailFlag(numberLink tailNumber) {
        this.tailNumber = tailNumber;
    }

    public numberLink getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(numberLink tailNumber) {
        this.tailNumber = tailNumber;
    }
}

