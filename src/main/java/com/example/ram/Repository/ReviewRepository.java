package com.example.ram.Repository;

import com.example.ram.Entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // Public reviews with pagination
    Page<Review> findByApprovedTrue(Pageable pageable);

    // Pending reviews (for admin) with pagination
    Page<Review> findByApprovedFalse(Pageable pageable);
}
