package org.example.bootswaggerex.controller;

import lombok.extern.java.Log;
import org.example.bootswaggerex.model.dto.MyFile;
import org.example.bootswaggerex.model.repository.MyFileRepository;
import org.example.bootswaggerex.service.StorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/file")
@Log
public class FileController {
    private final StorageService storageService;
    private final MyFileRepository myFileRepository;

    public FileController(StorageService storageService, MyFileRepository myFileRepository) {
        this.storageService = storageService;
        this.myFileRepository = myFileRepository;
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Void> upload(@RequestParam("files") MultipartFile[] files) throws Exception {
        for (MultipartFile file : files) {
            log.info(file.getOriginalFilename());
            String dbFilename = storageService.upload(file);
            log.info(dbFilename);
            MyFile myFile = new MyFile();
            myFile.setFilename(dbFilename);
            myFileRepository.save(myFile);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<MyFile>> getAll() {
        return ResponseEntity.ok(myFileRepository.findAll());
    }
}