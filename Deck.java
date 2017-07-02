import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Deck {

	/**トランプカードの属性*/
	//トランプカードの色
	String[] crdcolors = {"红桃","方块","梅花","黑桃"};
	//扑克牌の点数
	String[] points = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	//大小王
	static String[] boss = {"大王","小王"};

	//カードリストを生成する
	List crdList = new ArrayList();

	//カードマップを生成する
	Map crdMap = new HashMap();

	/**
	 * トランプカードを作成
	 * @return crdList List
	 */
	public List makeCrdList(){
		for(int i= 0; i < crdcolors.length; i++ ){
			for(int j = 0; j < points.length; j++){
				//基本カード
				String khnCrd = crdcolors[i] + points[j];
				//基本カードをカードリストにセットする
				crdList.add(khnCrd);
			}
		}
		//大王、副王をカードリストにセットする
		crdList.add(boss[0]);
		crdList.add(boss[1]);
		return crdList;
	}

	/**
	 * トランプカードの数をチェックする
	 * @param crd List
	 */
	public boolean checkCrdSize(List crd){
		if(54 == crd.size()){
			return true;
		}else{
			System.out.println("トランプカードの数が違います。");
			return false;
		}
	}

	/**
	 * トランプカードをMapにセットする
	 * @param crd List
	 * @return
	 */
	public Map setCrdMap(List crd){

		for(int i = 0; i < crd.size(); i++){
			//トランプカードをMapにセットする
			crdMap.put(crd.get(i),crd.get(i));
		}
		return crdMap;
	}

	/**
	 * 洗牌1方法
	 * @param deck
	 */
	public void shuffle1(Deck deck){
		List list = deck.makeCrdList();
		//前の27枚トランプカードを格納用list
		List beforeCrdList = new ArrayList();
		//後の27枚トランプカードを格納用list
		List afterCrdlist = new ArrayList();
		//shuffle1後のトランプカードを格納用list
		List list1 = new ArrayList();

		//トランプカードの枚数が54枚の場合
		if(deck.checkCrdSize(list)){

			for(int i = 0; i < list.size(); i++){
				//前の27枚トランプカードを作成
				if(i < 27){
					beforeCrdList.add(list.get(i));
				//後の27枚トランプカードを作成
				}else{
					afterCrdlist.add(list.get(i));
				}
			}
			//shuffle後のトランプカードを作成
			for(int j = 0; j < beforeCrdList.size(); j++){
				list1.add(beforeCrdList.get(j));
				list1.add(afterCrdlist.get(j));
			}
		}
		crdList = list1;
	}

	/**
	 * 洗牌2方法
	 */
	public void shuffle2(){

		Calendar cld = Calendar.getInstance();
		//システム時間の豪秒を取得する
		int mil = cld.get(cld.MILLISECOND);

		String mi = Integer.toString(mil);
		//システム時間の豪秒の最後2位を取得する
		String mi2 = mi.substring(mi.length()-2, mi.length());
		int mi3 = Integer.parseInt(mi2);
		if(mi3 < 10){
			mi3 = mi3 * 10;
		}
		Deck d = new Deck();
		for(int i = 0; i < mi3; i++){
			shuffle1(d);
		}
	}

	/**
	 * 洗牌2方法
	 *
	 */
	public void shuffle3(){
		Random rand = new Random();
		//999999999~1999999998範囲のランダム数字を生成する
		int randNum = rand.nextInt(999999999) + 999999999;

		Deck d = new Deck();
		for(int i = 0; i < randNum; i++){
			shuffle1(d);
		}
	}

	/**
	 *取牌方法
	 * @return
	 */
	public Card pop(){
		Card c = new Card();
		List List = makeCrdList();
		//一番前のトランプカードを削除する
		List.remove(0);

		crdList = List;
		return c;
	}

	/**
	 * 发牌方法
	 * @param player
	 * @param deck
	 */
	public void deal(List player, Deck deck){
		//プレーヤを生成する
		List[] playerList = new List[player.size()];
		int k=0;
		List crd = deck.makeCrdList();
		for(int i = 0; i < crd.size(); i++){
			for(int j = 0; j < player.size(); j++){
				playerList[j].add(crd.get(k));
				k++;
			}
			if(k == 54){
				return;
			}
		}
	}
}
