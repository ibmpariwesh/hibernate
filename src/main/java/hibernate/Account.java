package hibernate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Account {
	private Integer id;
	private Integer number;
	@OneToOne
	private Employee employee;
}
