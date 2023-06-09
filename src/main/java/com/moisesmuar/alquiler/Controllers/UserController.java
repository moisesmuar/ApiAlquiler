package com.moisesmuar.alquiler.Controllers;

import com.moisesmuar.alquiler.Clases.LoginResponse;
import com.moisesmuar.alquiler.Models.EmpresasModel;
import com.moisesmuar.alquiler.Models.UserModel;
import com.moisesmuar.alquiler.Repository.EmpresasRepository;
import com.moisesmuar.alquiler.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmpresasRepository empresasRepository;

    @GetMapping("")
    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }
    @PostMapping("/register")
    public String register( @RequestBody UserModel nuevoUsuario) {
        System.out.println("New User -> " + nuevoUsuario);
        System.out.println( "nif enviado cliente:  -> "+nuevoUsuario.getNif() );

        // si existe el nombre del user en bd
        List<UserModel> users = userRepository.findAll();
        for (UserModel u : users) {
            if (u.getUserName().equals(nuevoUsuario.getUserName())) {
                System.out.println("User already exists!");
                return "USER_ALREADY_EXISTS";
            }
        }

        // Si existe nif empresa en bd y es igual al capturado enviado por aplicación cliente
        List<EmpresasModel> empresas = empresasRepository.findAll();
        UserModel userInsert = null;
        for (EmpresasModel e : empresas) {
            System.out.println("EMPRESA: "+ e.getNif() );

            if (  e.getNif().equals( nuevoUsuario.getNif() ) ) {
                // la empresa existe crear objeto User para insercion en bd
                userInsert = new UserModel(nuevoUsuario.getUserName(), nuevoUsuario.getPassword(), e);
                userRepository.save( userInsert );
                return "SUCCESS";
            }

        }

        System.out.println("Unauthorized company");
        return "UNAUTHORIZED_COMPANY";
        //return "SUCCESS";
    }

  /*  @PostMapping("/login")
    public String login( @RequestBody UserModel user) {
        System.out.println("USUARIO QUE QUIERE LOGARSE ES:");
        System.out.println( user.getUserName() );
        System.out.println( user.getPassword() );
        List<UserModel> users = ur.findAll();

        for ( UserModel u: users ) {
            if (  u.getUserName().equals( user.getUserName() )
                    && u.getPassword().equals( user.getPassword() ) ) {
                return user.getUserName();
            }
        }
        return "FAILURE";
    }*/


    /*@PostMapping("/login")
    public Object login(@RequestBody UserModel user) {
        UserModel usuario = userRepository.findUsuarioWithEmpresaByUserNameAndPassword(user.getUserName(), user.getPassword());
        if (usuario != null) {
            return usuario;
        } else {
            return "FAILURE";
        }
    }*/

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody UserModel user) {
        UserModel usuario = userRepository.findUsuarioWithEmpresaByUserNameAndPassword(user.getUserName(), user.getPassword());
        if (usuario != null) {
            LoginResponse response = new LoginResponse();
            response.setUser(usuario);
            return ResponseEntity.ok(response);
        } else {
            LoginResponse response = new LoginResponse();
            response.setMessage("Credenciales inválidas");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
