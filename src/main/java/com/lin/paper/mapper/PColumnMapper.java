package com.lin.paper.mapper;

import com.lin.paper.pojo.PColumn;
import com.lin.paper.pojo.PColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PColumnMapper {
    int countByExample(PColumnExample example);

    int deleteByExample(PColumnExample example);

    int deleteByPrimaryKey(String columnid);

    int insert(PColumn record);

    int insertSelective(PColumn record);

    List<PColumn> selectByExample(PColumnExample example);

    PColumn selectByPrimaryKey(String columnid);

    int updateByExampleSelective(@Param("record") PColumn record, @Param("example") PColumnExample example);

    int updateByExample(@Param("record") PColumn record, @Param("example") PColumnExample example);

    int updateByPrimaryKeySelective(PColumn record);

    int updateByPrimaryKey(PColumn record);
}