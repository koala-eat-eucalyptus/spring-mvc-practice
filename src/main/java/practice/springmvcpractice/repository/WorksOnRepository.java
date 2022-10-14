package practice.springmvcpractice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import practice.springmvcpractice.domain.WorksOn;

import javax.sql.DataSource;

@Repository
public class WorksOnRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public WorksOn getWorksOn(String essn, String pno) {
        String query = "select * from works_on where essn = ? and pno = ?";
        Object[] param = new Object[]{essn, pno};
        return this.jdbcTemplate.queryForObject(query,
                (rs, rowNum) -> new WorksOn(
                        rs.getString("Essn"),
                        rs.getString("Pno"),
                        rs.getString("hours")
                        ), param);
    }
}
