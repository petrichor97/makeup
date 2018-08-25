package com.tianxuan.makeup.service.impl;

import com.tianxuan.makeup.dataobject.Comments;
import com.tianxuan.makeup.repository.CommentsRepository;
import com.tianxuan.makeup.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: makeup
 * @description: 评价
 * @author: Petrichor
 * @create: 2018-08-22 17:37
 **/
@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepository repository;

    @Override
    public List<Comments> findAll() {
        return repository.findAll();
    }
}
