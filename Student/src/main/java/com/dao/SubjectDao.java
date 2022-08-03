package com.dao;

import com.entity.SubjectBean;

import java.util.List;

public interface SubjectDao {

    //查询出多条课程信息
    public List<SubjectBean> getSubject(SubjectBean subjectBean)throws Exception;
    //翻页处理
    public int getsbjpage(SubjectBean subjectBean)throws Exception;
    //查询出一条课程信息
    public SubjectBean getSubjectone(SubjectBean subjectBean)throws Exception;
    //删除一条课程信息
    public void subjectdel(SubjectBean subjectBean)throws Exception;
    //添加一条课程信息
    public void subjectadd(SubjectBean subjectBean)throws Exception;
    //修改一条课程信息
    public void subjectxiugai(SubjectBean subjectBean)throws Exception;

}
