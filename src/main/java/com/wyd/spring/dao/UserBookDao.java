package com.wyd.spring.dao;

import com.wyd.spring.model.UserBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Grated by wyd
 */
public interface UserBookDao {


    List<UserBook> queryUserBook();

    void delete(Integer[] ids);

    void save(UserBook userBook);
/**
 * 是否有user的数据，有则不能删除
 * */
    List<UserBook> queryUBuser(@Param("userName") String userName);
    /**
     * 是否有book的数据，有则不能删除
     * */
    List<UserBook> queryUBbook(@Param("name") String name);
}
