package com.lin.paper.mapper;

import com.lin.paper.pojo.PInfo;
import com.lin.paper.pojo.PInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PInfoMapper {
    int countByExample(PInfoExample example);

    int deleteByExample(PInfoExample example);

    int deleteByPrimaryKey(String userid);

    int insert(PInfo record);

    int insertSelective(PInfo record);

    List<PInfo> selectByExample(PInfoExample example);

    PInfo selectByPrimaryKey(String userid);

    int updateByExampleSelective(@Param("record") PInfo record, @Param("example") PInfoExample example);

    int updateByExample(@Param("record") PInfo record, @Param("example") PInfoExample example);

    int updateByPrimaryKeySelective(PInfo record);

    int updateByPrimaryKey(PInfo record);
}