//重载Object.equals()方法
public class Article {
    public String title;    //书名
    public String author;   //作者
    public String content;  //内容
    public String publishedAt;//出版日期

    @Override
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }

        if(!(obj instanceof Article)){
            return false;
        }

        if(this==obj){
            return true;
        }

        Article a=(Article)obj;
        if(!title.equals(a.title)){
            return false;
        }

        if(!author.equals(a.author)){
            return false;
        }

        if(!content.equals(a.content)){
            return false;
        }

        return publishedAt.equals(a.publishedAt);
    }

}
