package launcher;

public class Server {

	int ServerID;
	String name;
	int playerAmount;

	public Server(int serverID, String name, int playerAmount) {
		this.ServerID = serverID;
		this.name = name;
		this.playerAmount = playerAmount;
	}

	public int getServerID() {
		return ServerID;
	}

	public void setServerID(int serverID) {
		ServerID = serverID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlayerAmount() {
		return playerAmount;
	}

	public void setPlayerAmount(int playerAmount) {
		this.playerAmount = playerAmount;
	}

//	@Override
//	public String toString() {
//		return name;
//	}
}