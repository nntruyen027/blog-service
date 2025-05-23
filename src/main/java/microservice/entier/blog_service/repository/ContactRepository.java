package microservice.entier.blog_service.repository;

import microservice.entier.blog_service.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Page<Contact> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
