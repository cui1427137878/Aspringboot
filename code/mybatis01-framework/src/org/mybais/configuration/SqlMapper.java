package org.mybais.configuration;

//UserMapper.xml
public class SqlMapper {
	String id;
	String resultType;
	String sql;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public SqlMapper(String id, String resultType, String sql) {
		super();
		this.id = id;
		this.resultType = resultType;
		this.sql = sql;
	}

	@Override
	public String toString() {
		return "SqlMapper [id=" + id + ", resultType=" + resultType + ", sql=" + sql + "]";
	}

}
