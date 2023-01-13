package com.codevumc.codev_backend.service.co_file;

import com.codevumc.codev_backend.domain.CoPhotos;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface CoFileService {

    public CoPhotos storeFile(MultipartFile file, long co_projectId);
    public CoPhotos updateFile(MultipartFile file, long co_projectId) ;
    public ResponseEntity<Resource> loadFileAsResource(HttpServletRequest request, String fileName);
    public ResponseEntity<Resource> showImage(@RequestParam Map<String, String> param);
}
