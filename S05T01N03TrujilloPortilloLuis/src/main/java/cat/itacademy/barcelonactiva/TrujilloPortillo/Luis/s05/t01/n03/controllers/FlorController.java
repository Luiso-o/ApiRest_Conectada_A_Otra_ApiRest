package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n03.controllers;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n03.model.dto.FlorDto;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s05.t01.n03.model.services.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/flores")
public class FlorController {
    private final FlorService florService;

    @Autowired
    public FlorController(FlorService florService) {
        this.florService = florService;
    }

    @GetMapping
    public ResponseEntity<List<FlorDto>> getAllFlores() {
        List<FlorDto> flores = florService.getAllFlores();
        return ResponseEntity.ok(flores);
    }

    @PostMapping
    public ResponseEntity<Void> addFlor(@RequestBody FlorDto florDto) {
        florService.addFlor(florDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFlor(@PathVariable Long id, @RequestBody FlorDto florDto) {
        florService.updateFlor(id, florDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlor(@PathVariable Long id) {
        florService.deleteFlor(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlorDto> getFlorById(@PathVariable Long id) {
        FlorDto flor = florService.getFlorById(id);
        if (flor != null) {
            return ResponseEntity.ok(flor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
