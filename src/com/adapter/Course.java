package com.adapter;

import java.util.ArrayList;
import java.util.List;

public class Course {

	private String name;
	private int expectedAssignments;
	private List<Assignment> assignments;

	public Course(String name, int expectedAssignments) throws CourseException {
		if (expectedAssignments < 1) {
			throw new CourseException("Must be at least 1 expected Assignment");
		}
		this.name = name;
		this.expectedAssignments = expectedAssignments;
		assignments = new ArrayList<>();
	}

	public void submitAssignment(Assignment assignment) {
		assignments.add(assignment);
	}

	private int finalGrade() {
		int grade = 0;
		for (Assignment as : assignments) {
			grade += as.getGrade();
		}
		float calc = (float) grade / expectedAssignments;
		return Math.round(calc);
	}

	private String gradeInLetter(int grade) {
		return grade > 92 ? "A" :
				grade > 82 ? "B" :
				grade > 72 ? "C" :
				grade > 64 ? "D" : "F";
	}

	public String transcript() {
		StringBuilder sb = new StringBuilder("Course name: ").append(name).append("\n");
		if (assignments.isEmpty()) {
			sb.append("No assignments were submitted\n");
		} else {
			sb.append("Assignments: (").append(expectedAssignments).append(")\n");
			assignments.forEach(as -> sb.append(as.toString()).append("\n"));
		}
		sb.append("Final grade: ").append(finalGrade()).append(" (").append(gradeInLetter(finalGrade())).append(")");
		return sb.toString();
	}

	public String readAssignment(int index) {
		if (index < 0) {
			index = assignments.size() - 1;
		}
		return assignments.get(index).toString();
	}

	public void gradeAssignment(int index, int grade) {
		if (index < 0) {
			index = assignments.size() - 1;
		}
		assignments.get(index).setGrade(grade);
	}
}
