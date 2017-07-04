import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Card {

	/**作为一张扑克牌，它的属性有：花色 ，数值。大小王是比较特殊的，但也是属于扑克牌*/

	 //扑克牌的花色
	String[] crdcolors = {"红桃","方块","梅花","黑桃"};
	//扑克牌的点数
	String[] points = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	//大小王
	String[] boss = {"大王","小王"};


	/**
	 * 构造方法，做成扑克牌
	 */
	public Card(){
		//声明一个用于装扑克牌的集合
		List cardList = new ArrayList();
		for(int i = 0; i < crdcolors.length; i++){
			for(int j = 0; j < points.length; j++){
				String crd = crdcolors[i] + points[j];
				//把做成的扑克牌放在扑克牌集合中
				cardList.add(crd);
			}
		}
		//基本扑克牌做好后，把大小王也放在扑克牌集合中
		cardList.add(boss[0]);    //大王
		cardList.add(boss[1]);    //小王

		//把装进去的牌打乱顺序
		Collections.shuffle(cardList);
	}
}
