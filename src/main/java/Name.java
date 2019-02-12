import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
@ToString
public class Name {

private String firstName;

private String lastName;

}
