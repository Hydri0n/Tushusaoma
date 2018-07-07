package cc.hydrion.tushusaoma.Bean;

/**
 * Created by LiFen on 2017/10/28.
 */

public class UtilsBookInfo {
    private String title;
    private String author;
    private String pubdate;
    private String author_intro;
    private String summary;
    private String catalog;
    private String image;
    private String average;
    private int average_num;
    private String price;
    private String isbn10;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public int getAverage_num(){
        return average_num;
    }

    public void setAverage_num(int average_num){
        this.average_num = average_num;
    }

    public String getIsbn10(){
        return isbn10;
    }

    public void setIsbn10(String isbn10){
        this.isbn10 =  isbn10;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPubdate() {
        return pubdate;
    }

    public String getAuthor_intro() {
        return author_intro;
    }

    public String getSummary() {
        return summary;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public void setAuthor_intro(String author_intro) {
        this.author_intro = author_intro;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
}
