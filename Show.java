import java.util.ArrayList;
import java.util.List;


public class Show {

	public static void main(String[] args) {
		//Deckクラスをインスタンス
		Deck deck = new Deck();
		List list = deck.makeCrdList();
		System.out.println(list);
		deck.shuffle2();

		//プレーヤを定義する
		String[] player = {"xiao ming","xiao hong","xiao hua"};
		List playerList = new ArrayList();
		for(int i = 0; i < player.length; i++){
			playerList.add(player[i]);
		}

		//发牌
		deck.deal(playerList, deck);
	}
}
