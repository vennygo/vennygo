package com.vennygo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // API 문서의 메타데이터를 설정
                .info(new Info()
                        .title("Vennygo API")  // API의 제목 설정
                        .description("APIs for vennygo")  // API 설명 설정
                        .version("1.0.0")  // API 버전 설정
                        .contact(new Contact()  // API 담당자 정보 설정
                                .name("Venny")  // 담당자 이름
                                .url("https://www.vennygo.com")  // 담당자 웹사이트 URL
                                .email("vennygo00@gmail.com")  // 담당자 이메일
                        )
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                )
                // API가 배포된 서버들을 정의
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Local Server"),  // 로컬 서버 설정
                        new Server().url("https://www.vennygo.com").description("Production Server")  // 프로덕션 서버 설정
                ))
                // 외부 문서에 대한 링크를 설정
                .externalDocs(new ExternalDocumentation()
                        .description("Full API Documentation")  // 외부 문서 설명
                        .url("https://www.vennygo.com/api-docs")  // 외부 문서 URL
                )
                // API 태그를 설정하여 엔드포인트를 그룹화
                .tags(List.of(
                        new Tag().name("board").description("Operations related to boards"),
                        new Tag().name("sign-in").description("Operations related to sign-in")
                ))
                // API의 보안 요구 사항 설정 (보안 스키마)
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth")) // Bearer 토큰을 사용한 인증 스키마
                ;
    }
}