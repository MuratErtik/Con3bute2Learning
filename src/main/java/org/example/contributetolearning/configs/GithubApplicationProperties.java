package org.example.contributetolearning.configs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("github")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GithubApplicationProperties {

    private String apiUrl;

    private String token;
}
