package microservice.entier.blog_service.service;

import jakarta.persistence.EntityNotFoundException;
import microservice.entier.blog_service.entity.Contact;
import microservice.entier.blog_service.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public Page<Contact> findAll(Pageable pageable, String keyword) {
        if (keyword != null && !keyword.trim().isEmpty()) {
            return contactRepository.findByTitleContainingIgnoreCase(keyword, pageable);
        } else {
            return contactRepository.findAll(pageable);
        }
    }


    public Contact findOne(Long id) {
        return contactRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Không có"));
    }

    public Contact createOne(Contact one) {
        return contactRepository.save(one);
    }

    public Contact updateOne(Long id, Contact object) {
        Contact one = findOne(id);
        one.setTitle(object.getTitle());
        one.setContent(object.getContent());
        one.setCareer(object.getCareer());
        one.setAuthor(object.getAuthor());
        one.setPhoneNumber(object.getPhoneNumber());
        one.setEmail(object.getEmail());
        return contactRepository.save(one);
    }

    public void deleteOne(Long id) {
        contactRepository.delete(findOne(id));
    }
}
