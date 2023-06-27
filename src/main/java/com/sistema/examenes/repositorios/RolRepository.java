package com.sistema.examenes.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.examenes.modelo.usuario.Rol;

public interface RolRepository extends JpaRepository<Rol,Long> {
}
