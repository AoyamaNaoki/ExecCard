package sample;

import java.util.ArrayList;
import java.util.List;

public class Run {

	public static void main(String[] args) {

	}

	public static String Exec1() {
		Deck deck = new Deck();
		deck.InitDeck();
		int maxNumber = 0;
		String execStr1 = "";

		// 残り枚数があるときはカードを引く
		while (deck.Nokori > 0) {
			Card card = deck.CardDraw();
			deck.NokoriCard();
			String s = card.getMark() + "の" + card.getNumber();

			maxNumber = deck.MaxNumber(maxNumber);

			// カードのデータを出力する
			String x = card.getHighName();
			if (card.getNumber() == 14) {
				execStr1 = execStr1 + "カードは" + x + "です。" + "<br>\n";
			} else if (card.getIsHigh() == true) {
				execStr1 += "カードは" + card.getMark() + "の" + x + "です。" + "<br>\n";
			} else {
				execStr1 += "カードは" + s + "です。" + "<br>\n";
			}

			// カードのデータを出力する
//			System.out.println("現在の最大の数値は" + maxNumber + "です");
//			System.out.println("残り枚数は" + deck.Nokori + "枚です。");
//			System.out.println();

		}
		return execStr1;
	}

	public static String Exec2() {
		// 2枚のカードの強さ比較
		Deck deck2 = new Deck();
		deck2.InitDeck();
		Card card1 = deck2.CardDraw();
		Card card2 = deck2.CardDraw();
		String execStr2 = null;

		System.out.println("【カード2枚の強さの比較】");

		if (card1.CompareCard(card2) == 1) {
			execStr2 = card1.cardAndNumber() + "の勝ちです";
		} else if (card1.CompareCard(card2) == 0) {
			execStr2 = "引き分けです";
		} else if (card1.CompareCard(card2) == -1) {
			execStr2 = card2.cardAndNumber() + "の勝ちです";
		} else {
			execStr2 = "そのパターンは存在しません";
		}
		System.out.println();
		return execStr2;
	}

	public static String Exec3() {
		// 5枚で最も強いカードの表示
		Deck deck3 = new Deck();
		deck3.InitDeck();
		List<Card> cards3 = new ArrayList<Card>();
		Card strongCard;
		String execStr3 = null;

		for (int i = 0; i < 5; i++) {
			Card card = deck3.CardDraw();
			cards3.add(card);
		}
//
//		Card strongCard = cards3.get(0);
//
//		for (int i = 1; i < 5; i++) {
//			if (strongCard.CompareCard(cards3.get(i)) == -1) {
//				strongCard = cards3.get(i);
//			}
//		}

//		while (cards3.size() > 1) {
//			card1 = cards3.get(0);
//			card2 = cards3.get(1);
//			if (card1.CompareCard(card2) == -1) {
//				cards3.remove(0);
//			} else {
//				cards3.remove(1);
//			}
//		}

		strongCard = Card.CompareCards(cards3);

		System.out.println("【カードを5枚引いて最も強いカードの出力】");
		if (strongCard.getHighName() == "JOKER") {
			execStr3 = "5枚のカードで最も強いカードはJOKERです";
		} else {
			execStr3 = "5枚のカードの中で最も強いのは " + strongCard.getMark() + " の " + strongCard.getNumber() + " です ";
		}

		System.out.println();

		return execStr3;
	}
}
