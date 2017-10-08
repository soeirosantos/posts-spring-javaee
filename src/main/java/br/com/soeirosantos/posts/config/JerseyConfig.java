package br.com.soeirosantos.posts.config;

import br.com.soeirosantos.posts.web.endpoints.PostEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(PostEndpoint.class);
    }
}
