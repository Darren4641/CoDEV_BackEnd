package com.codevumc.codev_backend.mapper;

import com.codevumc.codev_backend.domain.CoCommentOfQnaBoard;
import com.codevumc.codev_backend.domain.CoQnaBoard;
import com.codevumc.codev_backend.domain.CoReCommentOfQnaBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface CoQnaBoardMapper {

    void updateCoMainImg(@Param("co_mainImg") String co_mainImg, @Param("co_qnaId") long co_qnaId);
    void insertCoQnaBoard(CoQnaBoard coQnaBoard);
    void insertCoCommentOfQnaBoard(CoCommentOfQnaBoard coCommentOfQnaBoard);
    Long getCoMarkOfQnaBoardEmail(String co_email, long co_qnaId);
    void insertCoMarkOfQnaBoard(String co_email, long co_qnaId);
    void deleteCoMarkOfQnaBoard(String co_email, long co_qnaId);
    void insertCoReCommentOfQnaBoard(CoReCommentOfQnaBoard coReCommentOfQnaBoard);
    Optional<CoQnaBoard> getCoQnaBoardByViewer(Map<String, Object> coQnaBoardDto);
    List<CoCommentOfQnaBoard> getComment(long co_qnaId);
    List<CoQnaBoard> getAllQnaBoards(Map<String, Object> condition);
}
