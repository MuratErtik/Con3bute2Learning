package org.example.contributetolearning.services;

import lombok.RequiredArgsConstructor;
import org.example.contributetolearning.configs.GithubApplicationProperties;
import org.example.contributetolearning.dtos.response.GithubIssueResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class GithubClientService {

    private final GithubApplicationProperties properties;

    private final RestTemplate restTemplate;



    public GithubIssueResponse[] listIssues(String owner, String repository, LocalDate since) {

        String issuesUrl = String.format("%s/repos/%s/%s/issues?since=%s",properties.getApiUrl(), owner, repository,since.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Token " + properties.getToken());

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<GithubIssueResponse[]> response = restTemplate.exchange(issuesUrl,HttpMethod.GET,entity, GithubIssueResponse[].class);

        return response.getBody();


    }


}
