package practice.springmvcpractice.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Project {
    private String pName;
    private String pNumber;
    private String pLocation;
    private String dName;

    public Project(String pName, String pNumber, String pLocation, String dName) {
        this.setPName(pName);
        this.setPNumber(pNumber);
        this.setPLocation(pLocation);
        this.setDName(dName);
    }
}
