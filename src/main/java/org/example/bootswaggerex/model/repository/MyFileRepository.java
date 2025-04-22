package org.example.bootswaggerex.model.repository;

import org.example.bootswaggerex.model.dto.MyFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyFileRepository extends JpaRepository<MyFile, String> {
}
