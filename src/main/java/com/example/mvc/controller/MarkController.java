package com.example.mvc.controller;

import com.example.mvc.model.Mark;
import com.example.mvc.model.Student;
import com.example.mvc.service.ImplService.MarkImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarkController {
    @Autowired
    private MarkImplService markImplService;
    public MarkController(MarkImplService markImplService){
        this.markImplService = markImplService;
    }

    @PostMapping(value = "/mark/add")
    public void addMark(@RequestBody Mark mark) {
        markImplService.addMark(mark);
    }

    @PutMapping(value = "/mark/update/{studentID}/{subjectID}")
    public void updateMark(@RequestBody Mark mark,@PathVariable long studentID , @PathVariable long subjectID) {
        markImplService.updateMarkByStudentIDandSubjectID(mark, studentID, subjectID);
    }


    @GetMapping(value = "/mark/findListMarkOfStudentByStudentID/{id}")
    public void findListMarkOfStudentByStudentID(@PathVariable long id) {
        markImplService.findListMarkOfStudentByID(id);
    }

    @GetMapping(value = "/mark/findMarkByStudentIDAndSubjectID/{studentID}/{subjectID}")
    public void findMarkByStudentIDAndSubjectID(@PathVariable long studentID, @PathVariable long subjectID ) {
        markImplService.findMarkByStudentIDAndSubjectID(studentID, subjectID);
    }

    @GetMapping(value = "/mark/findSubjectWithHighestMark/{id}")
    public void findSubjectWithHighestMark() {
        markImplService.findSubjectWithHighestMark();
    }


    @GetMapping(value = "/mark/findSubjectWithLowestMark/{id}")
    public void findSubjectWithLowestMark() {
        markImplService.findSubjectWithLowestMark();
    }







}
