package com.lin.paper.mapper;

import com.lin.paper.pojo.PRole;
import com.lin.paper.pojo.PRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PRoleMapper {
    int countByExample(PRoleExample example);

    int deleteByExample(PRoleExample example);

    int deleteByPrimaryKey(String roleid);

    int insert(PRole record);

    int insertSelective(PRole record);

    List<PRole> selectByExample(PRoleExample example);

    PRole selectByPrimaryKey(String roleid);

    int updateByExampleSelective(@Param("record") PRole record, @Param("example") PRoleExample example);

    int updateByExample(@Param("record") PRole record, @Param("example") PRoleExample example);

    int updateByPrimaryKeySelective(PRole record);

    int updateByPrimaryKey(PRole record);
}