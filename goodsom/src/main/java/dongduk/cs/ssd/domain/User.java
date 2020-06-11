package dongduk.cs.ssd.domain;

public class User {
	int userId;
	String emailId;
	String password;
	String userName;
	String nickname;
	String address1;
	String address2;
	String address3;
	String phone;
	String refundBank;
	String refundAccount;
	
	public User() {}

	public User(int userId, String emailId, String password, String nickname, String address1, String address2, String address3, String phone, String refundBank, String refundAccount) {
		this.userId = userId;
		this.emailId = emailId;
		this.password = password;
		this.nickname = nickname;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.phone = phone;
		this.refundBank = refundBank;
		this.refundAccount = refundAccount;
	}
	
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	


	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getRefundBank() {
		return refundBank;
	}

	public void setRefundBank(String refundBank) {
		this.refundBank = refundBank;
	}

	public String getRefundAccount() {
		return refundAccount;
	}

	public void setRefundAccount(String refundAccount) {
		this.refundAccount = refundAccount;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
