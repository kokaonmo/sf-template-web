package com.exem.sf.repository;

import com.exem.sf.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by CHOI SUNG HOON on 2017. 3. 21..
 */
public interface UserRepository extends JpaRepository<User, String> {
}