package com.ssafy.study.board.enitity;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    //fetch join N+1문제 해결 방법
    @EntityGraph(attributePaths = "member")
    List<Board> findAll();

    Optional<Board> findById(Long id);

    @EntityGraph(attributePaths = "member")
    List<Board> findByMemberId(Long id);

}
