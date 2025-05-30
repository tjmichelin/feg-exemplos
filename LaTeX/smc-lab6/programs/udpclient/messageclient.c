#include <stdio.h>
#include <string.h>
#include <errno.h>
#include <stdbool.h>

#include <sys/socket.h>
#include <netinet/in.h>

#include "defs.h"
#include "messageclient.h"

void msgclient(int socket_handle, SockAddrIn server_address) {
  char buff[MAX];
  char letter;
  int n;
  ssize_t comm_len;
  socklen_t recv_len = 0;

  while (true) {
    // Clear buffer
    memset(&buff, 0, sizeof(buff));
    memset(&letter, 0, sizeof(letter));
    n = 0;

    fprintf(stdout, "Type a message: ");
    while (TRUE) {
      letter = getchar();

      if (letter == '\n') break;

      buff[n] = letter;
      n++;
    }

    // Send message via socket
    comm_len = sendto(socket_handle, (char *) &buff, sizeof(buff), 0, (SockAddr *) &server_address, sizeof(server_address));
    if (comm_len < 0) {
      fprintf(stderr, "An error occurred while sending data.\n");
      fprintf(stderr, "Error: %s\n", strerror(errno));
      break;
    }

    int compare_result = strncmp(buff, "exit", 4);
    if (compare_result == 0) {
      fprintf(stdout, "Client exit...\n");
      break;
    }

    // Clear buffer
    memset(&buff, 0, sizeof(buff));

    recv_len = sizeof(server_address);
    // Wait for server response
    comm_len = recvfrom(socket_handle, (char *) &buff, sizeof(buff), 0, (SockAddr *) &server_address, &recv_len);
    if (comm_len < 0) {
      fprintf(stderr, "An error occurred while receiving data.\n");
      fprintf(stderr, "Error: %s\n", strerror(errno));
      break;
    }

    fprintf(stdout, "Received from Server: %s\n", buff);
  }
}

