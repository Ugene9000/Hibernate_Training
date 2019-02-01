import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@ToString
@Where(clause = "active = true")
public class Country {

	@Id
	@Column(name = "country_id")
	private long id;

	private String country;

	@Convert(converter = DaNetBooleanConverter.class)
	private Boolean active;

	@Generated(GenerationTime.ALWAYS)
	@Column(name = "last_update")
	private Instant lastUpdate;

	@RandGenerated
	private String rand;

	@PreUpdate
	private void preUpdate() {
		System.out.println("preUpdate");
		rand = "rand";
	}

}
