package CardsWithPower;

public class Card {
    private CardRanks cardRank;
    private CardSuits cardSuit;

    public Card(CardRanks cardRank, CardSuits cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public int calculatePower() {
        int[] rankPowers = {14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,};
        int[] suitPowers = {0, 13, 26, 39,};
        return rankPowers[this.cardRank.ordinal()] + suitPowers[this.cardSuit.ordinal()];
    }
}
