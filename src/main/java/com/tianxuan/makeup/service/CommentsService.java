package com.tianxuan.makeup.service;

import com.tianxuan.makeup.dataobject.Comments;

import java.util.List;

/**
 * @program: makeup
 * @description: 评价
 * @author: Petrichor
 * @create: 2018-08-22 17:36
 **/
public interface CommentsService {
    //查询所有评价
    List<Comments> findAll();
}
