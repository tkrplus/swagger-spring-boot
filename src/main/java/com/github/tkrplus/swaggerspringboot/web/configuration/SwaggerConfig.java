package com.github.tkrplus.swaggerspringboot.web.configuration;


import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Value("${app.api.version}")
  private String version;

  @Value("${swagger.api.info.title}")
  private String title;

  @Value("${swagger.api.info.description}")
  private String description;

  @Bean
  public Docket swaggerPlugin() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("public api")
        .apiInfo(apiInfo())
        .select()
        .paths(paths())
        .build()
        .enableUrlTemplating(true);
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title(title)
        .description(description)
        .version(version)
        .build();
  }

  private Predicate<String> paths() {
    return Predicates.or(Predicates.containsPattern("/api"));
  }
}
