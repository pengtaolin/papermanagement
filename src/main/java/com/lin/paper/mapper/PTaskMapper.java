package com.lin.paper.mapper;

import com.lin.paper.pojo.PTask;
import com.lin.paper.pojo.PTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PTaskMapper {
    int countByExample(PTaskExample example);

    int deleteByExample(PTaskExample example);

    int deleteByPrimaryKey(String taskid);

    int insert(PTask record);

    int insertSelective(PTask record);

    List<PTask> selectByExample(PTaskExample example);

    PTask selectByPrimaryKey(String taskid);

    int updateByExampleSelective(@Param("record") PTask record, @Param("example") PTaskExample example);

    int updateByExample(@Param("record") PTask record, @Param("example") PTaskExample example);

    int updateByPrimaryKeySelective(PTask record);

    int updateByPrimaryKey(PTask record);
}