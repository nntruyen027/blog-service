package microservice.entier.blog_service.service;

import jakarta.persistence.EntityNotFoundException;
import microservice.entier.blog_service.entity.ContactType;
import microservice.entier.blog_service.repository.ContactTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContactTypeService {
    @Autowired
    private ContactTypeRepository contactTypeRepository;

    public Page<ContactType> findAll(Pageable pageable, String keyword) {
        if(keyword != null && !keyword.trim().isEmpty()) {
            return contactTypeRepository.findByNameContainingIgnoreCase(keyword, pageable);
        }
        else {
            return contactTypeRepository.findAll(pageable);
        }
    }

    public ContactType findOne(Long id) {
        return contactTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Không có"));
    }

    public ContactType createOne(ContactType type) {
        return contactTypeRepository.save(type);
    }

    public ContactType updateOne(Long id, ContactType type) {
        ContactType one = findOne(id);
        one.setName(type.getName());
        one.setDescription(type.getDescription());
        return contactTypeRepository.save(one);
    }

    public void deleteOne(Long id) {
        ContactType one = findOne(id);
        contactTypeRepository.delete(one);
    }
}
