package com.javatpoint;

import java.util.HashMap;

public class Poll {

	private int pollId;
	private String pollTitle;
	private String pollContent;
	private String poster;
	private int[] pollResults;

	public Poll(){
		pollId = 0;
		pollTitle = null;
		pollContent = null;
		poster = null;
		pollResults = new int[5];
	}

	public int getPollId() {
		return pollId;
	}

	public void setPollId(int pollId) {
		this.pollId = pollId;
	}

	public String getPollTitle() {
		return pollTitle;
	}

	public void setPollTitle(String pollTitle) {
		this.pollTitle = pollTitle;
	}

	public String getPollContent() {
		return pollContent;
	}

	public void setPollContent(String pollContent) {
		this.pollContent = pollContent;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int[] getPollResults() {
		return pollResults;
	}

	public void setPollResults(int[] pollResults) {
		this.pollResults = pollResults;
	}


}
