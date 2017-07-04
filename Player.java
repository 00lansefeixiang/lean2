
public class Player {

	//一副牌的总体张数(54)
	private final static int CRD_TOTAL = 54;
	//一副扑克牌的一半张数(27)
	private final static int CRD_HALF = 27;
	/**
	 * 洗牌1方法
	 * @param deck
	 */
	public void shuffle1(Deck deck){
		//扑克牌张数确认
		//如果扑克牌有54张
		if(CRD_TOTAL == deck.size()){
			//声明用于装前面27张牌的数组
			Card[] crd1 = new Card[CRD_HALF];
			//声明用于装后面27张牌的数组
			Card[] crd2 = new Card[CRD_HALF];

			//把54张牌分成两组，27张牌一组
			for(int i = 0; i < CRD_TOTAL; i++){
				//把前面的27张牌放在crd1数组里
				if(i < CRD_HALF){
					crd1[i] = deck.get(i);
				//把后面的27张牌放在crd2数组里
				}else{
					for(int j = 0; j < CRD_HALF; j++){
						crd2[j] = deck.get(i);
					}
				}
			}
			//生成一副新的扑克牌
			Deck deck1 = new Deck();
			//把前面27张牌和后面27张牌交替穿插，组成一副新的扑克牌
			for(int i = 0; i < CRD_HALF; i++){
				deck1.add(crd1[i]);
				deck1.add(crd2[i]);
			}
			//把交替穿插后的牌，重新赋给传进来的扑克牌
			deck = deck1;
		}
	}
}
