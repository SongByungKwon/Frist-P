package Projet;

public class MemberVo {
private String id;
private String Password;
	public MemberVo() {
		
	}
	public MemberVo(String id, String Password) {
		this.id=id;
		this.Password=Password;
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return Password;
	}
	


}
