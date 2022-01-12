package com.ssafy.study.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c join fetch c.member join fetch c.board where c.board.id= :boardId")
    List<Comment> findByJoinBoardId(@Param("boardId") Long boardId);

    Integer countByBoardId(Long boardId);
}
