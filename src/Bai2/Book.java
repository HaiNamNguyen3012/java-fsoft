package Bai2;

public class Book extends Document {
    private String author;
    private int numberOfPage;

    public Book(String id, String publisher, int copiesPublished, String author, int numberOfPage){
        super(id, publisher, copiesPublished);
        this.author = author;
        this.numberOfPage = numberOfPage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", numberOfPage=" + numberOfPage +
                ", id='" + id + '\'' +
                ", publisher='" + publisher + '\'' +
                ", copiesPublished='" + copiesPublished + '\'' +
                '}';
    }
}
