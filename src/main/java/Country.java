import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
public class Country {

	@Id
	@Column(name = "country_id")
	private long id;

	private String country;

	@Convert(converter = DaNetBooleanConverter.class)
	private Boolean active;

}
