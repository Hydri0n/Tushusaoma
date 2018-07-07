package cc.hydrion.tushusaoma.Bean;


public class Comment {
    private String content;
    private String time;
    private String authorId;
    private String bookName;

    public Comment(String content,String time,String authorId,String bookName){
        this.authorId = authorId;
        this.content = content;
        this.time = time;
        this.bookName = bookName;
    }

    public String getContent(){
        return content;
    }

    public String getTime(){
        return time;
    }

    public String getAuthorId(){
        return authorId;
    }

    public String getBookName(){
        return bookName;
    }
}
