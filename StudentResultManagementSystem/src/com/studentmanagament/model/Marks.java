package com.studentmanagament.model;

public class Marks {

	private float javaMarks;
	private float sqlMarks;
	private float springMarks;
	private float htmlMarks;
	private float reactMarks;

	public float getJavaMarks() {
		return javaMarks;
	}

	public void setJavaMarks(float javaMarks) {
		this.javaMarks = javaMarks;
	}

	public float getSqlMarks() {
		return sqlMarks;
	}

	public void setSqlMarks(float sqlMarks) {
		this.sqlMarks = sqlMarks;
	}

	public float getSpringMarks() {
		return springMarks;
	}

	public void setSpringMarks(float springMarks) {
		this.springMarks = springMarks;
	}

	public float getHtmlMarks() {
		return htmlMarks;
	}

	public void setHtmlMarks(float htmlMarks) {
		this.htmlMarks = htmlMarks;
	}

	public float getReactMarks() {
		return reactMarks;
	}

	public void setReactMarks(float reactMarks) {
		this.reactMarks = reactMarks;
	}

	public float calculateTotal() {

		return javaMarks + sqlMarks + springMarks + htmlMarks + reactMarks;
	}

	public float calculatePercentage() {

		return (calculateTotal() / 500) * 100;
	}

	public boolean isPassed() {

		return javaMarks >= 40 && sqlMarks >= 40 && springMarks >= 40 && htmlMarks >= 40 && reactMarks >= 40;
	}

	public String calculateGrade() {

		float percentage = calculatePercentage();

		if (isPassed()) {

			if (percentage >= 90 && percentage <= 100) {

				return "A+";

			} else if (percentage >= 80 && percentage < 90) {

				return "A";

			} else if (percentage >= 70 && percentage < 80) {

				return "B";

			} else if (percentage >= 60 && percentage < 70) {

				return "C";

			} else if (percentage >= 50 && percentage < 60) {

				return "D";

			} else {

				return "E";
			}

		} else {

			return "Fail";
		}
	}

}
