package lms.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lms.domain.UserPermission;

@Repository
public interface UserPermissionRepository extends CrudRepository<UserPermission, Long>{
	Set<UserPermission> getByUserId(Long id);
}