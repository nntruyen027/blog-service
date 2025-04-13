package microservice.entier.blog_service.repository;

import microservice.entier.blog_service.entity.ContactType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactTypeRepository extends JpaRepository<ContactType, Long> {
    Page<ContactType> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
