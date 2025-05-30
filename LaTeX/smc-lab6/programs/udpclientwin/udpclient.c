#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>
#include <winsock2.h>

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
  WSADATA wsaData;
  char *server_ip = argv[1];
  unsigned long int port = strtoul(argv[2], NULL, 0);

  /* Load Winsock 2.0 DLL */
  int load_result = WSAStartup(MAKEWORD(2, 2), &wsaData);
  if (load_result != 0) {
    fprintf(stderr, "Failed to load Winsock library.\n");
    exit(EXIT_FAILURE);
  }

  // Create Socket
  client_socket = socket(AF_INET, SOCK_DGRAM, 0);
  if(client_socket < 0) {
    fprintf(stderr, "Failed to create socket.\n");
    fprintf(stderr, "Error: %s\n", strerror(errno));
    exit(EXIT_FAILURE);
  } else {
    fprintf(stdout, "Socket successfully created.\n");
  }

  memset(&server_address, 0, sizeof(server_address));

  // Set server address and port
  server_address.sin_family = AF_INET;
  server_address.sin_addr.s_addr = inet_addr(server_ip);
  server_address.sin_port = htons(port);

  // Function to send messages to server
  msgclient(client_socket, server_address);

  // Close socket
  closesocket(client_socket);
  WSACleanup();
  return 0;
}
