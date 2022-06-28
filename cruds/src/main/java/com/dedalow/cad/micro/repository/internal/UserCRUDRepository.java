package com.dedalow.cad.micro.repository.internal;

import com.dedalow.cad.micro.domain.internal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCRUDRepository extends JpaRepository<User, Long> {}
