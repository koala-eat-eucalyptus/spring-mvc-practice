package practice.springmvcpractice.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Dependent {
    private String eSsn;
    private String dependentName;
    private String sex;
    private String bDate;
    private String relationship;

    public Dependent(String eSsn, String dependentName, String sex, String bDate, String relationship) {
        this.setESsn(eSsn);
        this.setDependentName(dependentName);
        this.setSex(sex);
        this.setBDate(bDate);
        this.setRelationship(relationship);
    }
}
