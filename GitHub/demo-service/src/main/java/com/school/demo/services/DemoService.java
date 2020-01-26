package com.school.demo.services;

import com.school.demo.dto.DemoDTO;
import com.school.demo.entity.Demo;

import java.util.List;

/**
 * @author Nicholas Dietz
 */


public interface DemoService {

    /*
        ---------------------------
        INTERFACE OF DemoServiceImp
        ---------------------------
     */

    public List<Demo> getAllFromRepoObj();

    public List<DemoDTO> getAllFromRepoDTO();

    public Demo getById(int id);

    public DemoDTO getByIdDto(int id);

    DemoDTO save(DemoDTO demoDTO);

    DemoDTO update(DemoDTO demoDTO);

}
