package be.odisee.lucychang.dao;

import be.odisee.lucychang.domain.Rol;

public interface RolDao {

    public Rol saveRol(Rol rol);

    public Rol getRolById(int id);

    public Rol getRolByUserid(String userid);

}
