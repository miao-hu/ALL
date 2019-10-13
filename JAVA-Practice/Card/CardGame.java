import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/*			一副扑克牌：不含大小鬼
1.买一副牌（按花色A-Z排列）
	ArrayList<Card> deck=new ArrayList<>(52);
	容量：52    实际元素个数：0
	deck.get(0)这个时候是错误的
2.打乱牌
	52张牌[0,51]
	将下标为51的牌与前面[0,50]任意一个下标对应的牌交换
3.玩牌
	五个玩家每个人五张牌，一个人抓一张，一个挨一个人抓
	谁拿到黑桃A就输了
*/
public class CardGame {
    private static final String[] COLORS={"♥","♠","♦","♣"};

    //买牌
    private static List<Card> buyDeck(){
        List<Card> deck=new ArrayList<>(52);//不包括大小王
        for(int i=0;i<4;i++){
            String color=COLORS[i];
            for(int j=1;j<=13;j++){
                int value=j;
                Card card=new Card(value,color);
                deck.add(card);
            }
        }
        return deck;
    }

    //打乱牌
    private static void shuffle(List<Card> deck){
        Random random=new Random(20190911);
        for(int i=deck.size()-1;i>0;i--){  //下标[0,51]
            int r=random.nextInt(i);//生成的随机数在[0,50]之间
            swap(deck,i,r);//交换i和r下标所对应的牌
        }
    }

    private static void swap(List<Card> deck,int i,int j){
        Card temp=deck.get(i);
        deck.set(i,deck.get(j));
        deck.set(j,temp);
    }

    /*普通的交换方法
         private static void swap(Card[] deck, int i, int j){
            Card temp=deck[i];
            deck[i]=deck[j];
            deck[j]=temp;
         }
     */

    //玩牌，谁拿到黑桃A就输了
    private static void play(List<List<Card>> hands){
        Card card=new Card(1,"♠");
        for(int i=0;i<hands.size();i++){
            if(hands.get(i).contains(card)){
                System.out.printf("%d 输了",i);
                break;
            }
        }
    }

    //给五个人手中分别五张牌，取牌顺序一人一张取
    private static void send(List<List<Card>> hands, List<Card> deck, int numPerson, int numCard){
        //调用get()方法之前一定要保证元素是存在的
        for(int i=0;i<numPerson;i++){
            hands.add(new ArrayList<>());
        }
        for(int i=0;i<numCard;i++){
            for(int j=0;j<numPerson;j++){
                Card card=deck.remove(0);//每次取牌的第一张
                hands.get(j).add(card);//给第j个人增加牌card
            }
        }
    }

    public static void main(String[] args) {
        List<Card> deck=buyDeck(); //第一步：买牌
        System.out.println(deck);
        shuffle(deck);          //第二步：打乱牌
        System.out.println(deck);
        List<List<Card>> hands=new ArrayList<>(); //hands相当于二维数组
        send(hands,deck,5,5);//第三步：给5个玩家手中放牌
        System.out.println(hands);

        System.out.println(hands.get(0));//玩家1的牌
        System.out.println(hands.get(1));//玩家2的牌
        System.out.println(hands.get(2));//玩家3的牌
        System.out.println(hands.get(3));//玩家4的牌
        System.out.println(hands.get(4));//玩家5的牌

        play(hands);//第四步:玩牌
    }
}
