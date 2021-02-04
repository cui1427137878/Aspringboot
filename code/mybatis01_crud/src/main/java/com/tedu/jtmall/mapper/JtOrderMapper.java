package com.tedu.jtmall.mapper;

import com.tedu.jtmall.pojo.JtOrder;
import com.tedu.jtmall.pojo.JtOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JtOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jt_order
     *
     * @mbg.generated Thu Sep 17 14:46:38 CST 2020
     */
    long countByExample(JtOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jt_order
     *
     * @mbg.generated Thu Sep 17 14:46:38 CST 2020
     */
    int deleteByExample(JtOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jt_order
     *
     * @mbg.generated Thu Sep 17 14:46:38 CST 2020
     */
    int deleteByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jt_order
     *
     * @mbg.generated Thu Sep 17 14:46:38 CST 2020
     */
    int insert(JtOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jt_order
     *
     * @mbg.generated Thu Sep 17 14:46:38 CST 2020
     */
    int insertSelective(JtOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jt_order
     *
     * @mbg.generated Thu Sep 17 14:46:38 CST 2020
     */
    List<JtOrder> selectByExample(JtOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jt_order
     *
     * @mbg.generated Thu Sep 17 14:46:38 CST 2020
     */
    JtOrder selectByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jt_order
     *
     * @mbg.generated Thu Sep 17 14:46:38 CST 2020
     */
    int updateByExampleSelective(@Param("record") JtOrder record, @Param("example") JtOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jt_order
     *
     * @mbg.generated Thu Sep 17 14:46:38 CST 2020
     */
    int updateByExample(@Param("record") JtOrder record, @Param("example") JtOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jt_order
     *
     * @mbg.generated Thu Sep 17 14:46:38 CST 2020
     */
    int updateByPrimaryKeySelective(JtOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jt_order
     *
     * @mbg.generated Thu Sep 17 14:46:38 CST 2020
     */
    int updateByPrimaryKey(JtOrder record);
}