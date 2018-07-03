package com.lin.paper.mapper;

import com.lin.paper.pojo.PSubject;
import com.lin.paper.pojo.PSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PSubjectMapper {
    int countByExample(PSubjectExample example);

    int deleteByExample(PSubjectExample example);

    int deleteByPrimaryKey(String subjectid);

    int insert(PSubject record);

    int insertSelective(PSubject record);

    List<PSubject> selectByExampleWithBLOBs(PSubjectExample example);

    List<PSubject> selectByExample(PSubjectExample example);

    PSubject selectByPrimaryKey(String subjectid);

    int updateByExampleSelective(@Param("record") PSubject record, @Param("example") PSubjectExample example);

    int updateByExampleWithBLOBs(@Param("record") PSubject record, @Param("example") PSubjectExample example);

    int updateByExample(@Param("record") PSubject record, @Param("example") PSubjectExample example);

    int updateByPrimaryKeySelective(PSubject record);

    int updateByPrimaryKeyWithBLOBs(PSubject record);

    int updateByPrimaryKey(PSubject record);
}