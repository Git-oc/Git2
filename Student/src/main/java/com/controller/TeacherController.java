package com.controller;

import com.alibaba.excel.EasyExcel;
import com.dao.TeacherDao;
import com.entity.TeacherBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

@Controller
@RequestMapping(value = "teacher")
public class TeacherController {
	@Autowired
	private TeacherDao teacherDao;
	
	//返回多条教师信息记录到教师信息管理页面
	@RequestMapping(value = {"/teacherlist"})
	public String getStudent(TeacherBean tea,Model model,HttpServletRequest request) throws Exception{
		if(tea.getTeacherName()!=null&& !Objects.equals(tea.getTeacherName(), "")){
			tea.setTeacherName(URLDecoder.decode(tea.getTeacherName(), "UTF-8"));
		}
		List<TeacherBean> teacherlist = teacherDao.getTeacher(tea);
		int teapage = teacherDao.getteapage(tea);
		model.addAttribute("teacherlist", teacherlist);
		model.addAttribute("teapage", teapage);
		model.addAttribute("teachername", tea.getTeacherName());
		return "teacherlist";
	}
	//返回一条教师信息到教师个人信息页面
	@RequestMapping(value = {"/teacherone"})
	public String getTeacherone(TeacherBean tea,Model model) throws Exception {
		TeacherBean teacherone = teacherDao.getTeacherone(tea);
		model.addAttribute("teaone", teacherone);
		return "teacherone";
	}
	//点击编辑按钮返查询一条教师信息到编辑页面
	@RequestMapping(value = {"/teachereditor"})
	public String teachereditor(TeacherBean tea,Model model) throws Exception {
		if(tea.getTeacherId()==0){
			return "teachereditor";
		}else{
			TeacherBean teacherone = teacherDao.getTeacherone(tea);
			model.addAttribute("teacherone", teacherone);
			return "teachereditor";
		}
	}
	//删除一条教师信息记录
	@RequestMapping(value = {"/teacherdel"})
	public void teacherdel(TeacherBean tea,HttpServletResponse response) throws IOException {
		int a = 0;
		try {
			teacherDao.teacherdel(tea);
		} catch (Exception e) {
			a=a+1;
			response.getWriter().println("{'status':'0'}");
			e.printStackTrace();
		}
		if(a==0){
			response.getWriter().println("{'status':'1'}");
		}
	}
	//添加一条教师用户信息
	@RequestMapping(value = {"/teacheradd"})
	public void teacheradd(TeacherBean tea,HttpServletResponse response) throws IOException{
		int a = 0;
		try {
			if(tea.getTeacherId()==0){
				tea.setTeacherName(URLDecoder.decode(tea.getTeacherName(), "UTF-8"));
				tea.setTeacherSystem(URLDecoder.decode(tea.getTeacherSystem(), "UTF-8"));
				tea.setTeacherSex(URLDecoder.decode(tea.getTeacherSex(), "UTF-8"));
				tea.setTeacherEmail(URLDecoder.decode(tea.getTeacherEmail(), "UTF-8"));
				teacherDao.teacheradd(tea);
			}else{
				tea.setTeacherName(URLDecoder.decode(tea.getTeacherName(), "UTF-8"));
				tea.setTeacherSystem(URLDecoder.decode(tea.getTeacherSystem(), "UTF-8"));
				tea.setTeacherSex(URLDecoder.decode(tea.getTeacherSex(), "UTF-8"));
				tea.setTeacherEmail(URLDecoder.decode(tea.getTeacherEmail(), "UTF-8"));
				teacherDao.teacherxiugai(tea);
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
	public void downExcel(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//设置响应头
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("UTF-8");

		String filename = URLEncoder.encode("教师基本信息","UTF-8");

		//文件下载方式
		response.setHeader("Content-disposition","attachment;filename="+filename+".xlsx");

		//构建写入到excel文件的数据
		List<TeacherBean> teachers = new ArrayList<>();
		TeacherBean teacher1 = new TeacherBean(20001,"李老师","男","计科系","19636426518","9632587410@qq.com");
		TeacherBean teacher2 = new TeacherBean(20002,"张老师","男","计科系","19636026513","6635507415@qq.com");
		TeacherBean teacher3 = new TeacherBean(20003,"王老师","女","计科系","19536426518","9632507410@qq.com");
		TeacherBean teacher4 = new TeacherBean(20004,"欧老师","男","计科系","19036426589","2632587405@qq.com");
		TeacherBean teacher5 = new TeacherBean(20005,"谢老师","女","计科系","19036426571","9632680415@qq.com");
		teachers.add(teacher1);
		teachers.add(teacher2);
		teachers.add(teacher3);
		teachers.add(teacher4);
		teachers.add(teacher5);

		//设置排除的属性
		Set<String> set = new HashSet<>();
		set.add("Page");

		//写入数据到excel
		EasyExcel.write(response.getOutputStream(),TeacherBean.class).excludeColumnFieldNames(set).sheet("教师基本信息").doWrite(teachers);

	}

}
