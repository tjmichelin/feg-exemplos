TARGET=udpserver
TARGET_SOURCES=echoserver.c udpserver.c

FLAGS=-O2 -Wall -MMD
LIBS=-lws2_32

INCLUDE=-I. -I..\include
BINDIR=..\bin

CMP=gcc
LDFLAGS=$(LIBS) -LC:\mingw64\x86_64-w64-mingw32\lib

.PHONY=clean distclean

all: install clean

install: $(TARGET)
	if not exist $(BINDIR) md $(BINDIR)
	move $(TARGET).exe $(BINDIR)

$(TARGET): $(TARGET_SOURCES:.c=.o)
	$(CMP) $(FLAGS) $(INCLUDE) -o $@ $^ $(LDFLAGS)

%.o: %.c
	$(CMP) $(FLAGS) $(INCLUDE) -c -o $@ $<

-include $(TARGET_SOURCES:.c=.d)

clean:
	del *.o *.d *~

distclean: clean
	del $(TARGET).exe