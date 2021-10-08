package com.neo.ppmtool.repositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.neo.ppmtool.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {

   Project findByProjectIdentifier(String projectIdentifier);

}

