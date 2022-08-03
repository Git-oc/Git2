package com.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.excel.EasyExcel;
import com.entity.TeacherBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.StudentDao;
import com.entity.StudentBean;

@Controller
@RequestMapping(value = "student")
public class StudentController {
	@Autowired
	private StudentDao studentDao;
	
	//得到学生列表和页数.返回到学生信息页面
	@RequestMapping(value = {"/studentlist"})
	public String getStudent(StudentBean stu,Model model) throws Exception{
		if(stu.getStuName()!=null&&stu.getStuName()!=""){
			stu.setStuName(URLDecoder.decode(stu.getStuName(), "UTF-8"));
		}
		List<StudentBean> stulist = studentDao.getStudent(stu);
		int stupage = studentDao.getstupage(stu);
		model.addAttribute("studentlist", stulist);
		model.addAttribute("stupage", stupage);
		model.addAttribute("studentname", stu.getStuName());
		return "studentlist";
	}
	//得到一个学生信息。返回到一个学生信息页面
	@RequestMapping(value = {"/studentone"})
	public String getStudentone(StudentBean stu,Model model) throws Exception {
		StudentBean studentone = studentDao.getStudentone(stu);
		model.addAttribute("stuone", studentone);
		return "studentone";
	}
	//得到一个学生信息。返回到学生编辑页面
	@RequestMapping(value = {"/studenteditor"})
	public String studenteditor(StudentBean stu,Model model) throws Exception {
		if(stu.getStuId()==0){
			return "studenteditor";
		}else{
			StudentBean studentone = studentDao.getStudentone(stu);
			model.addAttribute("studentone", studentone);
			return "studenteditor";
		}
	}
	//删除学生信息
	@RequestMapping(value = {"/studentdel"})
	public void studentdel(StudentBean stu,HttpServletResponse response) throws IOException {
		int a = 0;
		try {
			studentDao.studentdel(stu);
		} catch (Exception e) {
			a=a+1;
			response.getWriter().println("{'status':'0'}");
			e.printStackTrace();
		}
		if(a==0){
			response.getWriter().println("{'status':'1'}");
		}
	}
	//添加/修改   （ 以是否有stuId来判断）     学生信息
	@RequestMapping(value = {"/studentadd"})
	public void studentadd(StudentBean stu,HttpServletResponse response) throws IOException{
		int a = 0;
		try {
			if(stu.getStuId()==0){
				stu.setStuName(URLDecoder.decode(stu.getStuName(), "UTF-8"));
				stu.setStuSystem(URLDecoder.decode(stu.getStuSystem(), "UTF-8"));
				stu.setStuSex(URLDecoder.decode(stu.getStuSex(), "UTF-8"));
				stu.setStuClass(URLDecoder.decode(stu.getStuClass(), "UTF-8"));
				studentDao.studentadd(stu);
			}else{
				stu.setStuName(URLDecoder.decode(stu.getStuName(), "UTF-8"));
				stu.setStuSystem(URLDecoder.decode(stu.getStuSystem(), "UTF-8"));
				stu.setStuSex(URLDecoder.decode(stu.getStuSex(), "UTF-8"));
				stu.setStuClass(URLDecoder.decode(stu.getStuClass(), "UTF-8"));
				studentDao.studentxiugai(stu);
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

		String filename = URLEncoder.encode("学生基本信息","UTF-8");

		//文件下载方式
		response.setHeader("Content-disposition","attachment;filename="+filename+".xlsx");

		//根据StudentBean模板创建数据
		List<StudentBean> students = new ArrayList<>();
		StudentBean student1 = new StudentBean(10001,"李四","男","计科系","软件1班","19136426017");
		StudentBean student2 = new StudentBean(10002,"张三","男","计科系","软件2班","19536026513");
		StudentBean student3 = new StudentBean(10003,"王五","男","计科系","软件3班","19636626518");
		StudentBean student4 = new StudentBean(10004,"欧叶","女","计科系","软件4班","19136426580");
		StudentBean student5 = new StudentBean(10005,"谢一","女","计科系","软件5班","19736426561");
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student5);

		//设置排除的属性
		Set<String> set = new HashSet<>();
		set.add("page");

		//写入数据到excel
		EasyExcel.write(response.getOutputStream(),StudentBean.class).excludeColumnFieldNames(set).sheet("学生基本信息").doWrite(students);

	}

}
