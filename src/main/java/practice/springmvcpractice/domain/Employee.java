package practice.springmvcpractice.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Employee {
    private String fName;
    private String mInit;
    private String lName;
    private String ssn;
    private String bDate;
    private String address;
    private String sex;
    private String salary;
    private String superSsn;
    private String dNo;

    public Employee(String firstName, String lastName, String ssn, String dno) {
        this.setFName(firstName);
        this.setLName(lastName);
        this.setSsn(ssn);
        this.setDNo(dno);
    }

    public Employee(String firstName, String lastName, String ssn) {
        this.setFName(firstName);
        this.setLName(lastName);
        this.setSsn(ssn);
        this.setDNo("1");
    }
}
