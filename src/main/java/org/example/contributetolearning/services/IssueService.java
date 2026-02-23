package org.example.contributetolearning.services;

import lombok.RequiredArgsConstructor;
import org.example.contributetolearning.models.Issue;
import org.example.contributetolearning.repositories.IssueRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;


    @Transactional
    public void importAll(List<Issue> issues) {

        issueRepository.saveAll(issues);
    }
}
