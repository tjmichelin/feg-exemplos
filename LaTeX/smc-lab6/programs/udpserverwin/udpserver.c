#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>
#include <winsock2.h>

#include "defs.h"
#include "echoserver.h"

int main(int argc, char *argv[]) {
    if (argc < 2) {
        fprintf(stderr, "Usage: %s SERVER_PORT.\n", argv[0]);
        fprintf(stderr, "Received only %d parameters.\n", argc);
        fprintf(stderr, "Execution aborted.\n");
        exit(EXIT_FAILURE);
    }

    int server_socket;
    SockAddrIn server_address;
    unsigned long int port = strtoul(argv[1], NULL, 0);
    WSADATA wsadata;

    /* Load Winsock 2.0 DLL */
    int load_result = WSAStartup(MAKEWORD(2, 2), &wsadata);
    if (load_result != 0) {
        fprintf(stderr, "Failed do load Winsock library.\n");
        exit(EXIT_FAILURE);
    }

    // Create socket
    server_socket = socket(AF_INET, SOCK_DGRAM, 0);
    if (server_socket < 0) {
        fprintf(stderr, "Failed to create socket.\n");
        fprintf(stderr, "Error: %s\n", strerror(errno));
        exit(EXIT_FAILURE);
    } else {
        fprintf(stdout, "Socket successfully created.\n");
    }

    // Reset server address to 0 before usage
    memset(&server_address, 0, sizeof(server_address));

    // Configure server IP address and PORT
    server_address.sin_family = AF_INET;
    server_address.sin_addr.s_addr = htonl(INADDR_ANY);
    server_address.sin_port = htons(port);

    // Bind newly created socket to IP address
    int bind_result = bind(server_socket, (SockAddr *) &server_address, sizeof(server_address));
    if (bind_result < 0) {
        fprintf(stderr, "Failed to bind socket to address.\n");
        fprintf(stderr, "Error: %s\n", strerror(errno));
        closesocket(server_socket);
        WSACleanup();
        exit(EXIT_FAILURE);
    } else {
        fprintf(stdout, "Socket successfully bound.\n");
    }

    // Echo function. Defined in echoserver.h
    echo(server_socket);

    // Close the socket when the server finishes its execution
    closesocket(server_socket);
    WSACleanup();
    return 0;
}
