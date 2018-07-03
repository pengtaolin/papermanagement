package com.lin.paper.mapper;

import com.lin.paper.pojo.PNotice;
import com.lin.paper.pojo.PNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PNoticeMapper {
    int countByExample(PNoticeExample example);

    int deleteByExample(PNoticeExample example);

    int deleteByPrimaryKey(String noticeid);

    int insert(PNotice record);

    int insertSelective(PNotice record);

    List<PNotice> selectByExampleWithBLOBs(PNoticeExample example);

    List<PNotice> selectByExample(PNoticeExample example);

    PNotice selectByPrimaryKey(String noticeid);

    int updateByExampleSelective(@Param("record") PNotice record, @Param("example") PNoticeExample example);

    int updateByExampleWithBLOBs(@Param("record") PNotice record, @Param("example") PNoticeExample example);

    int updateByExample(@Param("record") PNotice record, @Param("example") PNoticeExample example);

    int updateByPrimaryKeySelective(PNotice record);

    int updateByPrimaryKeyWithBLOBs(PNotice record);

    int updateByPrimaryKey(PNotice record);
}