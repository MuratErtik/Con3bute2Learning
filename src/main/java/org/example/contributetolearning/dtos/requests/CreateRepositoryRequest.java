package org.example.contributetolearning.dtos.requests;


import lombok.Data;

@Data
public class CreateRepositoryRequest {

    private String organization;
    private String repository;
}
