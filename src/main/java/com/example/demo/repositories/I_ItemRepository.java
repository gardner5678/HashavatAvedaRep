
package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Items;

@Repository
public interface I_ItemRepository extends JpaRepository<Items, Long> {
}
