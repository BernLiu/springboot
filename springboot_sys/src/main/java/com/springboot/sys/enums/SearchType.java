package com.springboot.sys.enums;

import com.springboot.sys.component.MatchMode;

public enum SearchType {
	
	LIKE_WITH_START(MatchMode.START),
	LIKE_WITH_END(MatchMode.END),
	LIKE_WITH_ANYWHERE(MatchMode.ANYWHERE),
	LIKE_WITH_EXACT(MatchMode.EXACT),
	EQ("="),
	LT("<"),
	GT(">"),
	NE("!= "),
	GE(">="),
	LE("<="),
	IN("IN")
	;
	
	private MatchMode matchMode;
	
	private String str;

	public MatchMode getMatchMode() {
		return matchMode;
	}
	
	public String getStr() {
		return str;
	}

	private SearchType() {
	}
	
	private SearchType(String str) {
		this.str = str;
	}
	
	private SearchType(MatchMode matchMode) {
		this.matchMode = matchMode;
	}
}
