package bfu.oop.lab5;

import java.util.List;

public interface IUserRepository extends IRepository<User> {
    List<User> getAll();
    User getById(int id);
    User getByLogin(String login);
}
