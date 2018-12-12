package sample;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	static List<Card> cards = new ArrayList<Card>();
	List<Card> cards2 = new ArrayList<Card>();
	public int Nokori = 55;
	Card card = null;
	String mark = null;
	public boolean isHigh = false;

	// デッキの初期化
	public void InitDeck() {

		for (int i = 1; i <= 14; i++) {
			if (i == 14) {
				mark = "JOKER";
				Card joker1 = new Card(14, mark);
				Card joker2 = new Card(14, mark);
				cards.add(joker1);
				cards.add(joker2);
				break;
			}

			for (int n = 0; n < 4; n++) {
				if (n == 0) {
					mark = "ハート";
				}
				if (n == 1) {
					mark = "ダイヤ";
				}
				if (n == 2) {
					mark = "クローバー";
				}
				if (n == 3) {
					mark = "スペード";
				}
				if (n >= 4) {
					n = 0;
				}

				Card card = new Card(i, mark);
				cards.add(card);
			}
		}
		Collections.shuffle(cards);
	}

	// デッキからカードを引く
	public Card CardDraw() {
		card = cards.get(0);
		cards.remove(0);
		return card;
	}

	// 残りのカード枚数
	public int NokoriCard() {
		Nokori = cards.size();
		return Nokori;
	}

	// 引いた中での最大値を返す
	public int MaxNumber(int beforeNumber) {
		int maxNumber = beforeNumber;
		if (card.getNumber() > maxNumber) {
			maxNumber = card.getNumber();
		}
		return maxNumber;
	}

}