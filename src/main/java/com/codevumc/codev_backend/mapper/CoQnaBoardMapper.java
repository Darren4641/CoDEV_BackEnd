package com.codevumc.codev_backend.mapper;

import com.codevumc.codev_backend.domain.CoQnaBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CoQnaBoardMapper {

    void updateCoMainImg(@Param("co_mainImg") String co_mainImg, @Param("co_qnaId") long co_qnaId);

    void insertCoQnaBoard(CoQnaBoard coQnaBoard);
}