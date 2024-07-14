package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.FacultyNotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty create (Faculty faculty) {
        faculty.setId(null);
        return facultyRepository.save(faculty);
    }

    public void update(long id,Faculty faculty) {
        Faculty oldFaculty = facultyRepository.findById(id)
                .orElseThrow(() -> new FacultyNotFoundException(id));
        oldFaculty.setName(faculty.getName());
        oldFaculty.setColor(faculty.getColor());
        facultyRepository.save(oldFaculty);
    }

    public Faculty get(long id) {
        return facultyRepository.findById(id).orElseThrow(() -> new FacultyNotFoundException(id));
    }

    public Faculty remove (long id) {
        Faculty faculty = facultyRepository.findById(id).orElseThrow(() -> new FacultyNotFoundException(id));
        facultyRepository.delete(faculty);
        return faculty;
    }

    public List<Faculty> getFacultyByColor(String color) {
        return facultyRepository.getFacultyByColor(color);
    }
}