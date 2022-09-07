package assign11;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class laptop {
    
	@Id
	private int id;
	private String type;
	private String specification;
	
	public laptop(int id, String type, String specification) {
		super();
		this.id = id;
		this.type = type;
		this.specification = specification;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	

}
