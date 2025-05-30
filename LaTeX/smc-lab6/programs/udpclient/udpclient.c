#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <arpa/inet.h>
#include <sys/socket.h>

#include "defs.h"
#include "messageclient.h"

int main(int argc, char *argv[]) {
  if (argc < 3) {
    fprintf(stderr, "Usage: %s SERVER_IP SERVER_PORT.\n", argv[0]);
    fprintf(stderr, "Received only %d parameters.\n", argc);
    fprintf(stderr, "Execution aborted.\n");
    exit(EXIT_FAILURE);
  }

  int client_socket;
  SockAddrIn server_address;
  char *server_ip = argv[1];
  unsigned long int port = strtoul(argv[2], NULL, 0);

  // Create socket
  client_socket = socket(AF_INET, SOCK_DGRAM, 0);
  if (client_socket < 0) {
    fprintf(stderr, "Failed to create socket.\n");
    fprintf(stderr, "Error: %s\n", strerror(errno));
    exit(EXIT_FAILURE);
  } else {
    fprintf(stdout, "Socket successfully created.\n");
  }

  // Reset server address to 0 before usage
  memset(&server_address, 0, sizeof(server_address));

  // Set server address and port
  server_address.sin_family = AF_INET;
  server_address.sin_addr.s_addr = inet_addr(server_ip);
  server_address.sin_port = htons(port);

  // Function to send messages to server
  msgclient(client_socket, server_address);

  // Close the socket
  close(client_socket);

  return EXIT_SUCCESS;
}
