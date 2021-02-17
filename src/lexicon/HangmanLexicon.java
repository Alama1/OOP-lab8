package lexicon;

import java.util.Random;

public class HangmanLexicon implements LexiconInterface{

    private String words[] = {"Space", "Oleg"};
    public HangmanLexicon() {
    }

    @Override
    public int getWordCount() {
        return words.length;
    }

    @Override
    public String getWord(int index) {
        String guessWord = words[index];
        String rWord;
        if (index < words.length)
            return guessWord.toUpperCase();
        else
            rWord = getRandomWord();
            return rWord.toUpperCase();
    }

    @Override
    public String getRandomWord() {
        Random random = new Random();
        int i = random.nextInt(words.length);
        return words[i];
    }
}

