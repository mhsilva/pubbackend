package com.pub.api.response;

import java.util.List;

public class PubStatus {
	private final long id;
	private final List<String> content;

	public PubStatus(long id, List<String> content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public List<String> getContent() {
		return content;
	}

}
