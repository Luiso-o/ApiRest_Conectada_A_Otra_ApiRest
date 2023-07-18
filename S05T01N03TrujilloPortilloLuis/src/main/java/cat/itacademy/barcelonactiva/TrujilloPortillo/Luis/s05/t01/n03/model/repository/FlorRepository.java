package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n03.model.repository;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n03.model.domain.Flor;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n03.model.dto.FlorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class FlorRepository {
    private final WebClient webClient;

    @Autowired
    public FlorRepository(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:9001").build();
    }

    public FlorDto[] getAllFlores() {
        String apiUrl = "/flores";

        return webClient.get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(FlorDto[].class)
                .block();
    }

    public void addFlor(Flor florDto) {
        String apiUrl = "/flores";

        webClient.post()
                .uri(apiUrl)
                .bodyValue(florDto)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    public void updateFlor(String id, FlorDto florDto) {
        String apiUrl = "/flores/{id}";

        webClient.put()
                .uri(apiUrl, id)
                .bodyValue(florDto)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    public void deleteFlor(String id) {
        String apiUrl = "/flores/{id}";

        webClient.delete()
                .uri(apiUrl, id)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    public FlorDto getFlorById(String id) {
        String apiUrl = "/flores/{id}";

        return webClient.get()
                .uri(apiUrl, id)
                .retrieve()
                .bodyToMono(FlorDto.class)
                .block();
    }
}
