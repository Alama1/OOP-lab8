package game;

import lexicon.LexiconInterface;

public class HangmanGame implements HangmanGameInterface {
	private int guessCount;
	private int correctGuessCount;
	private int incorrectGuessCount;
	private String word;
	private String partlyGuessedWord;
	private String guessedLetters;

	public HangmanGame(LexiconInterface l) {
		guessedLetters = "";
		word = l.getRandomWord();
		partlyGuessedWord = "";
		for (int i = 0; i < word.length(); i++)
			partlyGuessedWord += "-";

	}



	@Override
	public boolean guess(char letter) {
		boolean found = false;
		guessCount++;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == letter) {
				found = true;
				correctGuessCount++;
				System.out.println(correctGuessCount);
				partlyGuessedWord = partlyGuessedWord.substring(0, i) + letter + partlyGuessedWord.substring(i + 1);
				System.out.println(partlyGuessedWord);
				guessedLetters +=letter;
			}

		}
		if (!found){
			incorrectGuessCount++;
			System.out.println(incorrectGuessCount);
		}
		return found;
	}

	@Override
	public String getPartlyGuessedWord() {
		return partlyGuessedWord;
	}

	@Override
	public String getHangmanWord() {
		return word;
	}

	@Override
	public String getGuessedLetters() {
		return guessedLetters;
	}

	@Override
	public boolean isGameLost() {
		if (incorrectGuessCount >= 10) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isGameWon() {
		return partlyGuessedWord.indexOf('-')>=0;
	}

	@Override
	public String getGuessesLeft() {
		return String.valueOf(10 - incorrectGuessCount);

	}

	@Override
	public int getIncorrectGuesses() {
		return incorrectGuessCount;
	}

	@Override
	public int getCorrectGuesses() {
		return correctGuessCount;
	}

	
}
