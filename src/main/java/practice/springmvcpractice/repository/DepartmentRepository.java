package practice.springmvcpractice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import practice.springmvcpractice.domain.Department;
import practice.springmvcpractice.domain.Employee;

import javax.sql.DataSource;

@Repository
public class DepartmentRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Department getDepartment(String dName) {
        String query = "select * from department where Dname = ?";
        String param = dName;
        return this.jdbcTemplate.queryForObject(query,
                (rs, rowNum) -> new Department(
                        rs.getString("Dname"),
                        rs.getString("Dnumber"),
                        rs.getString("Mgr_ssn"),
                        rs.getString("Mgr_start_date")
                        ), param);
    }
}
