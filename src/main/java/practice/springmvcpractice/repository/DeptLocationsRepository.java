package practice.springmvcpractice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import practice.springmvcpractice.domain.DeptLocations;
import practice.springmvcpractice.domain.Employee;

import javax.sql.DataSource;

@Repository
public class DeptLocationsRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public DeptLocations getDeptLocations(String dnumber, String dlocations) {
        String query = "select * from dept_locations where Dnumber = ? and Dlocations = ?";
        Object[] param = new Object[]{dnumber, dlocations};
        return this.jdbcTemplate.queryForObject(query,
                (rs, rowNum) -> new DeptLocations(
                        rs.getString("Dnumber"),
                        rs.getString("Dlocations")
                        ), param);
    }
}
