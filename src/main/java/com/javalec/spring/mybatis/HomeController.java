package com.javalec.spring.mybatis;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.spring.mybatis.dao.ContentDao;
import com.javalec.spring.mybatis.dto.ContentDto;

@Controller
public class HomeController
{

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	ContentDao dao;

	@Autowired
	public void setDao(ContentDao dao)
	{
		this.dao = dao;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model)
	{
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "redirect:/list";
	}

	@RequestMapping("/list")
	public String list(Model model)
	{
		ArrayList<ContentDto> dtos = dao.listDao();
		model.addAttribute("list", dtos);

		return "/list";
	}

	@RequestMapping("/writeForm")
	public String writeForm()
	{

		return "/writeForm";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model)
	{
		dao.writeDao(request.getParameter("mWriter"), request.getParameter("mContent"));
		return "redirect:list";
	}

	@RequestMapping("/view")
	public String view()
	{

		return "/view";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model)
	{
		dao.deleteDao(request.getParameter("mId"));
		return "redirect:list";
	}

}