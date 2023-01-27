public class CardDeck {
    private Card[] deck;
    private int cardsUsed;

    public CardDeck() {
        this(false);
    }

    public CardDeck(boolean includeJokers) {
        if (includeJokers)
            deck = new Card[54];
        else
            deck = new Card[52];
        int cardCt = 0;
        //creating the card deck, looping through setting suits to 0-3 and values to 1-13
        for (int suit = 0; suit <= 3; suit++) {
            for (int value = 1; value <= 13; value++) {
                deck[cardCt++] = new Card(value, suit);
            }
        }
        //if including Jokers set card 52 and 53 to Jokers
        if (includeJokers) {
            deck[52] = new Card(1, Card.JOKER);
            deck[53] = new Card(2, Card.JOKER);
        }
        cardsUsed = 0;
    }

    //shuffle deck of cards
    public void shuffle() {
        for (int i = deck.length - 1; i > 0; i--) {
            int rand = (int) (Math.random() * (i + 1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        cardsUsed = 0;
    }

    //how many cards are left
    public int cardsLeft() {
        return deck.length - cardsUsed;
    }

    //remove next card from deck and return it
    public Card dealCard() {
        if (cardsLeft() == 0) throw new IllegalStateException("No Cards left to deal.");
        return deck[cardsUsed++];

    }
//does this deck have jokers?
    public boolean hasJokers(){
        return (deck.length == 54);
    }

}
