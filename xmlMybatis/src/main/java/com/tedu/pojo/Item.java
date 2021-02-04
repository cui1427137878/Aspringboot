package com.tedu.pojo;

import java.io.Serializable;

/**
 * item
 * @author 
 */
public class Item implements Serializable {
    private Integer itemId;

    private Integer categoryId;

    private String itemName;

    private Integer itemPrice;

    private String itemDesc;

    private String itemImage;

    private static final long serialVersionUID = 1L;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Item other = (Item) that;
        return (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getItemName() == null ? other.getItemName() == null : this.getItemName().equals(other.getItemName()))
            && (this.getItemPrice() == null ? other.getItemPrice() == null : this.getItemPrice().equals(other.getItemPrice()))
            && (this.getItemDesc() == null ? other.getItemDesc() == null : this.getItemDesc().equals(other.getItemDesc()))
            && (this.getItemImage() == null ? other.getItemImage() == null : this.getItemImage().equals(other.getItemImage()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getItemName() == null) ? 0 : getItemName().hashCode());
        result = prime * result + ((getItemPrice() == null) ? 0 : getItemPrice().hashCode());
        result = prime * result + ((getItemDesc() == null) ? 0 : getItemDesc().hashCode());
        result = prime * result + ((getItemImage() == null) ? 0 : getItemImage().hashCode());
        return result;
    }

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