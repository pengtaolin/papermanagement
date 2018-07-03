package com.lin.paper.mapper;

import com.lin.paper.pojo.PScore;
import com.lin.paper.pojo.PScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PScoreMapper {
    int countByExample(PScoreExample example);

    int deleteByExample(PScoreExample example);

    int deleteByPrimaryKey(String scoreid);

    int insert(PScore record);

    int insertSelective(PScore record);

    List<PScore> selectByExample(PScoreExample example);

    PScore selectByPrimaryKey(String scoreid);

    int updateByExampleSelective(@Param("record") PScore record, @Param("example") PScoreExample example);

    int updateByExample(@Param("record") PScore record, @Param("example") PScoreExample example);

    int updateByPrimaryKeySelective(PScore record);

    int updateByPrimaryKey(PScore record);
}