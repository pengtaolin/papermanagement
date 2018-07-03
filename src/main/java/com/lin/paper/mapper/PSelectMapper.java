package com.lin.paper.mapper;

import com.lin.paper.pojo.PSelect;
import com.lin.paper.pojo.PSelectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PSelectMapper {
    int countByExample(PSelectExample example);

    int deleteByExample(PSelectExample example);

    int deleteByPrimaryKey(String selectid);

    int insert(PSelect record);

    int insertSelective(PSelect record);

    List<PSelect> selectByExample(PSelectExample example);

    PSelect selectByPrimaryKey(String selectid);

    int updateByExampleSelective(@Param("record") PSelect record, @Param("example") PSelectExample example);

    int updateByExample(@Param("record") PSelect record, @Param("example") PSelectExample example);

    int updateByPrimaryKeySelective(PSelect record);

    int updateByPrimaryKey(PSelect record);
}