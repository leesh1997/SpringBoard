package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.boardDAO;
import com.board.domain.BoardVO;

@Service
public class boardServicelmpl implements boardService {

	@Inject
	private boardDAO dao;
	
	// 회원 목록
	@Override
	public List<BoardVO> list() {
		return dao.list();
	}
	
	@Override
	public void create(BoardVO vo) {
		dao.create(vo);
	}

}
