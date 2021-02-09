package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FPageDTO {
	
	private int startPage;
	private int endPage;
	
	private boolean prev;
	private boolean next;
	
	private int total;
	
	private FCriteria cri;
	
	public FPageDTO(FCriteria cri, int total) { //Criteria안에는  amount, pageNum을 가지고있기때문에 ~
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int) Math.ceil(cri.getPageNum() / 10.0) * 10;// Math.ceil() --소수점 올림
		this.startPage = endPage - 9;
		
		int realEnd = (int) Math.ceil(total * 1.0 / cri.getAmount());
		
		endPage = Math.min(realEnd, endPage); // Math.min() 함수는 주어진 숫자들 중 가장 작은 값을 반환
		
		this.prev = this.startPage > 1; //시작페이지가 1보다 클경우 ~
		this.next = endPage < realEnd;
	}
}






