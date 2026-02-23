package org.example.contributetolearning.repositories;

import org.example.contributetolearning.models.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {


}
