package sn.isi.securiteweb.dto;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import sn.isi.securiteweb.entities.Droits;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class DroitsDto {

    private String id;

    private String name;



    public DroitsDto() {}

    public DroitsDto(Droits droits) {
        try {
            BeanUtils.copyProperties(this, droits);
        } catch (Exception e) {
            // do anything
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
