package practice.springmvcpractice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import practice.springmvcpractice.domain.Employee;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.List;

@Repository
public class EmployeeRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource)  {
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
                        rs.getString("Super_ssn"),
                        rs.getString("Dno")
                        ), param);
    }

    public List<Employee> getAllEmployee() {
        String query = "select * from Employee";
        return this.jdbcTemplate.query(query,
                (rs, rowNum) -> new Employee(
                        rs.getString("Fname"),
                        rs.getString("Minit"),
                        rs.getString("Lname"),
                        rs.getString("Ssn"),
                        rs.getString("BDate"),
                        rs.getString("Address"),
                        rs.getString("Sex"),
                        rs.getString("Salary"),
                        rs.getString("Super_ssn"),
                        rs.getString("Dno")
                        )
                );
    }

    // parameter로 객체 하나를 받고, Object[] param을 만들 때 this.variable을 사용하는 편이 낫나?
    public void hireEmployee(Object[] info) {
        String query = "insert Employee values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        this.jdbcTemplate.update(query, info);
    }

//    public void fireEmployee(String ssn) {
//        String query = "delete from Employee where ssn = ?";
//        String param = ssn;
//        this.jdbcTemplate.update(query, param);
//    }

    // employee 추가/삭제 만들었고, 정보 변경 만들어야 함!



}