package com.school.demo.services.imp;

import com.school.demo.dto.DemoDTO;
import com.school.demo.dto.assembler.DemoAssembler;
import com.school.demo.entity.Demo;
import com.school.demo.exceptions.runtime.InvalidIdException;
import com.school.demo.exceptions.runtime.SaveDemoException;
import com.school.demo.exceptions.runtime.UpdateDemoException;
import com.school.demo.repository.DemoRepository;
import com.school.demo.services.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Nicholas Dietz
 */

@Service
public class DemoServiceImp implements DemoService {

    private static Logger logger = LoggerFactory.getLogger(DemoServiceImp.class);

    @Autowired
    private DemoRepository demoRepository; // Singleton of DemoRepository

    @Autowired
    private DemoAssembler demoAssembler; // Singleton of DemoAssembler

    /**
     * GET ALL DEMO-OBJECTS SAVED IN DATABASE
     *
     * @return List of Demo-Objects
     */
    @Override
    public List<Demo> getAllFromRepoObj() {
        return (List<Demo>) this.demoRepository.findAll();
    }

    /**
     * GET ALL DEMO-OBJECTS SAVED IN DATABASE AS DTO
     *
     * @return List of DemoDTOs
     */
    @Override
    public List<DemoDTO> getAllFromRepoDTO() {
        return this.getAllFromRepoObj().stream()
                .filter(Objects::nonNull)
                .map(demoAssembler::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * GET DEMO-OBJECT FROM DB BY ID
     *
     * @param id Id of object
     * @return Matching Object
     */
    @Override
    public Demo getById(int id) {
        return this.getAllFromRepoObj().stream()
                .filter(Objects::nonNull)
                .filter(demo -> demo.getId() == id)
                .findFirst()
                .orElseThrow(InvalidIdException::new);
    }

    /**
     * GET DEMO-OBJECT FROM DB BY ID AS DTO
     *
     * @param id Id of object
     * @return Matching object as DTO.
     */
    @Override
    public DemoDTO getByIdDto(int id) {
        return this.demoAssembler.convertToDto(this.getById(id));
    }

    /**
     * SAVE DEMO-OBJECT IN DB
     *
     * @param demoDTO Object to be saved as DTO
     * @return Saved object as DTO
     */
    @Override
    public DemoDTO save(DemoDTO demoDTO) {
        try {
            Demo demo = demoAssembler.convertToObj(demoDTO);
            if (this.getAllFromRepoObj().stream()
                    .filter(Objects::nonNull)
                    .noneMatch(demo1 -> demo1.getId() == demo.getId())) {
                int id = demoRepository.save(demo).getId();
                demoDTO.setId(id);
                logger.info(String.format(">SAVE< STATUS:[OK] DEMO-DTO:[%s]", demoDTO.toString()));
                return this.getByIdDto(id);
            } else {
                throw new SaveDemoException();
            }
        } catch (Exception ex) {
            logger.error(String.format(">SAVE< STATUS:[FAILED] EX:[%s] DEMO-DTO:[%s]", ex.getClass().getSimpleName(), demoDTO.toString()));
            throw ex;
        }

    }

    /**
     * UPDATE DEMO-OBJECT ON DB
     *
     * @param demoDTO Object to be updated as DTO
     * @return Updated object as DTO
     */
    @Override
    public DemoDTO update(DemoDTO demoDTO) {
        try {
            Demo demo = demoAssembler.convertToObj(demoDTO);
            if (this.getAllFromRepoObj().stream()
                    .filter(Objects::nonNull)
                    .anyMatch(demo1 -> demo1.getId() == demo.getId())) {
                demoRepository.save(demo);
                logger.info(String.format(">UPDATE< STATUS:[OK] DEMO-DTO:[%s]", demoDTO.toString()));
                return this.getByIdDto(demo.getId());
            } else {
                throw new UpdateDemoException();
            }
        } catch (Exception ex) {
            logger.error(String.format(">UPDATE< STATUS:[FAILED] EX:[%s] DEMO-DTO:[%s]", ex.getClass().getSimpleName(), demoDTO.toString()));
            throw ex;
        }
    }

}
