package org.example.contributetolearning.repositories;

import org.example.contributetolearning.models.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import org.testcontainers.utility.DockerImageName;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(initializers = RepositoryRepositoryTestIT.initializer.class )
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("it")
@Testcontainers
class RepositoryRepositoryTestIT {

    public static final DockerImageName DOCKER_IMAGE_NAME = DockerImageName.parse("mysql:latest");

    @Container
    public static  MySQLContainer<?> mysql = new MySQLContainer<>(DOCKER_IMAGE_NAME);
    @Autowired
    private TestEntityManager testEntityManager;

    static class initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            TestPropertyValues.of("spring.datasource.url="+mysql.getJdbcUrl(),
                    "spring.datasource.username="+mysql.getUsername(),
                    "spring.datasource.password="+mysql.getPassword()).applyTo(applicationContext.getEnvironment());

        }
    }

    @Autowired
    private RepositoryRepository repositoryRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void it_should_find_all_repository() {

        Repository repository1 = Repository.builder()
                .organization("org1")
                .repository("repo1")
                .build();

        Repository repository2 = Repository.builder()
                .organization("org2")
                .repository("repo2")
                .build();


        repositoryRepository.saveAll(Arrays.asList(repository1, repository2));

        testEntityManager.flush();

        //when
        List<Repository> repos = repositoryRepository.findAll();

        //then
        then(repos.size()).isEqualTo(2);
        then(repos.get(0).getOrganization()).isEqualTo("org1");
        then(repos.get(0).getRepository()).isEqualTo("repo1");
        then(repos.get(1).getOrganization()).isEqualTo("org2");
        then(repos.get(1).getRepository()).isEqualTo("repo2");


    }







}