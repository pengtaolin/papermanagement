package com.lin.paper.mapper;

import com.lin.paper.pojo.PGroup;
import com.lin.paper.pojo.PGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PGroupMapper {
    int countByExample(PGroupExample example);

    int deleteByExample(PGroupExample example);

    int deleteByPrimaryKey(String groupid);

    int insert(PGroup record);

    int insertSelective(PGroup record);

    List<PGroup> selectByExample(PGroupExample example);

    PGroup selectByPrimaryKey(String groupid);

    int updateByExampleSelective(@Param("record") PGroup record, @Param("example") PGroupExample example);

    int updateByExample(@Param("record") PGroup record, @Param("example") PGroupExample example);

    int updateByPrimaryKeySelective(PGroup record);

    int updateByPrimaryKey(PGroup record);
}