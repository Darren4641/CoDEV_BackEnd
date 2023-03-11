package com.codevumc.codev_backend.service.co_qnaboard;


import com.codevumc.codev_backend.domain.CoQnaBoard;
import com.codevumc.codev_backend.errorhandler.CoDevResponse;

public interface CoQnaBoardService {
    void updateMainImg(String co_mainImg, long co_qnaId);
    CoDevResponse insertCoQnaBoard(CoQnaBoard coQnaBoard);
}