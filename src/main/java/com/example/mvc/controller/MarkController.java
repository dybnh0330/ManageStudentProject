package com.example.mvc.controller;

import com.example.mvc.dto.MarkRequest;
import com.example.mvc.model.Mark;
import com.example.mvc.model.Student;
import com.example.mvc.service.ImplService.MarkImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Mark")
public class MarkController {
    @Autowired
    private MarkImplService markImplService;
    public MarkController(MarkImplService markImplService){
        this.markImplService = markImplService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> addMark(@RequestBody MarkRequest markRequest) {
        markImplService.addMark(markRequest);
        return ResponseEntity.ok().body("\"Add mark successfully\"");
    }

    @PutMapping(value = "/update/{studentID}/{subjectID}")
    public ResponseEntity<String> updateMark(@RequestBody Mark mark,@PathVariable long markID) {
        markImplService.updateMarkByID(mark, markID);
        return ResponseEntity.ok().body("\"Update mark successfully\"");

    }


    @GetMapping(value = "/findListMarkOfStudentByStudentID/{id}")
    public List<Mark> findListMarkOfStudentByStudentID(@PathVariable long id) {
      return  markImplService.findListMarkOfStudentByID(id);
    }

    @GetMapping(value = "/findMarkByStudentIDAndSubjectID/{studentID}/{subjectID}")
    public List<Mark> findMarkByStudentIDAndSubjectID(@PathVariable long studentID, @PathVariable long subjectID ) {
    return markImplService.findMarkByStudentIDAndSubjectID(studentID, subjectID);
    }

    @GetMapping(value = "/findSubjectWithHighestMark")
    public Mark findSubjectWithHighestMark() {
        return markImplService.findSubjectWithHighestMark();
    }


    @GetMapping(value = "/findSubjectWithLowestMark")
    public Mark findSubjectWithLowestMark() {
        return markImplService.findSubjectWithLowestMark();
    }







}
