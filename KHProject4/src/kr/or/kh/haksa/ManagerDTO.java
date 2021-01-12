package kr.or.kh.haksa;

import java.io.Serializable;

public class ManagerDTO extends HaksaDTO implements Serializable,IManagerDTO {
	private String part;
	


	public ManagerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ManagerDTO(int no, String age, String irum, String part) {
		super(no, age, irum);
		this.part = part;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getPart() {
		return part;
	}

	@Override
	public void setPart(String part) {
		this.part = part;
	}

	@Override
	public String toString() {
		return super.toString() + "ManagerDTO [part=" + part + "]";
	}



}
