package com.tedu.project_jt.pojo;

import java.io.Serializable;

public class Item implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.item_id
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    private Integer itemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.category_id
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    private Integer categoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.item_name
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    private String itemName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.item_price
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    private Integer itemPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.item_desc
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    private String itemDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.item_image
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    private String itemImage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table item
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.item_id
     *
     * @return the value of item.item_id
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.item_id
     *
     * @param itemId the value for item.item_id
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.category_id
     *
     * @return the value of item.category_id
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.category_id
     *
     * @param categoryId the value for item.category_id
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.item_name
     *
     * @return the value of item.item_name
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.item_name
     *
     * @param itemName the value for item.item_name
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.item_price
     *
     * @return the value of item.item_price
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    public Integer getItemPrice() {
        return itemPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.item_price
     *
     * @param itemPrice the value for item.item_price
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.item_desc
     *
     * @return the value of item.item_desc
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.item_desc
     *
     * @param itemDesc the value for item.item_desc
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.item_image
     *
     * @return the value of item.item_image
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    public String getItemImage() {
        return itemImage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.item_image
     *
     * @param itemImage the value for item.item_image
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    public void setItemImage(String itemImage) {
        this.itemImage = itemImage == null ? null : itemImage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Tue Sep 22 09:40:57 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", itemId=").append(itemId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", itemName=").append(itemName);
        sb.append(", itemPrice=").append(itemPrice);
        sb.append(", itemDesc=").append(itemDesc);
        sb.append(", itemImage=").append(itemImage);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}