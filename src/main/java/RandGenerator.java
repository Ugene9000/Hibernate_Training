import org.hibernate.Session;
import org.hibernate.tuple.AnnotationValueGeneration;
import org.hibernate.tuple.GenerationTiming;
import org.hibernate.tuple.ValueGenerator;

import java.util.Random;

public class RandGenerator implements AnnotationValueGeneration<RandGenerated> {

	@Override
	public void initialize(RandGenerated randGenerated, Class<?> aClass) {

	}

	@Override
	public GenerationTiming getGenerationTiming() {
		return GenerationTiming.ALWAYS;
	}

	@Override
	public ValueGenerator<String> getValueGenerator() {
		return new ValueGenerator<String>() {
			@Override
			public String generateValue(Session session, Object owner) {
				return "str" + new Random().nextInt();
			}
		};
	}

	@Override
	public boolean referenceColumnInSql() {
		return false;
	}

	@Override
	public String getDatabaseGeneratedReferencedColumnValue() {
		return null;
	}
}
