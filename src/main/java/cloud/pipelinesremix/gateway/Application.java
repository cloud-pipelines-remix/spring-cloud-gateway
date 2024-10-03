package cloud.pipelinesremix.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

@Controller
@ResponseBody
class FallbackController {

	@RequestMapping("/vault-fallback")
	public Mono<String> vault() {
		return Mono.just("Unable to connect to Vault");
	}

	@RequestMapping("/concourse-fallback")
	public Mono<String> concourse() {
		return Mono.just("Unable to connect to Concourse");
	}
}
