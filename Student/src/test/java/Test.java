import com.alibaba.excel.EasyExcel;
import com.entity.StudentBean;
import com.entity.TeacherBean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    @org.junit.Test
    public void Teacher(){

        //创建一个xlsx表格
        String fileName = "Teacher.xlsx";//表格的相对路径
        //根据TeacherBean模板创建数据
        List<TeacherBean> teachers = new ArrayList<>();
        TeacherBean teacher1 = new TeacherBean(10001,"李老师","男","计科系","19636426518","9632587410@qq.com");
        TeacherBean teacher2 = new TeacherBean(10002,"张老师","男","计科系","19636026513","6635507415@qq.com");
        TeacherBean teacher3 = new TeacherBean(10003,"王老师","女","计科系","19536426518","9632507410@qq.com");
        TeacherBean teacher4 = new TeacherBean(10004,"欧老师","男","计科系","19036426589","2632587405@qq.com");
        TeacherBean teacher5 = new TeacherBean(10005,"谢老师","女","计科系","19036426571","9632680415@qq.com");
        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);
        teachers.add(teacher4);
        teachers.add(teacher5);

        //设置排除的属性
        Set<String> set = new HashSet<>();
        set.add("Page");

        //向xlsx表格中写数据
        EasyExcel.write(fileName,TeacherBean.class).excludeColumnFieldNames(set).sheet("教师基本信息").doWrite(teachers);

    }

    @org.junit.Test
    public void Student(){

        //创建一个xlsx表格
        String fileName = "Student.xlsx";//表格的相对路径

        //根据StudentBean模板创建数据
        List<StudentBean> students = new ArrayList<>();
        StudentBean teacher1 = new StudentBean(10001,"李四","男","计科系","软件1班","19136426017");
        StudentBean teacher2 = new StudentBean(10002,"张三","男","计科系","软件2班","19536026513");
        StudentBean teacher3 = new StudentBean(10003,"王五","女","计科系","软件3班","19636626518");
        StudentBean teacher4 = new StudentBean(10004,"欧叶","男","计科系","软件4班","19136426580");
        StudentBean teacher5 = new StudentBean(10005,"谢一","女","计科系","软件5班","19736426561");
        students.add(teacher1);
        students.add(teacher2);
        students.add(teacher3);
        students.add(teacher4);
        students.add(teacher5);

        //设置排除的属性
        Set<String> set = new HashSet<>();
        set.add("page");

        //向xlsx表格中写数据
        EasyExcel.write(fileName,StudentBean.class).excludeColumnFieldNames(set).sheet("学生基本信息").doWrite(students);

    }

}
