package com.imooc.mall.dao;

import com.imooc.mall.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * 开发生成器: 连接数据库 -> 获取表结构 -> 生成文件
 * Created by 廖师兄
 * 2035-01-18 18:25
 */
//@Mapper
@Repository
public interface CategoryMapper {

	@Select("select * from mall_category where id = #{id}")
	Category findById(@Param("id") Integer id);

	Category queryById(Integer id);
}
