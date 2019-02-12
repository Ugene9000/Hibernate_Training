import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@ToString
public class Actor {

	@Id
	private Long actorId;

	@Embedded
	private Name name;
}
