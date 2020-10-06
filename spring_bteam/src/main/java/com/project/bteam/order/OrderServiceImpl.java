package com.project.bteam.order;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bteam.board.BoardPage;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired private OrderDAO dao;

	@Override
	public OrderVO orderInsert(OrderVO vo) {
		return dao.orderInsert(vo);
	}

	@Override
	public BoardPage orderList(BoardPage page) {
		return dao.orderList(page);
	}
	
//	@Override
//	public List<OrderVO> orderList(String user_email) {
//		return dao.orderList(user_email);
//	}
	
	@Override
	public OrderVO orderDetail(int order_num) {
		return dao.orderDetail(order_num);
	}

	@Override
	public int orderDelete(int order_num) {
		return 0;
	}

}
