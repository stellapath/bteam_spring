package com.project.bteam.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.bteam.board.BoardPage;
import com.project.bteam.board.BoardVO;
import com.project.bteam.common.CommonService;
import com.project.bteam.review.ReviewServiceImpl;
import com.project.bteam.user.UserVO;

@Controller
public class ReviewController {
	
	@Autowired private ReviewServiceImpl service;
	@Autowired private BoardPage page; 
	@Autowired private CommonService common;
	
	//리뷰 수정업로드 처리 요청
	@RequestMapping("/reviewUpdateReq")
	public String update(BoardVO vo, String attach, Model model,
							MultipartFile file, HttpSession session) {
		BoardVO board = service.reviewDetail(vo.getBoard_num());
		String uuid = session.getServletContext().getRealPath("resources") + board.getBoard_filepath();
		if(!file.isEmpty()) {
			vo.setBoard_filename(file.getOriginalFilename());
			vo.setBoard_filepath(common.upload("board", file, session));
			
			if(board.getBoard_filename() != null) {
				File f = new File(uuid);
				if(f.exists()) f.delete();
			}
		}else {
			if(attach.isEmpty()) {
				File f = new File(uuid);
				if(f.exists()) f.delete();
			}else {
				vo.setBoard_filename(board.getBoard_filename());
				vo.setBoard_filepath(board.getBoard_filepath());
			}
		}
		service.reviewUpdate(vo);
		return "redirect:reviewBoard?board_category=1";
	}
	
	//리뷰 수정 화면 요청
	@RequestMapping("/reviewUpdate")
	public String modify(int board_num, Model model) {
		model.addAttribute("vo", service.reviewDetail(board_num));
		return "review/reviewUpdate";
	}
	
	//리뷰 삭제처리 요청
	@RequestMapping("/reviewDelete")
	public String delete(int board_num, Model model) {
		service.reviewDelete(board_num);
		model.addAttribute("page", page);
		model.addAttribute("url", "reviewBoard");
		return "review/redirect";
	}		
	
	//리뷰 글쓰기 업로드 요청
	@RequestMapping("/reviewWriteReq")
	public String insert(BoardVO vo, MultipartFile file, HttpSession session) {
		//첨부파일정보
		if(! file.isEmpty()) {
			vo.setBoard_filename(file.getOriginalFilename());
			vo.setBoard_filepath(common.upload("board", file, session));
		}
		vo.setBoard_email(((UserVO)session.getAttribute("login_info")).getUser_email());
		service.reviewInsert(vo);
		return "redirect:reviewBoard?board_category=1";
	}
	
	//리뷰 글쓰기 화면 요청
	@RequestMapping("/reviewWrite")
	public String reviewWrite() {
		return "review/reviewWrite";
	};
	
	//리뷰 목록화면 요청
	@RequestMapping("/reviewBoard")
	public String reviewList(Model model, HttpSession session, int board_category,
								@RequestParam(defaultValue="list") String viewType,
								@RequestParam(defaultValue="all") String recommend,
								@RequestParam(defaultValue="10") int pageList,
								@RequestParam(defaultValue="1") int curPage) {
		
		//DB에서 정보를 조회하여 목록화면에 출력
		page.setBoard_category(board_category);
		page.setCurPage(curPage);
		page.setPageList(pageList);
		page.setViewType(viewType);
		page.setRecommend(recommend);
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("lf", "\n");
		model.addAttribute("page", service.reviewList(page));
		return "review/reviewBoard";
	}
}
