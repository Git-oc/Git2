package com.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.excel.EasyExcel;
import com.entity.StudentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.SubjectDao;
import com.entity.SubjectBean;

@Controller
@RequestMapping(value = "subject")
public class SubjectController {
	@Autowired
	private SubjectDao subjectDao;
//	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
//	SubjectDao subjectDao = (SubjectDao) applicationContext.getBean("subjectDao");
	//返回多条课程信息
	@RequestMapping(value = {"/subjectlist"})
	public String getStudent(SubjectBean sbj,Model model) throws Exception{
		if(sbj.getSubjectName()!=null&& !Objects.equals(sbj.getSubjectName(), "")){
			sbj.setSubjectName(URLDecoder.decode(sbj.getSubjectName(), "UTF-8"));
		}
		List<SubjectBean> subjectlist = subjectDao.getSubject(sbj);
		int sbjpage = subjectDao.getsbjpage(sbj);
		model.addAttribute("subjectlist", subjectlist);
		model.addAttribute("sbjpage", sbjpage);
		model.addAttribute("subjectname", sbj.getSubjectName());
		return "subjectlist";
	}
	//返回一条课程信息到课程信息的编辑页面
	@RequestMapping(value = {"/subjecteditor"})
	public String studenteditor(SubjectBean sbj,Model model) throws Exception {
		if(sbj.getSubjectId()==0){
			return "subjecteditor";
		}else{
			SubjectBean subjectone = subjectDao.getSubjectone(sbj);
			model.addAttribute("subjectone", subjectone);
			return "subjecteditor";
		}
	}
	//删除一条课程信息
	@RequestMapping(value = {"/subjectdel"})
	public void subjectdel(SubjectBean sbj,HttpServletResponse response) throws IOException {
		int a = 0;
		try {
			subjectDao.subjectdel(sbj);
		} catch (Exception e) {
			a=a+1;
			response.getWriter().println("{'status':'0'}");
			e.printStackTrace();
		}
		if(a==0){
			response.getWriter().println("{'status':'1'}");
		}
	}
	//添加一条课程信息
	@RequestMapping(value = {"/subjectadd"})
	public void subjectadd(SubjectBean sbj,HttpServletResponse response) throws IOException{
		int a = 0;
		try {
			if(sbj.getSubjectId()==0){
				sbj.setSubjectName(URLDecoder.decode(sbj.getSubjectName(), "UTF-8"));
				sbj.setTeacherName(URLDecoder.decode(sbj.getTeacherName(), "UTF-8"));
				subjectDao.subjectadd(sbj);
			}else{
				sbj.setSubjectName(URLDecoder.decode(sbj.getSubjectName(), "UTF-8"));
				sbj.setTeacherName(URLDecoder.decode(sbj.getTeacherName(), "UTF-8"));
				subjectDao.subjectxiugai(sbj);
			}
		} catch (Exception e) {
			a=a+1;
			response.getWriter().println("{'status':'0'}");
			e.printStackTrace();
		}
		if(a==0){
			response.getWriter().println("{'status':'1'}");
		}
	}

	@RequestMapping("/downloadExcel")
	public void downExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//设置响应头
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("UTF-8");

		String filename = URLEncoder.encode("课程基本信息","UTF-8");

		//文件下载方式
		response.setHeader("Content-disposition","attachment;filename="+filename+".xlsx");

		//根据StudentBean模板创建数据
		List<SubjectBean> subjects = new ArrayList<>();
		SubjectBean subject1 = new SubjectBean(30001,"java","欧老师","100");
		SubjectBean subject2 = new SubjectBean(30002,"servlet","李老师","99");
		SubjectBean subject3 = new SubjectBean(30003,"mybatis","张老师","97");
		SubjectBean subject4 = new SubjectBean(30004,"spring","王老师","98");
		SubjectBean subject5 = new SubjectBean(30005,"html","谢老师","100");
		subjects.add(subject1);
		subjects.add(subject2);
		subjects.add(subject3);
		subjects.add(subject4);
		subjects.add(subject5);

		//设置排除的属性
		Set<String> set = new HashSet<>();
		set.add("page");

		//写入数据到excel
		EasyExcel.write(response.getOutputStream(),SubjectBean.class).excludeColumnFieldNames(set).sheet("教师基本信息").doWrite(subjects);

	}

}
