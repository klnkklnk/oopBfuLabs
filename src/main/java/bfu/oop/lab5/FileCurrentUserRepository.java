package bfu.oop.lab5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileCurrentUserRepository implements IRepository<User>
{
	private String filePath;
	private User user;
	
	public FileCurrentUserRepository(String filePath) {
		this.filePath = filePath;
		loadUserFromFile();
	}
	private void loadUserFromFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			if((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				int id = Integer.parseInt(parts[0]);
				String login = parts[1];
				String password = parts[2];
				String name = parts[3];
				user = new User(id, login, password, name);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void saveUserToFile() {
		if (user != null)
		{
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
			{
				String line = user.getId() + "," + user.getLogin() + "," + user.getPassword() + "," + user.getName();
				writer.write(line);
				writer.newLine();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			File file = new File(filePath);
			file.delete();
		}
	}
	public User getUser()
	{
		return user;
	}
	@Override
	public void add(User item)
	{
		user = item;
		saveUserToFile();
	}
	
	@Override
	public void remove(User item)
	{
		user = null;
		saveUserToFile();
	}
	
	@Override
	public void update(User item)
	{
		//
	}
}
