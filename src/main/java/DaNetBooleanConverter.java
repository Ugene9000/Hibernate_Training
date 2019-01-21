import javax.persistence.AttributeConverter;

public class DaNetBooleanConverter implements AttributeConverter<Boolean, String> {

	public String convertToDatabaseColumn(Boolean attribute) {
		return attribute?"DA":"NET";
	}

	public Boolean convertToEntityAttribute(String dbData) {
		return "DA".equals(dbData);
	}
}
