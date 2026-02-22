package org.example.contributetolearning.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.util.ArrayList;
import java.util.Date;




@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GithubIssueResponse {

    public String url;

    @JsonProperty("repository_url")
    public String repositoryUrl;

    @JsonProperty("labels_url")
    public String labelsUrl;

    @JsonProperty("comments_url")
    public String commentsUrl;

    @JsonProperty("events_url")
    public String eventsUrl;

    @JsonProperty("html_url")
    public String htmlUrl;

    public Long id;

    @JsonProperty("node_id")
    public String nodeId;

    public Integer number;
    public String title;
    public User user;
    public ArrayList<Label> labels;
    public String state;
    public Boolean locked;
    public Object assignee;
    public ArrayList<Assignee> assignees;
    public Object milestone;
    public Integer comments;

    @JsonProperty("created_at")
    public Date createdAt;

    @JsonProperty("updated_at")
    public Date updatedAt;

    @JsonProperty("closed_at")
    public Object closedAt;

    @JsonProperty("author_association")
    public String authorAssociation;

    @JsonProperty("active_lock_reason")
    public Object activeLockReason;

    public Boolean draft;

    @JsonProperty("pull_request")
    public PullRequest pullRequest;

    public String body;

    @JsonProperty("closed_by")
    public Object closedBy;

    public Reactions reactions;

    @JsonProperty("timeline_url")
    public String timelineUrl;

    @JsonProperty("performed_via_github_app")
    public Object performedViaGithubApp;

    @JsonProperty("state_reason")
    public Object stateReason;

    public static class User {
        public String login;
        public Integer id;

        @JsonProperty("node_id")
        public String nodeId;

        @JsonProperty("avatar_url")
        public String avatarUrl;

        @JsonProperty("gravatar_id")
        public String gravatarId;

        public String url;

        @JsonProperty("html_url")
        public String htmlUrl;

        @JsonProperty("followers_url")
        public String followersUrl;

        @JsonProperty("following_url")
        public String followingUrl;

        @JsonProperty("gists_url")
        public String gistsUrl;

        @JsonProperty("starred_url")
        public String starredUrl;

        @JsonProperty("subscriptions_url")
        public String subscriptionsUrl;

        @JsonProperty("organizations_url")
        public String organizationsUrl;

        @JsonProperty("repos_url")
        public String reposUrl;

        @JsonProperty("events_url")
        public String eventsUrl;

        @JsonProperty("received_events_url")
        public String receivedEventsUrl;

        public String type;

        @JsonProperty("user_view_type")
        public String userViewType;

        @JsonProperty("site_admin")
        public Boolean siteAdmin;
    }

    public static class PullRequest {
        public String url;

        @JsonProperty("html_url")
        public String htmlUrl;

        @JsonProperty("diff_url")
        public String diffUrl;

        @JsonProperty("patch_url")
        public String patchUrl;

        @JsonProperty("merged_at")
        public Object mergedAt;
    }

    public static class Reactions {
        public String url;

        @JsonProperty("total_count")
        public Integer totalCount;

        public Integer increase = 1; // "increse" yazım hatasını "increase" olarak düzelttim
        public Integer decrease = -1;
        public Integer laugh;
        public Integer hooray;
        public Integer confused;
        public Integer heart;
        public Integer rocket;
        public Integer eyes;
    }

    public static class Assignee {
        public String login;
        public Integer id;

        @JsonProperty("node_id")
        public String nodeId;

        @JsonProperty("avatar_url")
        public String avatarUrl;

        @JsonProperty("gravatar_id")
        public String gravatarId;

        public String url;

        @JsonProperty("html_url")
        public String htmlUrl;

        @JsonProperty("followers_url")
        public String followersUrl;

        @JsonProperty("following_url")
        public String followingUrl;

        @JsonProperty("gists_url")
        public String gistsUrl;

        @JsonProperty("starred_url")
        public String starredUrl;

        @JsonProperty("subscriptions_url")
        public String subscriptionsUrl;

        @JsonProperty("organizations_url")
        public String organizationsUrl;

        @JsonProperty("repos_url")
        public String reposUrl;

        @JsonProperty("events_url")
        public String eventsUrl;

        @JsonProperty("received_events_url")
        public String receivedEventsUrl;

        public String type;

        @JsonProperty("site_admin")
        public Boolean siteAdmin;
    }

    public static class Label {
        public Long id; // GitHub ID'leri genelde büyüktür, Long daha güvenlidir

        @JsonProperty("node_id")
        public String nodeId;

        public String name;
        public String url;
        public String color;

        @JsonProperty("default")
        public Boolean isDefault;
        public String description;
    }
}