package com.tedu.mall.mapper;

import com.tedu.mall.pojo.Admin;
import com.tedu.mall.pojo.AdminExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Nov 13 11:05:53 CST 2020
     */
    long countByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Nov 13 11:05:53 CST 2020
     */
    int deleteByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Nov 13 11:05:53 CST 2020
     */
    int deleteByPrimaryKey(Integer adminId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Nov 13 11:05:53 CST 2020
     */
    int insert(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Nov 13 11:05:53 CST 2020
     */
    int insertSelective(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Nov 13 11:05:53 CST 2020
     */
    List<Admin> selectByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Nov 13 11:05:53 CST 2020
     */
    Admin selectByPrimaryKey(Integer adminId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Nov 13 11:05:53 CST 2020
     */
    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Nov 13 11:05:53 CST 2020
     */
    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Nov 13 11:05:53 CST 2020
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Fri Nov 13 11:05:53 CST 2020
     */
    int updateByPrimaryKey(Admin record);
}