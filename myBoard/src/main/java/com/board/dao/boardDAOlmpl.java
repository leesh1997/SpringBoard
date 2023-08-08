package com.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.BoardVO;

@Repository
public class boardDAOlmpl implements boardDAO {
	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.myBoard.mappers.board";
	
	@Override
	public List<BoardVO> list() {
		return sql.selectList(namespace + ".list");
	}

	@Override
	public void create(BoardVO vo) {
		sql.insert(namespace + ".create", vo);
	}
	
	@Override
	public BoardVO detail(int no) {
		return sql.selectOne(namespace + ".detail", no);
	}
}
