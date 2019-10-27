import java.util.*;

public class Solution22 {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        for(String cpdomain:cpdomains){
            String[] a=cpdomain.split(" ");  //[900,google.mail.com]
            int count=Integer.valueOf(a[0]);   //900
            String s=a[1]; //google.mail.com
            String[] b=s.split("\\.");  //[google,mail,com]
            for(int i=0;i<b.length;i++){
                String[] c=Arrays.copyOfRange(b,i,b.length);
                String subdomain=String.join(".",c);//google.mail.com
                int oldCount=map.getOrDefault(subdomain,0);
                map.put(subdomain,oldCount+count);
            }
        }
        List<String> list=new ArrayList<>();
        for(Map.Entry<String,Integer> e:map.entrySet()){
            int count=e.getValue();
            String s=String.format("%d %s",count,e.getKey());
            list.add(s);
        }
        System.out.println(list);
        //[951 com, 900 google.mail.com, 1 intel.mail.com, 5 org, 5 wiki.org, 901 mail.com, 50 yahoo.com]
    }
}
