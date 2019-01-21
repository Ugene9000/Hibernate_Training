public class DbValueUtils {

	private DbValueUtils() {

	}

	public static Integer getDbValue(Enum<?> enumValue) {
		if (enumValue == null) {
			return null;
		}
		DbValue DbValue;
		try {
			DbValue = (DbValue) enumValue.getClass().getField(enumValue.name()).getAnnotation(DbValue.class);
			if (DbValue == null) {
				throw new IllegalArgumentException("Enum value [" + enumValue + "] is not annotated with DbValue");
			}
			return DbValue.value();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <E extends Enum<E>> E getEnumValueByDbValue(Class<E> enumClass, Integer dbValue) {
		if (dbValue == null) {
			return null;
		}
		for (Enum<E> enumValue : enumClass.getEnumConstants()) {
			if (getDbValue(enumValue).equals(dbValue)) {
				return (E) enumValue;
			}
		}
		return null;
	}

}
