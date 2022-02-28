package com.smartEquip.humanCheck;

public class Question {
	private final String key;
	private final String question;

	public Question(String key, String question) {
		this.key = key;
		this.question = question;
	}

	public String getKey() {
		return key;
	}

	public String getQuestion() {
		return question;
	}
}
