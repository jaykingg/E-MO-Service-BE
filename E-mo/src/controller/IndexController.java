package controller;

import dao.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class IndexController implements Controller { 
	private PlayerDao playerDao;
	public void setPlayerDao(PlayerDao player) 
	{
		playerDao = player;
	}
	
  public ModelAndView handleRequest(HttpServletRequest request, 
                   HttpServletResponse response) throws Exception {
    //상품 리스트 정보를 취득
    List<Player> playerList = this.playerDao.getPlayerList();
    //모델 작성    
	Map<String, List<Player>> model = new HashMap<String, List<Player>>();
    model.put("playerList", playerList);
    //반환값이 되는 ModelAndView인스턴스를 작성
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("/WEB-INF/jsp/index.jsp");
    modelAndView.addAllObjects(model);
    return modelAndView;
  }
}
