package mesh.sample.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mesh.common.common.CommandMap;
import mesh.sample.service.SampleService;

@Controller
public class SampleController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="sampleService")
	private SampleService sampleService;
	
	/*@RequestMapping(value="/test/{dd}/{ww}")
    public ModelAndView test(CommandMap commandMap,@PathVariable String dd,@PathVariable String  ww) throws Exception{
		System.out.println(dd);
		System.out.println(dd);
		System.out.println(dd);
		System.out.println(ww);
		System.out.println(ww);
		System.out.println(ww);
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> list = sampleService.selectBoardList(commandMap.getMap());
    	mv.addObject("rows", list);
    	mv.addObject("param", commandMap.getMap());
    	System.out.println(commandMap.getMap());
    	return mv;
    }*/
	@ResponseBody
	@RequestMapping(value="/test")
    public ModelAndView test(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
    	//List<Map<String,Object>> list = sampleService.selectBoardList(commandMap.getMap());
    	//mv.addObject("rows", list);
    	mv.addObject("param", commandMap.getMap());
    	//mv.addObject("param", commandMap.getMap());
    	System.out.println(commandMap.getMap());
    	return mv;
    }
	
	@RequestMapping(value="/java")
    public ModelAndView java(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/java");
    	return mv;
    }
	
	@RequestMapping(value="/mysqltest")
    public ModelAndView mysqltest(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/mysqlTest");
    	return mv;
    }
	
	@RequestMapping(value="/replace")
    public ModelAndView replace() throws Exception{
		ModelAndView mv = new ModelAndView("/replace");
    	return mv;
    }
	
	@RequestMapping(value="/css")
    public ModelAndView css(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/css");
    	return mv;
    }
	
	@RequestMapping(value="/sample/selectBoardList.do")
    public ModelAndView selectBoardList(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	
    	List<Map<String,Object>> list = sampleService.selectBoardList(commandMap.getMap());
    	mv.addObject("list", list);
    	if(list.size() > 0){
    		mv.addObject("TOTAL", list.get(0).get("TOTAL_COUNT"));
    	}
    	else{
    		mv.addObject("TOTAL", 0);
    	}
    	
    	return mv;
    }
	
	@RequestMapping(value="/sample/openBoardWrite.do")
	public ModelAndView openBoardWrite(Map<String,Object> map) throws Exception{
		ModelAndView mv = new ModelAndView("/sample/boardWrite");
		
		return mv;
	}
	
	@RequestMapping(value="/sample/insertBoard.do")
	public ModelAndView insertBoard(CommandMap commandMap, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList.do");
		
		sampleService.insertBoard(commandMap.getMap(), request);
		
		return mv;
	}
	
	@RequestMapping(value="/sample/openBoardDetail.do")
	public ModelAndView openBoardDetail(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/sample/boardDetail");
		
		Map<String,Object> map = sampleService.selectBoardDetail(commandMap.getMap());
		mv.addObject("map", map.get("map"));
		mv.addObject("list", map.get("list"));
		
		return mv;
	}
	
	@RequestMapping(value="/sample/openBoardUpdate.do")
	public ModelAndView openBoardUpdate(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/sample/boardUpdate");
		
		Map<String,Object> map = sampleService.selectBoardDetail(commandMap.getMap());
		mv.addObject("map", map.get("map"));
		mv.addObject("list", map.get("list"));
		
		return mv;
	}
	
	@RequestMapping(value="/sample/updateBoard.do")
	public ModelAndView updateBoard(CommandMap commandMap, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/sample/openBoardDetail.do");
		
		sampleService.updateBoard(commandMap.getMap(), request);
		
		mv.addObject("IDX", commandMap.get("IDX"));
		return mv;
	}
	
	@RequestMapping(value="/sample/deleteBoard.do")
	public ModelAndView deleteBoard(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList.do");
		
		sampleService.deleteBoard(commandMap.getMap());
		
		return mv;
	}
}
