package myPackage

import java.io.Serializable
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Types

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

class JaNeinType implements UserType {
	
	Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor si, Object owner) {
		String value = rs.getString(names[0])
		value == null ? false : (value == 'J' ? true : false)
	}
	
	void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor si) {
		if (value) {
			st.setString(index, "J")
		} else {
			st.setString(index, "N")
		}
	}
	
	Class<Boolean> returnedClass() { Boolean }
	
	int[] sqlTypes() { [Types.CHAR] as int[] }
	
	Object assemble(Serializable cached, Object owner) { cached }
	
	Object deepCopy(Object value) { new Boolean(value) }
	
	Serializable disassemble(Object value) { value }
	
	boolean equals(Object x, Object y) { x == y }
	
	int hashCode(Object x) { x.hashCode() }
	
	boolean isMutable() { true }
	
	Object replace(Object original, Object target, Object owner) { original }
	
}
