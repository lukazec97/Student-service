package lms.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.UserPermission;
import lms.repository.UserPermissionRepository;

@Service
public class UserPermissionService {
	@Autowired
	private UserPermissionRepository userPermissionRepository;

	public Set<UserPermission> getPermissionByUserId(Long id) {
		return userPermissionRepository.getByUserId(id);
	}
}