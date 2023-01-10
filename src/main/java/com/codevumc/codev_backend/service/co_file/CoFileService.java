package com.codevumc.codev_backend.service.co_file;

import com.codevumc.codev_backend.domain.CoPhotoOfProject;
import com.codevumc.codev_backend.domain.Photo;
import com.codevumc.codev_backend.errorhandler.CoDevResponse;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;
import java.util.Map;

public abstract class CoFileService {

    abstract public CoPhotoOfProject storeFile(MultipartFile file, long co_projectId);
    abstract public CoPhotoOfProject updateFile(MultipartFile file, long co_projectId) ;
    abstract public ResponseEntity<Resource> loadFileAsResource(HttpServletRequest request, String fileName);
    abstract public ResponseEntity<Resource> showImage(@RequestParam Map<String, String> param);
    abstract public Photo Test();
}
