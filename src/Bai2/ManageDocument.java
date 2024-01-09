package Bai2;

import java.util.ArrayList;
import java.util.List;

public class ManageDocument {
    public List<Document> documents;
    public ManageDocument() {this.documents = new ArrayList<>();}
    public void addDocument(Document document){
        this.documents.add(document);
    }
    public void showInfo(){
        this.documents.forEach(document ->  System.out.println(document.toString()));
    }

    public boolean deleteDocument(String id){
        Document doc = this.documents.stream().filter(document -> document.getId().equals(id)).findFirst().orElse(null);
        if(doc == null){
            return false;
        }
        this.documents.remove(doc);
        return true;
    }

    public void searchByBook(){
        this.documents.stream().filter(doc -> doc instanceof Book).forEach(doc -> System.out.println((doc.toString())));
    }
    public void searchByNewsPaper(){
        this.documents.stream().filter(doc -> doc instanceof NewsPaper).forEach(doc -> System.out.println(doc.toString()));
    }

    public void searchByMagazine(){
        this.documents.stream().filter(doc -> doc instanceof Magazine).forEach(doc -> System.out.println(doc.toString()));
    }

}
