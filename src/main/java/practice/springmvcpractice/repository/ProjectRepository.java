package practice.springmvcpractice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import practice.springmvcpractice.domain.Project;

import javax.sql.DataSource;

@Repository
public class ProjectRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Project getProject(String pnumber) {
        String query = "select * from project where pnumber = ?";
        String param = pnumber;
        return this.jdbcTemplate.queryForObject(query,
                (rs, rowNum) -> new Project(
                        rs.getString("Pname"),
                        rs.getString("Pnumber"),
                        rs.getString("Plocation"),
                        rs.getString("Dnum")
                        ), param);
    }
}
