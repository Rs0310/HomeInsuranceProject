package com.insurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.insurance.entities.Admin;

/*
 * Repository class
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	/*
	 * Queries
	 */
	@Query("SELECT admin FROM Admin admin WHERE admin.adminid=:adminid and admin.adminname=:name")
	public Admin checkLogin(@Param("adminid") int id, @Param("name") String name);

}
