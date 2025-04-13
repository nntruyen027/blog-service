package microservice.entier.blog_service.client;

import microservice.entier.blog_service.config.FeignClientConfig;
import microservice.entier.blog_service.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth-service", url = "${auth.service.url}", configuration = FeignClientConfig.class)
public interface AuthServiceClient {
    @GetMapping(value = "/self")
    ResponseEntity<AccountDto> getUserByJwt(@RequestHeader("Authorization") String authorizationHeader);
}