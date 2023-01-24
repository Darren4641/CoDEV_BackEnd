package com.codevumc.codev_backend.service.co_projectrecruit;

import com.codevumc.codev_backend.errorhandler.CoDevResponse;
import com.codevumc.codev_backend.mapper.CoProjectMapper;
import com.codevumc.codev_backend.service.ResponseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class CoProjectRecruitServiceImpl extends ResponseService implements CoProjectRecruitService {
    private final CoProjectMapper coProjectMapper;

    @Override
    public CoDevResponse cancelCoRecruitOfProject(String co_email, long co_projectId) {
        Map<String, Object> recruitDto = new HashMap<>();
        recruitDto.put("co_email", co_email);
        recruitDto.put("co_projectId", co_projectId);
        try {
            boolean coRecruitStatus = coProjectMapper.getCoRecruitStatus(co_email, co_projectId);
            if (coRecruitStatus) {
                this.coProjectMapper.cancelCoRecruitOfProject(recruitDto);
                return setResponse(200, "message", "지원 취소되었습니다.");
            } else {
                return setResponse(403, "mesasage", "수정 권한이 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}