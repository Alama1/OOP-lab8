package sample;

import java.net.URL;
import java.util.ResourceBundle;

import game.HangmanGame;
import game.HangmanGameInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lexicon.HangmanLexicon;
import lexicon.LexiconInterface;

import static javafx.application.Application.launch;

public class Controller {
    HangmanLexicon hangmanLexicon = new HangmanLexicon();
    HangmanGame hangmanGame = new HangmanGame(hangmanLexicon);

    @FXML
    private Label gameStatus;

    @FXML
    private Button guessButton;

    @FXML
    private TextField inputField;


    @FXML
    private Label partly_word;

    @FXML
    private Button resetButton;

    @FXML
    private Label guessLeft;

    @FXML
    void initialize() {
        partly_word.setText(hangmanGame.getPartlyGuessedWord());
        guessLeft.setText(hangmanGame.getGuessesLeft());
        guessLeft.setText(hangmanGame.getGuessesLeft());
        guessButton.setOnAction(event ->{
            String getText = inputField.getText();
            char someChar = getText.charAt(0);
            hangmanGame.guess(someChar);
            partly_word.setText(hangmanGame.getPartlyGuessedWord());
            guessLeft.setText(hangmanGame.getGuessesLeft());
            if (hangmanGame.isGameLost()){
                gameStatus.setText("Вы проиграли! Попробуйте снова!");
                guessButton.setVisible(false);
                resetButton.setVisible(true);
            }
            if (!hangmanGame.isGameWon()){
                gameStatus.setText("Ура! Вы победили!");
                guessButton.setVisible(false);
                resetButton.setVisible(true);
            }
        });
        resetButton.setOnAction(event -> {

        });
    }
}
