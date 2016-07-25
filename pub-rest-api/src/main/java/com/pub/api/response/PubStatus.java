 package com.pub.api.response;

public class PubStatus {
	private final long id;
	private final String content;

	public PubStatus(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

}
