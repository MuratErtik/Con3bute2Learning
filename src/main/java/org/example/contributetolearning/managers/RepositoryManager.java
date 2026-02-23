package org.example.contributetolearning.managers;

import lombok.RequiredArgsConstructor;
import org.example.contributetolearning.dtos.requests.CreateRepositoryRequest;
import org.example.contributetolearning.dtos.response.GithubIssueResponse;
import org.example.contributetolearning.models.Issue;
import org.example.contributetolearning.models.Repository;
import org.example.contributetolearning.services.GithubClientService;
import org.example.contributetolearning.services.IssueService;
import org.example.contributetolearning.services.RepositoryService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RepositoryManager {

    private final RepositoryService repositoryService;

    private final GithubClientService githubClientService;

    private final IssueService issueService;

    public void importRepository(CreateRepositoryRequest request) {

        repositoryService.createRepository(request);
    }


    @Async
    public void importIssue(Repository repository) {

        GithubIssueResponse[] githubIssueResponses = githubClientService.listIssues(repository.getOrganization(),repository.getRepository());

        List<Issue> issues = Arrays.stream(githubIssueResponses).map(githubIssue -> new Issue()).toList();

        issueService.importAll(issues);



    }
}
