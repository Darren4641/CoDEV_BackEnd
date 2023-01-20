package com.codevumc.codev_backend.mapper;

import com.codevumc.codev_backend.domain.CoStudy;
import com.codevumc.codev_backend.domain.CoLanguage;
import com.codevumc.codev_backend.domain.CoHeartOfStudy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CoStudyMapper {
    void insertCoStudy(CoStudy coStudy);
    void insertCoLanguageOfStudy(long co_studyId, long co_languageId);
    void updateCoMainImg(@Param("co_mainImg") String co_mainImg, @Param("co_studyId") long co_studyId);
    void insertCoPartOfStudy(Map<String, Object>coPartDto);
    Optional<CoStudy> getCoStudy(long co_studyId);
    List<CoLanguage> getCoLanguageList(long co_studyId);
    long getCoHeartCount(long co_studyId);
    Optional<CoHeartOfStudy> getCoHeartOfStudy(Long co_studyId);
    void insertCoHeartOfStudy(String co_email, Long co_studyId);
    void deleteCoHeartOfStudy(String co_email, Long co_studyId);
    List<CoStudy> getCoStudies(Map<String, Object> condition);
}