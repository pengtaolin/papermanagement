package com.lin.paper.mapper;

import com.lin.paper.pojo.PProgress;
import com.lin.paper.pojo.PProgressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PProgressMapper {
    int countByExample(PProgressExample example);

    int deleteByExample(PProgressExample example);

    int deleteByPrimaryKey(String progressid);

    int insert(PProgress record);

    int insertSelective(PProgress record);

    List<PProgress> selectByExampleWithBLOBs(PProgressExample example);

    List<PProgress> selectByExample(PProgressExample example);

    PProgress selectByPrimaryKey(String progressid);

    int updateByExampleSelective(@Param("record") PProgress record, @Param("example") PProgressExample example);

    int updateByExampleWithBLOBs(@Param("record") PProgress record, @Param("example") PProgressExample example);

    int updateByExample(@Param("record") PProgress record, @Param("example") PProgressExample example);

    int updateByPrimaryKeySelective(PProgress record);

    int updateByPrimaryKeyWithBLOBs(PProgress record);

    int updateByPrimaryKey(PProgress record);
}