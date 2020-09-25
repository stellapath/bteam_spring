package com.project.bteam.review;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.bteam.board.BoardPage;
import com.project.bteam.board.BoardService;
import com.project.bteam.board.BoardVO;

@Repository
public class ReviewDAO implements ReviewService{
	@Autowired private SqlSession sql;

	@Override
	public int reviewInsert(BoardVO vo) {
		return sql.insert("review.insert", vo);
	}

	@Override
	public BoardPage reviewList(BoardPage page) {
		page.setTotalList((Integer)sql.selectOne("review.total", page));
		page.setList(sql.selectList("review.list", page));
		return page;
	}

	@Override
	public BoardVO reviewDetail(int board_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int reviewLike(int board_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reviewUpdate(int board_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reviewDelete(int board_num) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}