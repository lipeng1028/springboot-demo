package com.sxit.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Transaction;
import com.sxit.entity.PgcAccount;
import com.sxit.service.IPgcAccountService;

@Controller
public class UserController {
	@Resource
	IPgcAccountService pgcAccountService;

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		String pageName = "helloworld";
		String serverIp = "localhost";
//		Transaction t = Cat.newTransaction("URL123", pageName);
		Transaction t = Cat.newTransaction("123", "123");
		Cat.logEvent("URL.Server", serverIp, Event.SUCCESS, "ip=" + serverIp + "&...");
		t.setStatus(Transaction.SUCCESS);
		return "Hello World";
	}

	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("name", "李鹏");
		model.addAttribute("age", "25");
		model.addAttribute("info", "我是一名程序员");
		return "test/index";
	}

	@RequestMapping(value = "/index2", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView index2() {
		ModelAndView mav = new ModelAndView("test/index");
		mav.addObject("name", "lp");
		mav.addObject("age", "25");
		mav.addObject("info", "asd");
		return mav;
	}

	@RequestMapping(value = "/searchAccount", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView searchAccount() {
		ModelAndView modelAndView = new ModelAndView("test/index2");

		QueryWrapper<PgcAccount> wrapper = new QueryWrapper<PgcAccount>();
		List<PgcAccount> list = pgcAccountService.list(wrapper);

		modelAndView.addObject("list", list);
		return modelAndView;
	}
	
	@RequestMapping(value = "/searchAccount2", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView searchAccount2() {
		ModelAndView modelAndView = new ModelAndView("test/index2");

//		List<PgcAccount> list = pgcAccountService.selectList();
//		IPage<PgcAccount> page = new Page<PgcAccount>();
//		page.setCurrent(1);
//		page.setSize(5);
//		page = pgcAccountService.selectList(page);
//		modelAndView.addObject("list", iPage);

		IPage<PgcAccount> iPage = pgcAccountService.selectList(new Page<PgcAccount>(1, 5));
		System.out.println("page:" + JSONObject.toJSONString(iPage));
		return modelAndView;
	}

}
