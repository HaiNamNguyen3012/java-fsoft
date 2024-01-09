package Bai2;

public class Document {
    protected String id;
    protected String publisher;
    protected int copiesPublished;

    public Document(String id, String publisher, int copiesPublished){
        this.id = id;
        this.publisher = publisher;
        this.copiesPublished = copiesPublished;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getCopiesPublished() {
        return copiesPublished;
    }

    public void setCopiesPublished(int copiesPublished) {
        this.copiesPublished = copiesPublished;
    }
}
