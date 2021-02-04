package com.tedu.project_jt.pojo;

import java.io.Serializable;

public class JtOrder implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jt_order.order_id
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jt_order.user_id
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jt_order.total
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    private Integer total;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table jt_order
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jt_order.order_id
     *
     * @return the value of jt_order.order_id
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jt_order.order_id
     *
     * @param orderId the value for jt_order.order_id
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jt_order.user_id
     *
     * @return the value of jt_order.user_id
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jt_order.user_id
     *
     * @param userId the value for jt_order.user_id
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jt_order.total
     *
     * @return the value of jt_order.total
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jt_order.total
     *
     * @param total the value for jt_order.total
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jt_order
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", userId=").append(userId);
        sb.append(", total=").append(total);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}