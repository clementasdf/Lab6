public class joinstrings {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int N = io.getInt();
        wordLinks[] wordLinkArray = new wordLinks[N+1];
        for (int i = 0; i < N; i++) {
            wordLinkArray[i+1] = new wordLinks(io.getWord());
        }
        int first = 1;
        int second;
        for (int i = 0; i < N-1; i++) {
            first = io.getInt();
            second = io.getInt();
            wordLinkArray[first].add(wordLinkArray[second]);
        }
        wordLinks firstLink = wordLinkArray[first];
        while (firstLink != null) {
            io.print(firstLink.word);
            firstLink = firstLink.nextWord;
        }
        io.close();
    }
}

class wordLinks {
    String word;
    wordLinks tailWord;
    wordLinks nextWord;

    public wordLinks(String word) {
        this.word = word;
        this.tailWord = this;
        this.nextWord = null;
    }

    public void add(wordLinks nextLink) {
        this.tailWord.nextWord = nextLink;
        this.tailWord = nextLink.tailWord;
    }
}