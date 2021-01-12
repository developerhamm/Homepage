package kr.or.kh.haksa;

import java.io.Serializable;

public class StudentDTO extends HaksaDTO implements Serializable,IStudentDTO { //DTO는 입력과 출력을 담당하는 것

private String hakbun;


public StudentDTO() {
	super();
}


public StudentDTO(int no, String age, String irum, String hakbun) {
	super(no, age, irum);
	this.hakbun=hakbun;
}



public StudentDTO(String hakbun) {
	super();
	this.hakbun = hakbun;
}

@Override
public String getHakbun() {
	return hakbun;
}

@Override
public void setHakbun(String hakbun) {
	this.hakbun = hakbun;
}

@Override
public String toString() {
	return super.toString() +"StudentDTO [hakbun=" + hakbun + "]";
}




}
