package com.jt.doc.entity;
import java.io.Serializable;
import java.util.Date;
import com.jt.common.type.DocStatus;

public class Document implements Serializable{
	private static final long serialVersionUID = -2908452948374602325L;
	private Integer id;
	/**文档名称*/
	private String  name;
	/**文档内容类型*/
	private String  contentType;
	/**存储路径*/
	private String  filePath;
	/**内容摘要*/
	private String  contentDigest;
	/**分类id*/
	private Integer categoryId;
	/**文档状态*/
	private DocStatus status=DocStatus.UNPUBLISHED;
	/**文档备注*/
	private String  remark;
	/**创建时间*/
	private Date createdTime;
	/**修改时间*/
	private Date modifiedTime;
	/**创建用户*/
	private String createdUser;
	/**修改用户*/
	private String modifiedUser;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getContentDigest() {
		return contentDigest;
	}
	public void setContentDigest(String contentDigest) {
		this.contentDigest = contentDigest;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public DocStatus getStatus() {
		return status;
	}
	public void setStatus(DocStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", name=" + name + ", contentType=" + contentType + ", filePath=" + filePath
				+ ", contentDigest=" + contentDigest + ", categoryId=" + categoryId + ", status=" + status + ", remark="
				+ remark + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", createdUser="
				+ createdUser + ", modifiedUser=" + modifiedUser + "]";
	}
}
