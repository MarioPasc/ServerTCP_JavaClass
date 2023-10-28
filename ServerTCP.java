import java.io.*;
import java.net.*;
import java.util.Scanner;

class ServerTCP {

	public static void main(String[] args) throws IOException {
		ServerSocket server = null;
		Socket client = null;
		BufferedReader in = null;
		PrintWriter out = null;
		// Scanner in = null;
		String line = "";
		int port = 12345; 
		// int count = 0;

		try {
			server = new ServerSocket(port);
			System.out.println("Inicio servidor " + server);
		} catch (IOException e) {
			System.out.println("Could not listen on port " + port);
			System.exit(-1);
		}

		while (true) 
		{
			try {
				client = server.accept();
				System.out.println("Nuevo cliente, socket " + client);
			} catch (IOException e) {
				System.out.println("Accept failed: " + port);
				System.exit(-1);
			}

			try {
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);

			} catch (IOException e) {
				System.out.println("Exception " + e);
				System.exit(-1);
			}

			boolean salir = false;
			while (!salir) {
				try {
					line = in.readLine();
					System.out.println("Received from client " + line);
					if (line.compareTo("END") != 0)

					{
						line = line.toUpperCase();
						line = (new StringBuffer(line)).reverse().toString();
						System.out.println("Sending to client " + line);
						out.println(line);
					}

					else 
					{
						out.println("OK");
						salir = true;
					}
				} catch (Exception e) {
					System.out.println("Read failed");
					System.exit(-1);
				}
			} 

			System.out.println("Closing connection with the client");
			in.close();
			out.close();
			client.close();
			System.out.println("Waiting for a new client");
		}
	}
}
