package com.lin.paper.mapper;

import com.lin.paper.pojo.PPermission;
import com.lin.paper.pojo.PPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PPermissionMapper {
    int countByExample(PPermissionExample example);

    int deleteByExample(PPermissionExample example);

    int deleteByPrimaryKey(String permissionid);

    int insert(PPermission record);

    int insertSelective(PPermission record);

    List<PPermission> selectByExample(PPermissionExample example);

    PPermission selectByPrimaryKey(String permissionid);

    int updateByExampleSelective(@Param("record") PPermission record, @Param("example") PPermissionExample example);

    int updateByExample(@Param("record") PPermission record, @Param("example") PPermissionExample example);

    int updateByPrimaryKeySelective(PPermission record);

    int updateByPrimaryKey(PPermission record);
}