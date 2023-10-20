package tech.hidetora.pdfinvoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.hidetora.pdfinvoice.entity.Invoice;
import tech.hidetora.pdfinvoice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
