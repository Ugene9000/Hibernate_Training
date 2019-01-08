import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@ToString
public class Country {

	@Id
	@Column(name = "country_id")
	private long id;

	@Column(name = "country")
	private String name;

}
