package bfu.oop.lab5;

public interface ICurrentUserRepository extends IRepository<User>
{
	User getUser();
}
