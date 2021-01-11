package webdemo.mvcspring.dto;

public class UserSearchDTO {
	
	private String userName;
	private String pincode;
	private String startDate;
	private String endDate;
	
	
	public UserSearchDTO() {}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	@Override
	public String toString() {
		return "UserSearchDTO [userName=" + userName + ", pincode=" + pincode + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	
	

}
