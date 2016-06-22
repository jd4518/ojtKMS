package com.project.util;

public class Pagination {

		/*
		 * read-write
		 */
		private int totalItem;	// select count(*) from city
		private int pageNo;		// request Parameter pageNo
		private int itemNo;
		private int categoryNo;
		/*
		 * read-only
		 */
		private int totalPage;
		private int firstItem;
		private int lastItem;
		private int firstPage;
		private int lastPage;
		
		/*
		 * read-write
		 */
		private int itemsPerPage = 10;
		private int pagesPerGroup = 10;
		
		public void calculate() {
			
			/*
			 * pageNo validation
			 */
			if (pageNo < 1)
				pageNo = 1;
			
			/*
			 * totalPage
			 */
			// 4079 / 10 = 407    
			// 4079 % 10 > 0 407++  ==> 408
			totalPage = totalItem / itemsPerPage;
			if (totalItem % itemsPerPage > 0)
				totalPage++;

			/*
			 * pageNo validation
			 */
			if (pageNo > totalPage)
				pageNo = (totalPage == 0) ?  1 : totalPage;
			
			/*
			 * firstItem
			 */
			// (1 - 1) * 10 + 1 = 1      ==> 1
			// (5 - 1) * 10 + 1 = 41     ==> 41
			firstItem = (pageNo - 1) * itemsPerPage + 1;
			
			/*
			 * lastItem
			 */
			//firstItem= 4071
			//lastItem = 4079
			//
			// lastItem = 4071 + 10 - 1 = 4080
			lastItem = firstItem + itemsPerPage - 1;
			if (lastItem > totalItem)
				lastItem = totalItem;
			
			/*
			 * firstPage 
			 */
			// pageNo = 5   ==> firstPage = 1
			// (5-1)/10*10 + 1 = 1
			// (16-1)/10*10 + 1 = 11
			// (408-1)/10*10 + 1 = 401
			firstPage = (pageNo - 1) / pagesPerGroup * pagesPerGroup + 1;
			
			/*
			 * lastPage
			 */
			lastPage = firstPage + (pagesPerGroup - 1);
			if (lastPage > totalPage)
				lastPage = totalPage;
			
			
		}
		
		public int getTotalItem() {
			return totalItem;
		}
		public void setTotalItem(int totalItem) {
			this.totalItem = totalItem;
			/*
			 * 유도 변수들을 계산한다.
			 */
			calculate();
		}
		
		public int getItemNo(){
			return totalItem-(pageNo-1)*itemsPerPage;
		}
		
		public int getPageNo() {
			return pageNo;
		}
		public void setPageNo(int pageNo) {
			this.pageNo = pageNo;
		}
		public int getTotalPage() {
			return totalPage;
		}
		public int getFirstItem() {
			return firstItem;
		}
		public int getLastItem() {
			return lastItem;
		}
		public int getFirstPage() {
			return firstPage;
		}
		public int getLastPage() {
			return lastPage;
		}
		public int getItemsPerPage() {
			return itemsPerPage;
		}
		public void setItemsPerPage(int itemsPerPage) {
			this.itemsPerPage = itemsPerPage;
		}
		public int getPagesPerGroup() {
			return pagesPerGroup;
		}
		public void setPagesPerGroup(int pagesPerGroup) {
			this.pagesPerGroup = pagesPerGroup;
		}
		public boolean isFirstGroup() {
			return (firstPage == 1) ? true : false;
		}
		public boolean isLastGroup() {
			return (lastPage == totalPage) ? true : false;
		}
		
		public int getStart() {
			return firstItem;
		}
		
		public int getEnd() {
			return lastItem;
		}

		public int getCategoryNo() {
			return categoryNo;
		}

		public void setCategoryNo(int categoryNo) {
			this.categoryNo = categoryNo;
		}
		
		
		
}
