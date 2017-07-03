
public class Player {

	/**
	 * 洗牌1方法
	 * @param deck
	 */
	public static void shuffle1(Deck deck){
		//扑克牌张数确认
		//如果扑克牌有54张
		if(54 == deck.size()){
			//声明用于装前面27张牌的数组
			String[] crd1 = new String[27];
			//声明用于装后面27张牌的数组
			String[] crd2 = new String[27];

			//把54张牌分成两组，27张牌一组
			for(int i = 0; i < 54; i++){
				//把前面的27张牌放在crd1数组里
				if(i < 27){
					crd1[i] = deck.get(i);
				//把后面的27张牌放在crd2数组里
				}else{
					for(int j = 0; j < 27; j++){
						crd2[j] = deck.get(i);
					}
				}
			}
			//生成一副新的扑克牌
			Deck deck1 = new Deck();
			//把前面27张牌和后面27张牌交替穿插，组成一副新的扑克牌
			for(int i = 0; i < 27; i++){
				deck1.add(crd1[i]);
				deck1.add(crd2[i]);
			}
		}
	}
}
