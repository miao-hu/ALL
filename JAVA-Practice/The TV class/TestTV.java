public class TestTV{
  public static void main(String[] args){
    TV tv1=new TV();
	tv1.turnOn();
	tv1.setChannel(30);
	tv1.setVolume(4);
	//System.out.println(tv1.toString());  
	//直接显示这个类的toString()方法
	//类名@地址
	
	TV tv2=new TV();
	tv2.turnOn();
	tv2.channelUp();
	tv2.channelUp();
	tv2.volumeUp();
	//System.out.println(tv2.toString());
	
	System.out.println("tv1's channel is "+tv1.channel+
						" and volume level is "+tv1.volumeLevel);
	System.out.println("tv2's channel is "+tv2.channel+
						" and volume level is "+tv2.volumeLevel);
						
  }
}
