package com.sea.service;

import com.sea.domain.Record;
import com.sea.domain.User;
import com.sea.entity.PageResult;

public interface RecordService {
    // 新增借阅记录
    Integer addRecord(Record record);
    // 查询借阅记录
    PageResult searchRecord(Record record, User user, Integer pageNum, Integer pageSize);
}
