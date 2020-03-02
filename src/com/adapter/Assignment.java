package com.adapter;

public class Assignment {

	private String title;
	private int grade;
	private String text;
	private Pen pen;

	public Assignment(String title) {
		this.title = title;
		this.grade = -1;
	}

	public int getGrade() {
		return Math.max(0, grade);
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Pen getPen() {
		return pen;
	}

	public void setPen(Pen pen) {
		this.pen = pen;
	}

	public void write(String text) throws CourseException {
		if (pen != null) {
			this.text = pen.write(text);
		} else {
			throw new CourseException("No pen assigned");
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("Title: ").append(title).append("\n");
		if (grade < 0) {
			sb.append("Not graded\n");
		} else {
			sb.append("Grade: ").append(grade).append("\n");
		}
		sb.append("Contents: ").append(text).append("\n");
		return sb.toString();
	}

}
