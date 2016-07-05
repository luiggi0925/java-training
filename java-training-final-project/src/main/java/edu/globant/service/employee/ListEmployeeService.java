package edu.globant.service.employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import edu.globant.domain.Employee;
import edu.globant.persistence.DAO.EmployeeDAO;
import edu.globant.service.ServiceImpl;

public class ListEmployeeService extends ServiceImpl {

	private EmployeeDAO employeeDAO;

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final static Logger log = LoggerFactory.getLogger(ListEmployeeService.class);

	public ListEmployeeService(Session session) {
		super(session);
		this.employeeDAO = new EmployeeDAO(session);
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public Employee findById(Long id) {
		Employee employee = (Employee) employeeDAO.findById(id);
		return employee;
	}

	public List<String> findAllEmployees() {
		log.info("findAllEmployees()");
		return jdbcTemplate.query("select NAME from EMPLOYEE", new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("NAME");
			}
		});
	}

}
