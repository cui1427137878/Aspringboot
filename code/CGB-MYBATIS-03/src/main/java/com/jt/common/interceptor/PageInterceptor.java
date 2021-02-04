package com.jt.common.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

@Intercepts(@Signature(type = StatementHandler.class, 
                       method = "prepare", args = {Connection.class,Integer.class}))
public class PageInterceptor implements Interceptor{
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		RoutingStatementHandler rHandler=
		(RoutingStatementHandler)invocation.getTarget();
		MetaObject metaObject=
		MetaObject.forObject(rHandler,//StatementHandler
				SystemMetaObject.DEFAULT_OBJECT_FACTORY, //objectFactory
				SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, //objectWrapperFactory
				new DefaultReflectorFactory());//reflectorFactory
		MappedStatement mappedStatement = 
		(MappedStatement)metaObject.getValue("delegate.mappedStatement");
		String id=mappedStatement.getId();
		System.out.println("id="+id);
		if(id.matches(".+findPageObjects$")) {
			BoundSql boundSql = rHandler.getBoundSql();
            // 原始的SQL语句
            String sql = boundSql.getSql();
            // 查询总条数的SQL语句
            String countSql = "select count(*) from (" + sql + ") a";
            System.out.println("countSql="+countSql);
            //执行总条数SQL语句的查询
            Connection connection = (Connection)invocation.getArgs()[0];
            PreparedStatement countStatement =
            connection.prepareStatement(countSql);
            //获取参数信息即where语句的条件信息，注意上面拿到的sql中参数还是用?代替的
            ParameterHandler parameterHandler =
            (ParameterHandler)metaObject.getValue("delegate.parameterHandler");
            parameterHandler.setParameters(countStatement);
            ResultSet rs = countStatement.executeQuery();
            int count=0;
            if(rs.next()) {
            	count=rs.getInt(1);
            	System.out.println("count="+count);
            }
           /* Map<?,?> parameter = (Map<?,?>)boundSql.getParameterObject();
            if(parameter!=null) {
            Integer startIndex = (Integer)parameter.get("startIndex");
            Integer pageSize = (Integer)parameter.get("pageSize");
            if(startIndex==null)startIndex=0;
            if(pageSize==null)pageSize=count;
            // 改造后带分页查询的SQL语句
            String pageSql = sql + " limit " + startIndex + "," + pageSize;
            System.out.println("pageSql="+pageSql);
            metaObject.setValue("delegate.boundSql.sql", pageSql);
            }*/
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		System.out.println("setProperties");
	}

}
