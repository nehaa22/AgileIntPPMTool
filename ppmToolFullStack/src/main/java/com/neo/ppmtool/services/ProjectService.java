package com.neo.ppmtool.services;

import com.neo.ppmtool.domain.Project;
import com.neo.ppmtool.exceptions.ProjectIdException;
import com.neo.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception ex) {
            throw new ProjectIdException("project Id '" + project.getProjectIdentifier().toUpperCase() + "' already exist");
        }

    }

    public Project findProjectByIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if (project == null) {
            throw new ProjectIdException("project Id '" +projectId +"' Does Not exist");
        }
        return project;
    }
}
