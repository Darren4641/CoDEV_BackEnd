package com.codevumc.codev_backend.service.co_projectheart;

import com.codevumc.codev_backend.domain.CoHeartOfProject;
import com.codevumc.codev_backend.errorhandler.CoDevResponse;
import com.codevumc.codev_backend.mapper.CoProjectMapper;
import com.codevumc.codev_backend.service.ResponseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CoProjectHeartServiceImpl extends ResponseService implements CoProjectHeartService {

    private final CoProjectMapper coProjectMapper;


    @Override
    public CoDevResponse insertHeart(String co_email, Long co_projectId){
        try{
            Optional<CoHeartOfProject> coHeartOfProject = coProjectMapper.getCoHeartOfProject(co_projectId);
            if(coHeartOfProject.isEmpty()) {
                this.coProjectMapper.insertCoHeartOfProject(co_email,co_projectId);
                setResponse(200, "Message", "찜등록이 완료되었습니다.");
            }


        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CoDevResponse deleteHeart(String co_email,Long co_projectId){
        try{
            Optional<CoHeartOfProject> coHeartOfProject = coProjectMapper.getCoHeartOfProject(co_projectId);
            if(coHeartOfProject.isPresent()) {
                this.coProjectMapper.deleteCoHeartOfProject(co_email,co_projectId);
                setResponse(200, "Message", "찜등록이 취소되었습니다.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}