TARGET=udp_client
TARGET_SOURCES=udpclient.c messageclient.c

BINDIR=../bin

FLAGS=-O2 -Wall -MMD
LIBS=

INCLUDE=-I. -I../include/

CMP = gcc
LDFLAGS=$(LIBS)

all: install clean

install: $(TARGET)
	mkdir -p $(BINDIR)
	mv $(TARGET) $(BINDIR)

$(TARGET): $(TARGET_SOURCES:.c = .o)
	$(CMP) $(FLAGS) $(INCLUDE) -o $@ $^ $(LDFLAGS)

%.o: %.c
	$(CMP) $(FLAGS) $(INCLUDE) -c -o $@ $<

-include $(TARGET_SOURCES:.c=.d)

clean:
	@rm -rf *.o *.d *~

distclean: clean
	@rm $(TARGET)
