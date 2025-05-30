#include <stdio.h>
#include <string.h>
#include <errno.h>
#include <winsock2.h>

#include "defs.h"
#include "echoserver.h"

void echo(int socket_handle) {
  char buff[MAX];
  int len;
  ssize_t comm_len;
  SockAddrIn client_address;

  len = sizeof(client_address);

  while(TRUE) {
    // Clear buffer
    memset(&buff, 0, sizeof(buff));
    memset(&client_address, 0, sizeof(client_address));

    // Read message from client and copy it to the buffer
    comm_len = recvfrom(socket_handle, (char *) &buff, sizeof(buff), 0, (SockAddr *) &client_address, &len);
    if (comm_len < 0) {
      fprintf(stderr, "An error occurred while receiving data.\n");
      fprintf(stderr, "Error: %s\n", strerror(errno));
      break;
    }

    // Print buffer content
    fprintf(stdout, "[Message from client] %s\n", buff);

    // If incoming message contains "exit", finish server execution
    if (strncmp ("exit", buff, 4) == 0) {
      fprintf(stdout, "Server execution finished.\n");
      break;
    }

    // Send incoming message back to client (echo)
    comm_len = sendto(socket_handle, (char *) &buff, sizeof(buff), 0, (SockAddr *) &client_address, len);
    if (comm_len < 0) {
      fprintf(stderr, "An error occurred while sending data.\n");
      fprintf(stderr, "Error: %s\n", strerror(errno));
      break;
    }
  }
}
