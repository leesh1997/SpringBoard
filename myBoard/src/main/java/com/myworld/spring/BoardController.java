package com.myworld.spring;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.domain.BoardVO;
import com.board.service.boardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	private boardService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET) // url mapping
	public String getList(Model model) throws Exception {
		List<BoardVO> list = service.list();
		model.addAttribute("list", list);
		// board/list.jsp로 포워딩
		return "board/list";
	}

	// 게시물 작성 페이지로 이동
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String getcreate() throws Exception {
		return "board/create";
	}

	// 게시물 작성 post
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String postcreate(BoardVO vo) throws Exception {
		service.create(vo);
		return "redirect:list";
	}

	// 게시물 상세 페이지로 이동
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String getdetail(Model model, int no) {
		BoardVO data = service.detail(no);//no값 넘김
		model.addAttribute("data", data);
		return "board/detail";
	}

}
