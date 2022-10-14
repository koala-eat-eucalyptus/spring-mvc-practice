package practice.springmvcpractice.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DeptLocations {
    private String dNumber;
    private String dLocations;

    public DeptLocations(String dNumber, String dLocations) {
        this.setDNumber(dNumber);
        this.setDLocations(dLocations);
    }
}
