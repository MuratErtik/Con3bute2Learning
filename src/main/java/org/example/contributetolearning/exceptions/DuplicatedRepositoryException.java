package org.example.contributetolearning.exceptions;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.web.servlet.FilterRegistration;

@Data
@ToString(callSuper = true)
public class DuplicatedRepositoryException extends RuntimeException {

    public DuplicatedRepositoryException(String organization,String repository) {

        super("Repository " + repository + " already exists in repository " + organization);

        //super(String.format("Organization: %s Repository: %s is not found.",organization,repository));
    }

}
