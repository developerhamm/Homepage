package kr.or.kh.haksa;

import java.io.Serializable;

public class ProfessorDTO extends HaksaDTO implements Serializable,IProfessorDTO {

	private String subject;

	


	public ProfessorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfessorDTO(int no, String age, String irum, String subject) {
		super(no, age, irum);
		this.subject = subject;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getSubject() {
		return subject;
	}
	@Override
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "ProfessorDTO [subject=" + subject + "]";
	}
	
}
