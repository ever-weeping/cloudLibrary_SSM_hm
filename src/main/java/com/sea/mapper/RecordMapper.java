package com.sea.mapper;

import com.github.pagehelper.Page;
import com.sea.domain.Record;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface RecordMapper {
    // 新增借阅记录
    Integer addRecord(Record record);

    @Select({
            "<script> " +
                    "select * from record " +
                    "where 1=1 " +
                    "<if test=\"borrower != null\"> and record_borrower like concat('%',#{borrower},'%')</if> " +
                    "<if test=\"bookname != null\"> and record_bookname like concat('%',#{bookname},'%')</if> " +
                    "order by record_remandtime DESC " +
                    "</script>"
    })
    @Results(id = "recordMap", value = {
            // id 字段默认为false,表示不是主键
            // column 表示数据库表字段，property 表示实体类属性名
            @Result(id = true,column = "record_id",property = "id"),
            @Result(column = "record_bookname",property = "bookname"),
            @Result(column = "record_bookisbn",property = "bookisbn"),
            @Result(column = "record_borrower",property = "borrower"),
            @Result(column = "record_borrowTime",property = "borrowTime"),
            @Result(column = "record_remandTime",property = "remandTime"),
    })
    Page<Record> searchRecords(Record record); // 查询借阅记录
}
