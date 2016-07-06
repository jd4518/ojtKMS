package com.project.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.board.model.Board;
import com.project.comment.model.Comment;
import com.project.member.dao.MemberDao;
import com.project.member.model.Member;
import com.project.util.service.Pagination;

@Service
public class MemberListService {

	static Log log = LogFactory.getLog(MemberListService.class);
	
	@Autowired
	private MemberDao memberDao;
	
	public Map<String, Object> getMemberList(int pageNo){
		Map<String, Object> map = new HashMap<String, Object>();
		Pagination page = new Pagination();
		page.setPageNo(pageNo);
		page.setTotalItem(memberDao.memberTotalCount());
		System.out.println(pageNo);
		List<Member> member = memberDao.selectMemberList(page);
		
		
		map.put("member", member);
		map.put("page", page);
		return map;
	}


}
