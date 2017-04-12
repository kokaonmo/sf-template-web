package com.exem.sf.repository;

import com.exem.sf.domain.Member;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dev on 2017. 3. 21..
 */
public interface MemberRepository extends CrudRepository<Member, Long>{
}