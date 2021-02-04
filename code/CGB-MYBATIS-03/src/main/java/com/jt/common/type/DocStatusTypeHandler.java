package com.jt.common.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
/**自定义类型转换器*/
public  class DocStatusTypeHandler implements TypeHandler<DocStatus>{
	/**发送sql之前执行：为参数赋值*/
	@Override
	public void setParameter(PreparedStatement ps, int i, DocStatus parameter, JdbcType jdbcType) throws SQLException {
		ps.setInt(i,parameter.getCode());
	}
	/**处理结果时调用*/
	@Override
	public DocStatus getResult(ResultSet rs, String columnName) throws SQLException {
		int code=rs.getInt(columnName);
		return DocStatus.valueOf(code);
	}
	@Override
	public DocStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
		int code=rs.getInt(columnIndex);
		return DocStatus.valueOf(code);
	}
	@Override
	public DocStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
		int code=cs.getInt(columnIndex);
		return DocStatus.valueOf(code);
	}
}
