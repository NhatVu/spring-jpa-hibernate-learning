package org.example.repository.two;

import org.example.entity.MessageTwoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageTwoRepository extends JpaRepository<MessageTwoEntity, Long> {
}
