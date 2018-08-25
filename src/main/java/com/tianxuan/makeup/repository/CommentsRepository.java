package com.tianxuan.makeup.repository;

import com.tianxuan.makeup.dataobject.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-22 16:52
 **/
public interface CommentsRepository extends JpaRepository<Comments, String> {
}
