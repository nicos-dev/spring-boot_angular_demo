package com.school.demo.controller;

import com.school.demo.dto.DemoDTO;
import com.school.demo.dto.assembler.DemoAssembler;
import com.school.demo.services.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nicholas Dietz
 */

@RestController
@RequestMapping("api/v1/")
public class WebController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @Autowired
    private DemoAssembler demoAssembler;

    @Autowired
    private DemoService demoService;

    /**
     * GET DATA FROM DATABASE
     *
     * @return All demo-objects saved in DB as DTO
     */
    @GetMapping(path = "all")
    public ResponseEntity get() {
        logger.info(">GET ALL< STATUS:[OK]");
        return ResponseEntity.status(HttpStatus.OK).body(demoService.getAllFromRepoDTO());
    }

    /**
     * UPDATE OBJECT ON DATABASE
     *
     * @param demoDTO Object to be updated as DTO.
     * @return Updated object as DTO.
     */
    @PutMapping(path = "update")
    public ResponseEntity put(@RequestBody DemoDTO demoDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(demoService.update(demoDTO));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getClass().getSimpleName());
        }
    }

    /**
     * SAVE NEW OBJECT IN DATABASE
     *
     * @param demoDTO Object to be saved as DTO
     * @return Saved object as DTO.
     */
    @PostMapping(path = "create")
    public ResponseEntity post(@RequestBody DemoDTO demoDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(demoService.save(demoDTO));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getClass().getSimpleName());
        }
    }

}
