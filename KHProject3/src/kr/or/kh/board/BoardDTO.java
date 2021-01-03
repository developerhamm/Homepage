package kr.or.kh.board;

import java.io.Serializable;

public class BoardDTO implements Serializable {
   private int no;
   private String title;
   private String content;
   private String author;
   private String nal;
   private int readcount;
   public BoardDTO(int no, String title, String content, String author, String nal, int readcount) {
	   super();
	   this.no = no;
	   this.title = title;
	   this.content = content;
	   this.author = author;
	   this.nal = nal;
	   this.readcount = readcount;
   }
   
   public BoardDTO() {
	   super();
	   // TODO Auto-generated constructor stub
   }
   
public int getNo() {
	return no;
}

public void setNo(int no) {
	this.no = no;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public String getNal() {
	return nal;
}

public void setNal(String nal) {
	this.nal = nal;
}

public int getReadcount() {
	return readcount;
}

public void setReadcount(int readcount) {
	this.readcount = readcount;
}

@Override
public String toString() {
	return "BoardDTO [no=" + no + ", title=" + title + ", content=" + content + ", author=" + author + ", nal=" + nal
			+ ", readcount=" + readcount + "]";
}

   
}
