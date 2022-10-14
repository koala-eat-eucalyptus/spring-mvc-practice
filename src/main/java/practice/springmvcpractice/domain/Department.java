package practice.springmvcpractice.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Department {
    private String dName;
    private String dNumber;
    private String mgrSsn;
    private String mgrStartDate;

    public Department(String dName, String dNumber, String mgrSsn, String mgrStartDate) {
        this.setDName(dName);
        this.setDNumber(dNumber);
        this.setMgrSsn(mgrSsn);
        this.setMgrStartDate(mgrStartDate);
    }

}
