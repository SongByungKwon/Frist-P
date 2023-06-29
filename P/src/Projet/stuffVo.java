package Projet;

public class stuffVo {
	private String stuffname;
	private String stuff_item;
	private String stuff_number;
	private String stuff_num;
	private int number;
	






public  stuffVo(String stuffname,String  stuff_item, String  stuff_number, int number) {
	this.stuffname = stuffname;
	this.stuff_item = stuff_item;
	this.stuff_number = stuff_number;
	this.number = number;
	

	
}

public  stuffVo(String stuff_num,String  stuff_item, String  stuff_number) {
	this.stuff_num = stuff_num;
	this.stuff_item = stuff_item;
	this.stuff_number = stuff_number;
	
	
	

	
}

public String getstuff_num() {
return stuff_num;

}



public String getstuffname() {
return stuffname;

}

public String getstuff_item() {
	
return stuff_item;

}

public String getstuff_number() {
	
return stuff_number;

}

public int getnumber() {
return number;


}


}
