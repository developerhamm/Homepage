package kr.or.kh.haksa;

public abstract class HaksaDTO {
private int no;
private String age;
private String irum;



public int getNo() {
	return no;
}



public void setNo(int no) {
	this.no = no;
}



public String getAge() {
	return age;
}



public void setAge(String age) {
	this.age = age;
}



public String getIrum() {
	return irum;
}



public void setIrum(String irum) {
	this.irum = irum;
}




public HaksaDTO(int no, String age, String irum) {
	super();
	this.no = no;
	this.age = age;
	this.irum = irum;
}



public HaksaDTO() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "HaksaDTO super.toString() +[no=" + no + ", age=" + age + ", irum=" + irum + "]";
}

}
