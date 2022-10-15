package practice.springmvcpractice.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Employee {
    private String fname;
    private String minit;
    private String lname;
    private String ssn;
    private String bdate;
    private String address;
    private String sex;
    private String salary;
    private String superSsn;
    private String dno;

    public Employee(String fname, String minit, String lname, String ssn, String bdate,
                    String address, String sex, String salary, String superSsn, String dno) {
        this.fname = fname;
        this.minit = minit;
        this.lname = lname;
        this.ssn = ssn;
        this.bdate = bdate;
        this.address = address;
        this.sex = sex;
        this.salary = salary;
        this.superSsn = superSsn;
        this.dno = dno;
    }

}
