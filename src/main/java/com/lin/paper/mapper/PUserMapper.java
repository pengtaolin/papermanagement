package com.lin.paper.mapper;

import com.lin.paper.pojo.PUser;
import com.lin.paper.pojo.PUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PUserMapper {
    int countByExample(PUserExample example);

    int deleteByExample(PUserExample example);

    int deleteByPrimaryKey(String userid);

    int insert(PUser record);

    int insertSelective(PUser record);

    List<PUser> selectByExample(PUserExample example);

    PUser selectByPrimaryKey(String userid);

    int updateByExampleSelective(@Param("record") PUser record, @Param("example") PUserExample example);

    int updateByExample(@Param("record") PUser record, @Param("example") PUserExample example);

    int updateByPrimaryKeySelective(PUser record);

    int updateByPrimaryKey(PUser record);
}