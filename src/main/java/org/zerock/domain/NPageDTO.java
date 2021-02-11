package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class NPageDTO {
	private int total;// 총 게시물 수
	private NCriteria cri;// 현재 페이지, 한 페이지당 게시물 수
	
	private boolean prev;
	private boolean next;
	
	private int startPage;
	private int endPage;
	
	/* size는 5로 : 5 페이지씩 보이게 */
	public NPageDTO(int total, NCriteria cri) {
		this.total = total;
		this.cri = cri;
		
		int totalPages = (int) Math.ceil(total * 1.0 / cri.getAmount());
		
		this.startPage = (cri.getCurPage() - 1 ) / 5 * 5 + 1;// 1-5 > 1, 6-10 > 6 
		this.endPage = Math.min(this.startPage + 4, totalPages);
		
		this.prev = (this.startPage > 1);
		this.next = (this.endPage < totalPages);
		
		/* total 63 / amount 10   = 6 + 1  = 7페이지 
		 * curPage 5-1 / 5 * 5 = endPage
		 * */
	}
	
}
