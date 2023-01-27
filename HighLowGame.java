import java.util.Scanner;

public class HighLowGame {
    public static void main(String[] args) {
        System.out.println("This program lets you play the simple card game of High Low");
        System.out.println("A card will be dealt from the deck of cards.");
        System.out.println("And you have to predict if the next card will be higher or lower.");
        System.out.println("Your score in the game is the total number of correct predictions before you guess wrong.");
        System.out.println();

        int highestScore = 0;
        boolean playAgain = false;

        Scanner scanner = new Scanner(System.in);
        do {
            int scoreThisGame;
            scoreThisGame = play();
            if (scoreThisGame > highestScore) highestScore = scoreThisGame;
            System.out.println("Play Again? Enter true to keep playing and false to exit");
            playAgain = scanner.nextBoolean();
        }
        while (playAgain);

        System.out.println();
        System.out.println("Your highest score was: " + highestScore);
    }

    private static int play() {
        CardDeck deck = new CardDeck();
        Card currCard;
        Card nextCard;
        int correctGuesses;
        String guess;
        deck.shuffle();
        correctGuesses = 0;
        currCard = deck.dealCard();
        System.out.println("The first card is " + currCard);

        while (true) {
            System.out.println("Will the next card be higher (H) or lower (L)?");
            Scanner scanner = new Scanner(System.in);
            do {
                guess = scanner.next();
                if (!guess.equals("H") && !guess.equals("L"))
                    System.out.println("Please respond with H or L");
            }
            while (!guess.equals("H") && !guess.equals("L"));
            nextCard = deck.dealCard();
            System.out.println("The next card is " + nextCard);

            if (nextCard.getValue() == currCard.getValue()) {
                System.out.println("The value is the same");
                System.out.println("You lose on ties. Sorry!");
                break;
            } else if (nextCard.getValue() > currCard.getValue()) {
                if (guess.equals("H")) {
                    System.out.println("The value of is card is higher");
                    System.out.println("You guessed right and scored 1 point");
                    correctGuesses++;
                } else {
                    System.out.println("Your prediction was incorrect");
                    System.out.println("The value of is card is Higher than your card");
                    System.out.println("You lose. Sorry!");
                    break;
                }
            } else {
                if (guess.equals("L")) {
                    System.out.println("You guessed right and scored 1 point");
                    correctGuesses++;
                } else {
                    System.out.println("Your prediction was incorrect");
                    System.out.println("The value of is card is Higher than your card");
                    System.out.println("You lose. Sorry!");
                    break;
                }
            }
            currCard = nextCard;
            System.out.println();
            System.out.println("The card is " + currCard);
        }
        System.out.println();
        System.out.println("The game is over. You guessed " + correctGuesses + " times correctly.");

        return correctGuesses;
    }
}
