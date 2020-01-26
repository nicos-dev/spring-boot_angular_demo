package com.school.demo.dto.assembler;

import com.school.demo.dto.DemoDTO;
import com.school.demo.exceptions.runtime.DemoAssemblerException;
import com.school.demo.entity.Demo;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nicholas Dietz
 */

@Configuration
public class DemoAssembler {

    /**
     * Convert from Demo-Entity to Demo-DTO
     *
     * @param demo Object to be converted to DTO.
     * @return DTO generated from Object.
     */
    public DemoDTO convertToDto(Demo demo) {
        try {
            DemoDTO demoDTO = new DemoDTO();
            demoDTO.setId(demo.getId());
            demoDTO.setSampleText(demo.getSampleText());
            return demoDTO;
        } catch (Exception ex) {
            throw new DemoAssemblerException(ex.getClass().getSimpleName());
        }

    }

    /**
     * Convert from Demo-Entity to Demo-DTO
     *
     * @param demoDTO DTO to be converted to Object
     * @return Object generated from DTO.
     */
    public Demo convertToObj(DemoDTO demoDTO) {
        try {
            Demo demo = new Demo();
            demo.setId(demoDTO.getId());
            demo.setSampleText(demoDTO.getSampleText());
            return demo;
        } catch (Exception ex) {
            throw new DemoAssemblerException(ex.getClass().getSimpleName());
        }
    }

}
