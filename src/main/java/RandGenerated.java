import org.hibernate.annotations.ValueGenerationType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ValueGenerationType(generatedBy = RandGenerator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface RandGenerated {



}
