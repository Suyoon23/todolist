package spms.vo;

import java.util.Date;
//TNO      INTEGER  NOT NULL COMMENT '투두리스트일련번호', -- 
//MNO      INTEGER  NOT NULL COMMENT '내일련번호', -- 
//STATE    INTEGER  NOT NULL COMMENT '상태', -- 상태
//MOD_DATE DATETIME NOT NULL COMMENT '상태변경일' -- 상태변

public class Todo_Me {
	protected int 		no;
	protected String 	name;
	protected String 	email;
	protected String 	password;
	protected Date		createdDate;
	protected Date		modifiedDate;
	
	public int getNo() {
		return no;
	}
	public Todo_Me setNo(int no) {
		this.no = no;
		return this;
	}
	public String getName() {
		return name;
	}
	public Todo_Me setName(String name) {
		this.name = name;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Todo_Me setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public Todo_Me setPassword(String password) {
		this.password = password;
		return this;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public Todo_Me setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public Todo_Me setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
		return this;
	}
}
