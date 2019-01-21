import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.DynamicParameterizedType;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;
import java.util.Properties;

public class DbValueType implements UserType, DynamicParameterizedType {

	Class<? extends Enum> enumClass;

	public int[] sqlTypes() {
		return new int[]{Types.INTEGER};
	}

	public Class returnedClass() {
		return null;
	}

	public boolean equals(Object o, Object o1) throws HibernateException {
		return Objects.equals(o, o1);
	}

	public int hashCode(Object o) throws HibernateException {
		return Objects.hashCode(o);
	}

	public Object nullSafeGet(ResultSet resultSet, String[] strings, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
		int intValue = resultSet.getInt(strings[0]);
		if (resultSet.wasNull()) {
			return null;
		}
		return DbValueUtils.getEnumValueByDbValue(enumClass, intValue);
	}


	public void nullSafeSet(PreparedStatement preparedStatement, Object o, int index, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {
		if(o == null) {
			preparedStatement.setNull(index, Types.INTEGER);
		} else {
			Integer dbValue = DbValueUtils.getDbValue((Enum<?>) o);
			preparedStatement.setInt(index, dbValue);
		}
	}

	public Object deepCopy(Object o) throws HibernateException {
		return o;
	}

	public boolean isMutable() {
		return false;
	}

	public Serializable disassemble(Object o) throws HibernateException {
		return (Serializable) o;
	}

	public Object assemble(Serializable serializable, Object o) throws HibernateException {
		return null;
	}

	public Object replace(Object o, Object o1, Object o2) throws HibernateException {
		return null;
	}

	public void setParameterValues(Properties properties) {
		ParameterType parameterType = (ParameterType) properties.get(PARAMETER_TYPE);
		Class<? extends Enum> returnedClass = parameterType.getReturnedClass();
	}
}