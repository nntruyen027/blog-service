package microservice.entier.blog_service.controller;

import microservice.entier.blog_service.entity.Contact;
import microservice.entier.blog_service.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("")
    public Page<Contact> findAll(Pageable pageable, @RequestParam(required = false) String keyword) {
        return contactService.findAll(pageable, keyword);
    }

    @GetMapping("/{id}")
    public Contact findOne(@PathVariable Long id) {
        return contactService.findOne(id);
    }

    @PostMapping("")
    public Contact createOne(@RequestBody Contact type) {
        return contactService.createOne(type);
    }

    @PutMapping("/{id}")
    public Contact updateOne(@PathVariable Long id, @RequestBody Contact type) {
        return contactService.updateOne(id, type);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id) {
        contactService.deleteOne(id);
        return ResponseEntity.noContent().build();
    }
}
