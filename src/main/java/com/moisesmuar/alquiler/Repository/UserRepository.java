package com.moisesmuar.alquiler.Repository;

import com.moisesmuar.alquiler.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;  // interfaz
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Query("SELECT u FROM UserModel u JOIN FETCH u.empresa WHERE u.userName = :userName AND u.password = :password")
    UserModel findUsuarioWithEmpresaByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

}
