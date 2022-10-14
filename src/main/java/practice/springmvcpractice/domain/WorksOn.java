package practice.springmvcpractice.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class WorksOn {
    private String eSsn;
    private String pNo;
    private String hours;

    public WorksOn(String eSsn, String pNo, String hours) {
        this.setESsn(eSsn);
        this.setPNo(pNo);
        this.setHours(hours );
    }
}
