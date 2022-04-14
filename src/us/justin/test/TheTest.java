package us.justin.test;

import org.junit.Test;
import us.justin.*;

import java.util.*;

import static org.junit.Assert.*;

public class TheTest {
    @Test
    public void testCard() {
        Card card = new Card(Faces.ACE, Suits.CLUBS);
        assertEquals("The card has the wrong value!!!", 14, card.getCardValue());
    }

    @Test
    public void testDeck() {
        Deck deck = new Deck();
        assertEquals("The deck is the wrong size!!!", 52, deck.getSize());
    }

    @Test
    public void testIsRoyalFlush() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Faces.ACE, Suits.CLUBS));
        hand.add(new Card(Faces.TEN, Suits.CLUBS));
        hand.add(new Card(Faces.QUEEN, Suits.CLUBS));
        hand.add(new Card(Faces.KING, Suits.CLUBS));
        hand.add(new Card(Faces.JACK, Suits.CLUBS));
        Hand theHand = new Hand(hand);
        assertTrue(CheckHand.isRoyalFlush(theHand));
    }

    @Test
    public void testIsNotRoyalFlush() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Faces.TEN, Suits.CLUBS));
        hand.add(new Card(Faces.JACK, Suits.DIAMONDS));
        hand.add(new Card(Faces.QUEEN, Suits.CLUBS));
        hand.add(new Card(Faces.KING, Suits.CLUBS));
        hand.add(new Card(Faces.ACE, Suits.CLUBS));
        Hand theHand = new Hand(hand);
        assertFalse(CheckHand.isRoyalFlush(theHand));
    }

    @Test
    public void testIsReallyNotRoyalFlush() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Faces.TEN, Suits.CLUBS));
        hand.add(new Card(Faces.JACK, Suits.DIAMONDS));
        hand.add(new Card(Faces.QUEEN, Suits.CLUBS));
        hand.add(new Card(Faces.KING, Suits.CLUBS));
        hand.add(new Card(Faces.SIX, Suits.CLUBS));
        Hand theHand = new Hand(hand);
        assertFalse(CheckHand.isRoyalFlush(theHand));
    }

    @Test
    public void testIsFlush() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Faces.FOUR, Suits.CLUBS));
        hand.add(new Card(Faces.FIVE, Suits.CLUBS));
        hand.add(new Card(Faces.SIX, Suits.CLUBS));
        hand.add(new Card(Faces.SEVEN, Suits.CLUBS));
        hand.add(new Card(Faces.EIGHT, Suits.CLUBS));
        Hand theHand = new Hand(hand);
        assertTrue(CheckHand.isFlush(theHand));
    }

    @Test
    public void testIsFourOfAKind() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Faces.FOUR, Suits.CLUBS));
        hand.add(new Card(Faces.FOUR, Suits.DIAMONDS));
        hand.add(new Card(Faces.EIGHT, Suits.CLUBS));
        hand.add(new Card(Faces.FOUR, Suits.HEARTS));
        hand.add(new Card(Faces.FOUR, Suits.SPADE));
        Hand theHand = new Hand(hand);
        assertTrue(CheckHand.isFourOfAKind(theHand));

        hand = new ArrayList<>();
        hand.add(new Card(Faces.FOUR, Suits.CLUBS));
        hand.add(new Card(Faces.THREE, Suits.DIAMONDS));
        hand.add(new Card(Faces.EIGHT, Suits.CLUBS));
        hand.add(new Card(Faces.FOUR, Suits.HEARTS));
        hand.add(new Card(Faces.FOUR, Suits.SPADE));
        theHand = new Hand(hand);
        assertFalse(CheckHand.isFourOfAKind(theHand));
    }

    @Test
    public void testIsThreeOfAKind() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Faces.FOUR, Suits.CLUBS));
        hand.add(new Card(Faces.THREE, Suits.DIAMONDS));
        hand.add(new Card(Faces.EIGHT, Suits.CLUBS));
        hand.add(new Card(Faces.FOUR, Suits.HEARTS));
        hand.add(new Card(Faces.FOUR, Suits.SPADE));
        Hand theHand = new Hand(hand);
        assertTrue(CheckHand.isThreeOfAKind(theHand));

        hand = new ArrayList<>();
        hand.add(new Card(Faces.FOUR, Suits.CLUBS));
        hand.add(new Card(Faces.THREE, Suits.DIAMONDS));
        hand.add(new Card(Faces.EIGHT, Suits.CLUBS));
        hand.add(new Card(Faces.THREE, Suits.HEARTS));
        hand.add(new Card(Faces.FOUR, Suits.SPADE));
        theHand = new Hand(hand);
        assertFalse(CheckHand.isThreeOfAKind(theHand));
    }
}
