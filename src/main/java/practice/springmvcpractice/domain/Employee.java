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

    public Employee(String fName, String mInit, String lName, String ssn, String bDate,
                    String address, String sex, String salary, String superSsn, String dNo) {
        this.setFName(fName);
        this.setMInit(mInit);
        this.setLName(lName);
        this.setSsn(ssn);
        this.setBDate(bDate);
        this.setAddress(address);
        this.setSex(sex);
        this.setSalary(salary);
        this.setSuperSsn(superSsn);
        this.setDNo(dNo);
    }

}
