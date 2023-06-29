package Projet;

public class MemberVo {
private String id;
private String Password;
private String image_id;
private String image_data;
private String image_kind;
private String image_line;


private String calc_y;
private String calc_m;
private String calc_d;
private String titel;
private String contents;
private String gettime;




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
	
	public MemberVo(String image_id) {
		this.image_id=image_id;
	}
	
	public String getname() {
		return image_id;
	}
	
	public MemberVo(String image_id,String image_data,String image_kind,String image_line) {
		this.image_id=image_id;
		this.image_data =image_data;
		this.image_kind =image_kind;
		this.image_line =image_line;
		
	}
	

	public String getdata() {
		return image_data;
	}
	public String getkind() {
		return image_kind;
	}
	public String getline() 
	{
		return image_line;
		}
	
	
	public MemberVo(String calc_y,String calc_m,String calc_d,String titel,String time,String contents) {
	
		this.calc_y=calc_y;
		this.calc_m =calc_m;
		this.calc_d =calc_d;
		this.titel =titel;
		this.gettime =time;
		this.contents =contents;
	}
	
	

	
	

	
	
	public String getcalc_y() 
	{
		return calc_y;
		}
	
	public String getcalc_m() 
	{
		return calc_m;
		}
	
	public String getcalc_d() 
	{
		return calc_d;
		}
	
	public String gettitel() 
	{
		return titel;
		}
	
	public String getcontents() 
	{
		return contents;
		}
	public String gettime() 
	{
		return gettime;
		}
	
	


}
