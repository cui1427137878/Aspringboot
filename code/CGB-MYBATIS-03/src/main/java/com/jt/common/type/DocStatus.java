package com.jt.common.type;
/**文档状态*/
public enum DocStatus {
	/**未发布*/
	UNPUBLISHED(1),
	/**已上线*/
	PUBLISHED(2),
	/**已下线*/
	DOWNLINE(3);
	private int code;
	private  DocStatus(int code) {
		this.code=code;
	}
	public int getCode() {
		return code;
	}
	public static DocStatus valueOf(int code) {
	    switch (code) {
			case 1:return UNPUBLISHED;
			case 2:return PUBLISHED;
			default:return DOWNLINE;
		}
	 }
}
