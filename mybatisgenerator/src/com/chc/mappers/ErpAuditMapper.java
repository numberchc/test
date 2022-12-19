package com.chc.mappers;

import com.chc.model.ErpAudit;

public interface ErpAuditMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ErpAudit record);

    int insertSelective(ErpAudit record);

    ErpAudit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ErpAudit record);

    int updateByPrimaryKey(ErpAudit record);
}