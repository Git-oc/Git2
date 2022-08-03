package com.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentBean {

    @ExcelProperty(value = "学生id")
    private int stuId;
    @ExcelProperty(value = "学生姓名")
    private String stuName;
    @ExcelProperty(value = "学生性别")
    private String stuSex;
    @ExcelProperty(value = "系部")
    private String stuSystem;
    @ExcelProperty(value = "班级")
    private String stuClass;
    @ExcelProperty(value = "学生电话")
    private String stuPhone;

    private int page;

    public StudentBean(int stuId, String stuName, String stuSex, String stuSystem, String stuClass, String stuPhone) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuSystem = stuSystem;
        this.stuClass = stuClass;
        this.stuPhone = stuPhone;
    }
}
