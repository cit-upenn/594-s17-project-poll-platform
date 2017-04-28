package com.javatpoint;

import java.util.Date;

public class Poll {

	private int pollId;
	private String pollTitle;
	private String pollContent;
	private String poster;
	private int[] pollResults;
	//tag field - "business"/ "science" / "health"/ "sports"/"arts"/"entertainment"/"life"/"others"
	private String tag;
	
	private Date createdDate;

	public Poll(){
		pollId = 0;
		pollTitle = null;
		pollContent = null;
		poster = null;
		pollResults = new int[5];
		
		tag = null;
		createdDate = null;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}