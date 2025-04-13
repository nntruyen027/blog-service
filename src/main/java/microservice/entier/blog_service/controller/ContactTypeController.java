package microservice.entier.blog_service.controller;

import microservice.entier.blog_service.entity.ContactType;
import microservice.entier.blog_service.service.ContactTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact-types")
public class ContactTypeController {
    @Autowired
    private ContactTypeService contactTypeService;

    @GetMapping("")
    public Page<ContactType> findAll(Pageable pageable, @RequestParam(required = false) String keyword) {
        return contactTypeService.findAll(pageable, keyword);
    }

    @GetMapping("/{id}")
    public ContactType findOne(@PathVariable Long id) {
        return contactTypeService.findOne(id);
    }

    @PostMapping("")
    public ContactType createOne(@RequestBody ContactType type) {
        return contactTypeService.createOne(type);
    }

    @PutMapping("/{id}")
    public ContactType updateOne(@PathVariable Long id, @RequestBody ContactType type) {
        return contactTypeService.updateOne(id, type);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id) {
        contactTypeService.deleteOne(id);
        return ResponseEntity.noContent().build();
    }
}
