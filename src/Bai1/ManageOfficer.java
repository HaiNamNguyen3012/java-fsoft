package Bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManageOfficer {
    public List<Officer> officers;
    public ManageOfficer(){
        this.officers = new ArrayList<>();
    }
    public void addOfficer(Officer officer){
        this.officers.add(officer);
    }

    public List<Officer> searchOfficerByName(String name){
        return this.officers.stream().filter(o-> o.getName().contains(name)).collect(Collectors.toList());
    }

    public void showListInfoOfficer(){
        this.officers.forEach(o -> System.out.println(o.toString()));
    }
}
