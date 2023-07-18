package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n03.model.domain.Flor;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n03.model.dto.FlorDto;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n03.model.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlorService {
    private final FlorRepository florRepository;

    @Autowired
    public FlorService(FlorRepository florRepository) {
        this.florRepository = florRepository;
    }

    public List<FlorDto> getAllFlores() {
        List<FlorDto> flores = List.of(florRepository.getAllFlores());
        return flores.stream()
                .map(flor -> new FlorDto(flor.getNombreFlor(), flor.getPaisFlor(), flor.getTipoFlor()))
                .collect(Collectors.toList());
    }

    public void addFlor(FlorDto florDto) {
        Flor flor = new Flor(florDto.getNombreFlor(), florDto.getPaisFlor(), florDto.getTipoFlor());
        florRepository.addFlor(flor);
    }

    public void updateFlor(Long id, FlorDto florDto) {
        FlorDto flor = new FlorDto(florDto.getNombreFlor(), florDto.getPaisFlor(), florDto.getTipoFlor());
        florRepository.updateFlor(String.valueOf(id), florDto);
    }

    public void deleteFlor(Long id) {
        florRepository.deleteFlor(id.toString());
    }

    public FlorDto getFlorById(Long id) {
        FlorDto flor = florRepository.getFlorById(id.toString());
        if (flor != null) {
            return new FlorDto(flor.getNombreFlor(), flor.getPaisFlor(), flor.getTipoFlor());
        }
        return null;
    }
}
