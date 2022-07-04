# TCP-Socket
TCP socket is a connection-oriented socket that uses the Transmission Control Protocol (TCP). It requires three packets to set up a connection: the SYN packet, the SYN-ACK packet, and the ACK packet. TCP socket is defined by the IP address of the machine and the port it uses. The TCP socket guarantees that all data is received and acknowledged.

For example, we are sending an HTTP request from our client at 120.1.1.1 to the website at 189.1.1.1. The server for that website will use well-known port number 80, so its socket is 189.1.1.1:80, as we saw before. we have been ephemeral port number 3022 for the web browser, so the client socket is 120.1.1.1:3022. The overall connection between these devices can be described using this socket pair: (189.1.1.1:80, 120.1.1.1:3022).
