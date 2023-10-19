package tech.hidetora.pdfinvoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.hidetora.pdfinvoice.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
}
