package org.example.contributetolearning.schedulers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.contributetolearning.dtos.response.GetAllRepositoryResponse;
import org.example.contributetolearning.managers.RepositoryManager;
import org.example.contributetolearning.models.Repository;
import org.example.contributetolearning.services.RepositoryService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ImportIssuesScheduler {

    private final RepositoryService repositoryService;

    private final RepositoryManager repositoryManager;

    @Scheduled(fixedRateString = "${application.import-frequency}")
    public void importIssues() {

        log.info("Import issues scheduler started");

        List<GetAllRepositoryResponse> repositories= repositoryService.getAllRepository();
        repositories.forEach(repository -> {
            Repository repo = Repository.builder()
                    .repository(repository.getName())
                    .organization(repository.getOrganization())
                    .build();
            repositoryManager.importIssue(repo);
        });

        log.info("Import issues scheduler finished");

    }
}
