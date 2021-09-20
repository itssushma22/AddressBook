package com.restapi.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.addressbook.dto.AddressDto;

@Repository
public interface AddressRepository extends JpaRepository<AddressDto,Long>{

}
