package com.dao;

import com.entity.ScoreBean;
import com.entity.StudentBean;
import com.entity.SubjectBean;

import java.util.List;

public interface ScoreDao {

    //多表查询查询出一个学生的成绩和其他信息保存到一个score对象中
    public List<ScoreBean> getscorelist(StudentBean studentbean)throws Exception;
    //添加一个学生的成绩
    public void scoreadd(ScoreBean score)throws Exception;
    //查询一个学生的未选选课程信息list
    public List<SubjectBean> getSubject(ScoreBean score) throws Exception;
    //已选课程信息的分页处理
    public int getsbjpage(ScoreBean score)throws Exception;
    //添加一个学生的选课信息
    public void setsubject(ScoreBean score)throws Exception;
    //查询一个学生已选课程信息的list
    public List<SubjectBean> yxsubjectlist(ScoreBean score) throws Exception;
    //删除一条已选课程
    public void delyxkc(ScoreBean score) throws Exception;
    //查询一个学生的已选课程成绩和课程信息的list
    public List<ScoreBean> getscoreonelist(ScoreBean score)throws Exception;

}
