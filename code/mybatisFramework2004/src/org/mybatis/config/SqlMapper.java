package org.mybatis.config;
//对应的Mapper.xml中的select标签
public class SqlMapper {
    String id;
    String sql;
    String resultType;

    @Override
    public String toString() {
        return "SqlMapper{" +
                "id='" + id + '\'' +
                ", sql='" + sql + '\'' +
                ", resultType='" + resultType + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
