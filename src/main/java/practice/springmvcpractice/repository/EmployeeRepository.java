package practice.springmvcpractice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import practice.springmvcpractice.domain.Employee;

import javax.sql.DataSource;

@Repository
public class EmployeeRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Employee getEmployee(String ssn) {
        String query = "select * from employee where ssn = ?";
        String param = ssn;
        return this.jdbcTemplate.queryForObject(query,
                (rs, rowNum) -> new Employee(
                        rs.getString("Fname"),
                        rs.getString("Minit"),
                        rs.getString("Lname"),
                        rs.getString("Ssn"),
                        rs.getString("BDate"),
                        rs.getString("Address"),
                        rs.getString("Sex"),
                        rs.getString("Salary"),
                        rs.getString("SuperSsn"),
                        rs.getString("Dno")
                        ), param);
    }
}