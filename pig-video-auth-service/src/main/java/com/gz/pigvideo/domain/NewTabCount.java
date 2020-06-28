package com.gz.pigvideo.domain;

/**
 * 
* <p>
* Description:查询newTab的javabean
* <p>
* @author gaozhen
* @date 2020年6月26日
* @Version 1.1
 */
public class NewTabCount {
	private String account;
	
	private String name;
	
	private int count; //访问次数
	
	private String strDate;//访问日期

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	
}
