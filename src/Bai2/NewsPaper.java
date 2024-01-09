package Bai2;

public class NewsPaper extends Document{
    private int dayIssue;
    public NewsPaper(String id, String publisher, int copiesPublished, int dayIssue){
        super(id, publisher, copiesPublished);
        this.dayIssue = dayIssue;
    }

    public int getDayIssue() {
        return dayIssue;
    }

    public void setDayIssue(int dayIssue) {
        this.dayIssue = dayIssue;
    }

    @Override
    public String toString() {
        return "NewsPaper{" +
                "dayIssue='" + dayIssue + '\'' +
                ", id='" + id + '\'' +
                ", publisher='" + publisher + '\'' +
                ", copiesPublished='" + copiesPublished + '\'' +
                '}';
    }
}
