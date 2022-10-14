package practice.springmvcpractice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import practice.springmvcpractice.domain.Dependent;

import javax.sql.DataSource;

@Repository
public class DependentRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Dependent getDependent(String eSsn, String dependentName) {
        String query = "select * from dependent where essn = ? and dependent_name = ?";
        Object[] param = new Object[]{eSsn, dependentName};
        return this.jdbcTemplate.queryForObject(query,
                (rs, rowNum) -> new Dependent(
                        rs.getString("Essn"),
                        rs.getString("Dependent_name"),
                        rs.getString("sex"),
                        rs.getString("Bdate"),
                        rs.getString("Relationship")
                        ), param);
    }
}
