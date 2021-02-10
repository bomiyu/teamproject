package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FCriteria {

	private int pageNum;
	private int amount;
	
	private String type;
	private String keyword;
	
	public FCriteria() {
		this(1, 10);
	}

	public FCriteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() { //배열로 조건별 검색처리 
		if (this.type == null) {
			return new String[] {};
		} else {
			return type.split("");
		}
	}
}






