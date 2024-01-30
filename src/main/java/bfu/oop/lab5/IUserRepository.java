package bfu.oop.lab5;

public interface IUserRepository extends IRepository<User> {
    User getById(int id);
    User getByLogin(String login);
}
