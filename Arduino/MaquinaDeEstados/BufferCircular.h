// BufferCircular.h

#ifndef BUFFERCIRCULAR_H_
#define BUFFERCIRCULAR_H_

#if (ARDUINO >= 100)
# include "Arduino.h"
#else
# include "WProgram.h"
#endif

#define SIZE 100

// É a mesma coisa que "public class BufferCircular<T>" em Java.
template <class T> class BufferCircular<T> {
private:
	T _data[SIZE];
	uint32_t _start;
	uint32_t _end;
	uint32_t _size;

public:
	BufferCircular();
	T read();
	void write(T);
	int available();
	void clear();
	T getEntry(uint32_t p);
	uint32_t getStart();
	uint32_t getEnd();
};

#endif /* BUFFERCIRCULAR_H_ */
