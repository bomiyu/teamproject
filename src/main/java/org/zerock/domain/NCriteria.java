package org.zerock.domain;

import lombok.Data;

@Data// setter가 필요함!!!!!
public class NCriteria {
	private int curPage;
	private int amount;
	
	public NCriteria() {
		this(1, 10);
	}
	
	public NCriteria(int curPage, int amount) {
		this.curPage = curPage;
		this.amount = amount;
	}
}
